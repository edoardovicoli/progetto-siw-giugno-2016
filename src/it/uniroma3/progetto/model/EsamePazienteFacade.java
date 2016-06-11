package it.uniroma3.progetto.model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class EsamePazienteFacade
 */
@Stateless
@LocalBean
public class EsamePazienteFacade {
	@PersistenceContext(unitName = "labAnalisi-unit")
	private EntityManager em;
	
	public EsamePaziente createEsamePaziente(EsamePaziente esamePaziente) {
		if (em==null) {
			System.out.println("EM NULL");
		}
		try {
			em.persist(esamePaziente);
			System.out.println("EsamePazienteFacade: ESAMEPAZIENTE CREATA");
		} catch(Exception e) {
			System.out.println("ERRORE CREATEESAMEPAZIENTE");
			System.out.println(e);
		}
		return esamePaziente;
	}
	
	public List<Esame> addEsame(EsamePaziente esamePaziente, Esame esame) {
		List<Esame> esami = esamePaziente.getEsami();
		System.out.println("LISTA PRESA");
		if (esami==null) {
			System.out.println("LISTA NULL");
		} else {
			System.out.println("ELEMENTI LISTA: " + esami.size());
		}
		esami.add(esame);
		System.out.println("TIPOLOGIAESAME AGGIUNTA ALLA LISTA PRESA");
		esamePaziente.setEsami(esami);
		System.out.println("LISTA SETTATA");
		return esami;	
	}
	
	public List<TipologiaEsame> findAllTipologieEsame() {
		Query q = em.createQuery("SELECT t FROM TipologiaEsame t");
		List<TipologiaEsame> tipologieEsame = q.getResultList();
		return tipologieEsame;
	}
	
	public List<Esame> findAllEsami() {
		Query q = em.createQuery("SELECT e FROM Esame e");
		System.out.println("*********PRENDOES**********");
		List<Esame> esami = q.getResultList();
		System.out.println("DIMENSIONE LISTA *****" + esami.size());
		return esami;
	}
	
	public List<EsamePaziente> findAllEsamiPaziente() {
		Query q = em.createQuery("SELECT e FROM EsamePaziente e");
		System.out.println("*********PRENDOESPAZIENTE**********");
		List<EsamePaziente> esamiPaziente = q.getResultList();
		System.out.println("DIMENSIONE LISTA *****" + esamiPaziente.size());
		return esamiPaziente;
	}
	
	public List<EsamePaziente> findAllEsamiByMedico(Long idMedico) {
		Query q = em.createQuery("SELECT OBJECT(ep) FROM EsamePaziente AS ep WHERE ep.medico_id=?1");
		q.setParameter(1, idMedico);
		List<EsamePaziente> esamiPaziente = q.getResultList();
		return esamiPaziente;
	}
	
	public List<EsamePaziente> findAllEsamiByMedicoNomeCognome(String nomeMedico, String cognomeMedico) {
		Query q = em.createQuery("SELECT OBJECT(e) FROM EsamePaziente AS e WHERE e.medico.nome=?1 AND e.medico.cognome=?2");
		q.setParameter(1, nomeMedico);
		q.setParameter(2, cognomeMedico);
		List<EsamePaziente> esamiPaziente = q.getResultList();
		return esamiPaziente;
	}
	
	public List<EsamePaziente> findAllEsamiByPazienteCF(String codiceFiscale) {
		Query q = em.createQuery("SELECT OBJECT(e) FROM EsamePaziente AS e WHERE e.paziente.cf=?1");
		q.setParameter(1, codiceFiscale);
		List<EsamePaziente> esamiPaziente = q.getResultList();
		return esamiPaziente;
	}
	
	public void setMedicoCartella(EsamePaziente esamePaziente, Medico medico) {
		esamePaziente.setMedico(medico);
	}
	
	public void setPazienteCartella(EsamePaziente esamePaziente, Paziente paziente) {
		esamePaziente.setPaziente(paziente);
	}
	
	public void setTipologiaEsameCartella(EsamePaziente esamePaziente, TipologiaEsame tipologiaEsame) {
		esamePaziente.setTipologiaEsame(tipologiaEsame);
	}
	
	public void updateEsamePaziente(EsamePaziente esamePaziente) {
		em.merge(esamePaziente);
	}
	
	private void deleteEsamePaziente(EsamePaziente esamePaziente) {
		em.remove(esamePaziente);
	}
	
    /**
     * Default constructor. 
     */
    public EsamePazienteFacade() {
        // TODO Auto-generated constructor stub
    }

}
