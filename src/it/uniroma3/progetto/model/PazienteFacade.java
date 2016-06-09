package it.uniroma3.progetto.model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 * Session Bean implementation class PazienteFacade
 */
@Stateless
@LocalBean
public class PazienteFacade {
	
	@PersistenceContext(unitName = "labAnalisi-unit")
	private EntityManager em;
	
	public Paziente createPaziente(Paziente paziente) {
		if (em==null) {
			System.out.println("EM NULL");
		}
		try {
			em.persist(paziente);
			System.out.println("EsameFacade: PAZIENTE CREATO");
		} catch(Exception e) {
			System.out.println("ERRORE CREATEPAZIENTE");
			System.out.println(e);
		}
		return paziente;
	}
	
	public Paziente findByCF(String cf) {
		Query queryCF = em.createQuery("SELECT OBJECT(p) FROM Paziente AS p WHERE p.cf=?1");
		queryCF.setParameter(1, cf);
		List<Paziente> pazienti = queryCF.getResultList();
		if (pazienti.isEmpty()) {
			return null;
		} else {
			System.out.println("PAZIENTE ESISTE NELLA LISTA");
			Paziente p = (Paziente)pazienti.get(0);
			return p;
		}
	}
	
	public List<Paziente> findAllPazienti() {
		Query q = em.createQuery("SELECT p FROM Paziente p");
		System.out.println("*********PRENDOPAZ**********");
		List<Paziente> pazienti = q.getResultList();
		System.out.println("DIMENSIONE LISTA *****" + pazienti.size());
		return pazienti;
	}
	
	public Paziente getPaziente(Long id) {
		Paziente paziente = em.find(Paziente.class, id);
		return paziente;
	}
	
	public List<Paziente> getAllPazienti() {
		CriteriaQuery<Paziente> cq = em.getCriteriaBuilder().createQuery(Paziente.class);
		cq.select(cq.from(Paziente.class));
		List<Paziente> pazienti = em.createQuery(cq).getResultList();
		return pazienti;
	}

	public void updatePaziente(Paziente paziente) {
		em.merge(paziente);
	}
	
	private void deletePaziente(Paziente paziente) {
		em.remove(paziente);
	}
	
	public void deletePaziente(Long id) {
		Paziente paziente = em.find(Paziente.class, id);
		deletePaziente(paziente);
	}

    /**
     * Default constructor. 
     */
    public PazienteFacade() {
        // TODO Auto-generated constructor stub
    }

}
