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
			em.merge(esamePaziente);
			System.out.println("EsamePazienteFacade: ESAMEPAZIENTE CREATA");
		} catch(Exception e) {
			System.out.println("ERRORE CREATEESAMEPAZIENTE");
			System.out.println(e);
		}
		return esamePaziente;
	}
	
	public List<TipologiaEsame> addTipologiaEsame(EsamePaziente esamePaziente, TipologiaEsame tipologiaEsame) {
		List<TipologiaEsame> tipologieEsame = esamePaziente.getTipologieEsame();
		System.out.println("LISTA PRESA");
		if (tipologieEsame==null) {
			System.out.println("LISTA NULL");
		} else {
			System.out.println("ELEMENTI LISTA: " + tipologieEsame.size());
		}
		tipologieEsame.add(tipologiaEsame);
		System.out.println("TIPOLOGIAESAME AGGIUNTA ALLA LISTA PRESA");
		esamePaziente.setTipologieEsame(tipologieEsame);
		System.out.println("LISTA SETTATA");
		return tipologieEsame;	
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
		System.out.println("*********PRENDOTIP**********");
		List<TipologiaEsame> tipologieEsame = q.getResultList();
		System.out.println("DIMENSIONE LISTA *****" + tipologieEsame.size());
		return tipologieEsame;
	}
	
	public List<Esame> findAllEsami() {
		Query q = em.createQuery("SELECT e FROM Esame e");
		System.out.println("*********PRENDOES**********");
		List<Esame> esami = q.getResultList();
		System.out.println("DIMENSIONE LISTA *****" + esami.size());
		return esami;
	}
	
	public void setMedicoCartella(EsamePaziente esamePaziente, Medico medico) {
		esamePaziente.setMedico(medico);
	}
	
	public void setPazienteCartella(EsamePaziente esamePaziente, Paziente paziente) {
		esamePaziente.setPaziente(paziente);
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
