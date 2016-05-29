package it.uniroma3.progetto.model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.progetto.model.Esame;

/**
 * Session Bean implementation class EsameFacade
 */
@Stateless
@LocalBean
public class EsameFacade {

	@PersistenceContext(unitName = "labAnalisi-unit")
	private EntityManager em;
	
	
	public Esame createEsame(String nome) {
		Esame esame = new Esame(nome);
		if (em==null) {
			System.out.println("EM NULL");
		}
		try {
			em.persist(esame);
			System.out.println("EsameFacade: ESAME CREATO");
		} catch(Exception e) {
			System.out.println("ERRORE CREATEESAME");
			System.out.println(e);
		}
		return esame;
	}
	
	public Esame getEsame(Long id) {
		Esame esame = em.find(Esame.class, id);
		return esame;
	}
	
	public List<Esame> getAllEsami() {
		CriteriaQuery<Esame> cq = em.getCriteriaBuilder().createQuery(Esame.class);
		cq.select(cq.from(Esame.class));
		List<Esame> esami = em.createQuery(cq).getResultList();
		return esami;
	}

	public void updateEsame(Esame esame) {
		em.merge(esame);
	}
	
	private void deleteEsame(Esame esame) {
		em.remove(esame);
	}
	
	public void deleteEsame(Long id) {
		Esame esame = em.find(Esame.class, id);
		deleteEsame(esame);
	}
	
	public void changeValore(Esame esame, String nome) {
		esame.setNome(nome);
		em.merge(esame);
	}
	
    /**
     * Default constructor. 
     */
    public EsameFacade() {
        // TODO Auto-generated constructor stub
    }

}
