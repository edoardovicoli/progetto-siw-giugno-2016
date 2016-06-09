package it.uniroma3.progetto.model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 * Session Bean implementation class MedicoFacade
 */
@Stateless
@LocalBean
public class MedicoFacade {
	
	@PersistenceContext(unitName = "labAnalisi-unit")
	private EntityManager em;
	
	public Medico createMedico(Medico medico) {
		if (em==null) {
			System.out.println("EM NULL");
		}
		try {
			em.persist(medico);
			System.out.println("EsameFacade: MEDICO CREATO");
		} catch(Exception e) {
			System.out.println("ERRORE CREATEMEDICO");
			System.out.println(e);
		}
		return medico;
	}
	
	public Medico findByCodiceMedico(String codiceMedico) {
		Query queryCodiceMedico = em.createQuery("SELECT OBJECT(m) FROM Medico AS m WHERE m.codice=?1");
		queryCodiceMedico.setParameter(1, codiceMedico);
		List<Medico> medici = queryCodiceMedico.getResultList();
		if (medici.isEmpty()) {
			return null;
		} else {
			System.out.println("MEDICO ESISTE NELLA LISTA");
			Medico m = (Medico)medici.get(0);
			return m;
		}
	}
	
	public Medico getMedico(Long id) {
		Medico medico = em.find(Medico.class, id);
		return medico;
	}
	
	public List<Medico> getAllMedici() {
		CriteriaQuery<Medico> cq = em.getCriteriaBuilder().createQuery(Medico.class);
		cq.select(cq.from(Medico.class));
		List<Medico> medici = em.createQuery(cq).getResultList();
		return medici;
	}
	
	public List<Medico> findAllMedici() {
		Query q = em.createQuery("SELECT m FROM Medico m");
		System.out.println("*********PRENDOMED**********");
		List<Medico> medici = q.getResultList();
		System.out.println("DIMENSIONE LISTA *****" + medici.size());
		return medici;
	}

	public void updateMedico(Medico medico) {
		em.merge(medico);
	}
	
	private void deleteMedico(Medico medico) {
		em.remove(medico);
	}
	
	public void deleteMedico(Long id) {
		Medico medico = em.find(Medico.class, id);
		deleteMedico(medico);
	}

    /**
     * Default constructor. 
     */
    public MedicoFacade() {
        // TODO Auto-generated constructor stub
    }

}
