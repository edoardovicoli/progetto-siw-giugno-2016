package it.uniroma3.progetto.controller;

import java.util.Date;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;

import it.uniroma3.progetto.model.Paziente;
import it.uniroma3.progetto.model.PazienteFacade;

@ManagedBean
public class PazienteController {
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String sesso;
	private String indirizzo;
	private String cf;
	private String email;
	private String telefono;
	private Paziente paziente;
	private String messaggioSuccesso;
	private String messaggioFallimento;
	public PazienteController() {}
	
	@EJB
	private PazienteFacade pazienteFacade;
	
	public String createPaziente() {
		this.paziente = pazienteFacade.findByCF(this.cf);
		if (this.paziente == null) {
			System.out.println("INIZIO CREATE PAZIENTE");
			Paziente p = new Paziente(this.nome, this.cognome, this.indirizzo, this.dataNascita, this.cf, this.email, this.telefono, this.sesso);
			System.out.println("NUOVO PAZIENTE");
			this.paziente = pazienteFacade.createPaziente(p);
			this.messaggioSuccesso = "Paziente inserito con successo!";
		} else {
			this.messaggioSuccesso = null;
			this.messaggioFallimento = "Il paziente inserito è già presente nell'anagrafica.";
		}
		// riazzero i campi
		this.nome = "";
		this.cognome = "";
		this.indirizzo = "";
		this.dataNascita = null;
		this.cf = "";
		this.email = "";
		this.telefono = "";
		this.sesso = "";
		return "newPaziente";	
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
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Paziente getPaziente() {
		return paziente;
	}
	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
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
