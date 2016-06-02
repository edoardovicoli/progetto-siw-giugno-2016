package it.uniroma3.progetto.controller;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;

import it.uniroma3.progetto.model.Medico;
import it.uniroma3.progetto.model.MedicoFacade;

@ManagedBean
public class MedicoController {
	private String codice;
	private String nome;
	private String cognome;
	private String specializzazione;
	private Medico medico;
	private String messaggioSuccesso;
	private String messaggioFallimento;
	
	@EJB
	private MedicoFacade medicoFacade;
	
	public MedicoController() {}
	
	public String createMedico() {
		this.medico = this.medicoFacade.findByCodiceMedico(this.codice);
		if (this.medico==null) {
			this.medico = new Medico(this.codice, this.nome, this.cognome, this.specializzazione);
			this.medico = this.medicoFacade.createMedico(this.medico);
			this.messaggioSuccesso = "Medico inserito con successo!";
		} else {
			this.messaggioSuccesso = null;
			this.messaggioFallimento = "Il medico inserito è già presente nell'anagrafica!";
		}
		
		// riazzero i campi
		this.codice = "";
		this.nome = "";
		this.cognome = "";
		this.specializzazione = "";
		return "newMedico";
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getSpecializzazione() {
		return specializzazione;
	}

	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public String getMessaggioSuccesso() {
		return messaggioSuccesso;
	}

	public void setMessaggioSuccesso(String messaggioSuccesso) {
		this.messaggioSuccesso = messaggioSuccesso;
	}

	public String getMessaggioFallimento() {
		return messaggioFallimento;
	}

	public void setMessaggioFallimento(String messaggioFallimento) {
		this.messaggioFallimento = messaggioFallimento;
	}
	
}
