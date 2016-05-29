package it.uniroma3.progetto.model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
	
	public TipologiaEsame createTipologiaEsame(String nome) {
		TipologiaEsame tipologiaEsame = new TipologiaEsame(nome);
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
	
	public TipologiaEsame getTipologiaEsame(Long id) {
		TipologiaEsame tipologiaEsame = em.find(TipologiaEsame.class, id);
		return tipologiaEsame;
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
