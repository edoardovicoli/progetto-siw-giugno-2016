package it.uniroma3.progetto.controller;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

import it.uniroma3.progetto.model.Esame;
import it.uniroma3.progetto.model.EsameFacade;
import it.uniroma3.progetto.model.TipologiaEsame;
import it.uniroma3.progetto.model.TipologiaEsameFacade;

@ManagedBean
public class EsameController {
	private String nome;
	private Esame esame;
	private List<Esame> esami;

	@EJB
	private EsameFacade esameFacade;

	public Esame createEsame(String nome) {
		this.esame = esameFacade.createEsame(this.nome);
		//FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("esame", this.esame);
		
		// riazzero campi
		this.nome = "";
		return this.esame;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Esame getEsame() {
		return esame;
	}

	public void setEsame(Esame esame) {
		this.esame = esame;
	}

	public List<Esame> getEsami() {
		return esami;
	}

	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}
	
}
