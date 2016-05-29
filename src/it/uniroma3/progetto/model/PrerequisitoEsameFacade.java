package it.uniroma3.progetto.model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.progetto.model.PrerequisitoEsame;

/**
 * Session Bean implementation class PrerequisitoEsameFacade
 */
@Stateless
@LocalBean
public class PrerequisitoEsameFacade {

	@PersistenceContext(unitName = "labAnalisi-unit")
	private EntityManager em;
	
	
	public PrerequisitoEsame createEsame(String nome, String valore) {
		PrerequisitoEsame prerequisitoEsame = new PrerequisitoEsame(nome, valore);
		if (em==null) {
			System.out.println("EM NULL");
		}
		try {
			em.persist(prerequisitoEsame);
			System.out.println("PrerequisitoEsameFacade: ESAME CREATO");
		} catch(Exception e) {
			System.out.println("ERRORE CREATEPREREQUISITOESAME");
			System.out.println(e);
		}
		return prerequisitoEsame;
	}
	
	public PrerequisitoEsame getPrerequisitoEsame(Long id) {
		PrerequisitoEsame prerequisitoEsame = em.find(PrerequisitoEsame.class, id);
		return prerequisitoEsame;
	}
	
	public List<PrerequisitoEsame> getAllPrerequisitiEsame() {
		CriteriaQuery<PrerequisitoEsame> cq = em.getCriteriaBuilder().createQuery(PrerequisitoEsame.class);
		cq.select(cq.from(PrerequisitoEsame.class));
		List<PrerequisitoEsame> prerequisitiEsame = em.createQuery(cq).getResultList();
		return prerequisitiEsame;
	}

	public void updatePrerequisitoEsame(PrerequisitoEsame prerequisitoEsame) {
		em.merge(prerequisitoEsame);
	}
	
	private void deletePrerequisitoEsame(PrerequisitoEsame prerequisitoEsame) {
		em.remove(prerequisitoEsame);
	}
	
	public void deletePrerequisitoEsame(Long id) {
		PrerequisitoEsame prerequisitoEsame = em.find(PrerequisitoEsame.class, id);
		deletePrerequisitoEsame(prerequisitoEsame);
	}
	
	public void changeValore(PrerequisitoEsame prerequisitoEsame, String valore) {
		prerequisitoEsame.setValore(valore);
		em.merge(prerequisitoEsame);
	}
	
    /**
     * Default constructor. 
     */
    public PrerequisitoEsameFacade() {
        // TODO Auto-generated constructor stub
    }

}
