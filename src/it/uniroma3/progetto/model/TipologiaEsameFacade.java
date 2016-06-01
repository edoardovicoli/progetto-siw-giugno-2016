package it.uniroma3.progetto.model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.progetto.model.TipologiaEsame;

/**
 * Session Bean implementation class TipologiaEsameFacade
 */
@Stateless
@LocalBean
public class TipologiaEsameFacade {
	@PersistenceContext(unitName = "labAnalisi-unit")
	private EntityManager em;
	
	public TipologiaEsame createTipologiaEsame(TipologiaEsame tipologiaEsame) {
		//TipologiaEsame tipologiaEsame = new TipologiaEsame(nome);
		if (em==null) {
			System.out.println("EM NULL");
		}
		try {
			em.persist(tipologiaEsame);
			System.out.println("TipologiaEsameFacade: TIPOLOGIAESAME CREATA");
		} catch(Exception e) {
			System.out.println("ERRORE CREATETIPOLOGIAESAME");
			System.out.println(e);
		}
		return tipologiaEsame;
	}
	
	public List<Esame> addEsame(TipologiaEsame tipologiaEsame, Esame esame) {
		List<Esame> esami = tipologiaEsame.getEsami();
		System.out.println("LISTA PRESA");
		if (esami==null) {
			System.out.println("LISTA NULL");
		} else {
			System.out.println("ELEMENTI LISTA: " + esami.size());
		}
		esami.add(esame);
		System.out.println("ESAME AGGIUNTO ALLA LISTA PRESA");
		tipologiaEsame.setEsami(esami);
		System.out.println("LISTA SETTATA");
		//this.updateTipologiaEsame(tipologiaEsame);
		//System.out.println("TIPOLOGIA AGGIORNATA");
		return esami;	
	}
	
	public List<PrerequisitoEsame> addPrerequisito(TipologiaEsame tipologiaEsame, PrerequisitoEsame prerequisitoEsame) {
		List<PrerequisitoEsame> prerequisitiEsame = tipologiaEsame.getPrerequisitiEsame();
		System.out.println("LISTA PREREQ PRESA");
		if (prerequisitiEsame==null) {
			System.out.println("LISTA PREREQ NULL");
		} else {
			System.out.println("ELEMENTI LISTA PREREQ: " + prerequisitiEsame.size());
		}
		prerequisitiEsame.add(prerequisitoEsame);
		System.out.println("PREREQ AGGIUNTO ALLA LISTA PRESA");
		tipologiaEsame.setPrerequisitiEsame(prerequisitiEsame);
		System.out.println("LISTA PREREQ SETTATA");
		//this.updateTipologiaEsame(tipologiaEsame);
		//System.out.println("TIPOLOGIA PREREQ AGGIORNATA");
		return prerequisitiEsame;
	}
	
	public TipologiaEsame getTipologiaEsame(Long id) {
		TipologiaEsame tipologiaEsame = em.find(TipologiaEsame.class, id);
		return tipologiaEsame;
	}
	
	public TipologiaEsame findByName(String nomeTipologia) {
		Query queryTipologiaByName = em.createQuery("SELECT OBJECT(t) FROM TipologiaEsame AS t WHERE t.nome=?1");
		queryTipologiaByName.setParameter(1, nomeTipologia);
		List<TipologiaEsame> tipologieEsame = queryTipologiaByName.getResultList();
		if (tipologieEsame.isEmpty()) {
			return null;
		} else {
			System.out.println("TIPOLOGIA ESAME ESISTE NELLA LISTA");
			TipologiaEsame te = (TipologiaEsame)tipologieEsame.get(0);
			return te;
		}
	}
	
	public List<TipologiaEsame> getAllTipologieEsame() {
		CriteriaQuery<TipologiaEsame> cq = em.getCriteriaBuilder().createQuery(TipologiaEsame.class);
		cq.select(cq.from(TipologiaEsame.class));
		List<TipologiaEsame> tipologieEsame = em.createQuery(cq).getResultList();
		return tipologieEsame;
	}

	public void updateTipologiaEsame(TipologiaEsame tipologiaEsame) {
		em.merge(tipologiaEsame);
	}
	
	private void deleteTipologiaEsame(TipologiaEsame tipologiaEsame) {
		em.remove(tipologiaEsame);
	}
	
	public void deleteTipologiaEsame(Long id) {
		TipologiaEsame tipologiaEsame = em.find(TipologiaEsame.class, id);
		deleteTipologiaEsame(tipologiaEsame);
	}
	
	public void changeNome(TipologiaEsame tipologiaEsame, String nome) {
		tipologiaEsame.setNome(nome);
		em.merge(tipologiaEsame);
	}
	
    /**
     * Default constructor. 
     */
    public TipologiaEsameFacade() {
        // TODO Auto-generated constructor stub
    }

}
