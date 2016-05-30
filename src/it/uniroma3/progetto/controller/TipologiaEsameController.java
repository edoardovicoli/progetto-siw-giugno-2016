package it.uniroma3.progetto.controller;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;

import it.uniroma3.progetto.model.Esame;
import it.uniroma3.progetto.model.PrerequisitoEsame;
import it.uniroma3.progetto.model.TipologiaEsame;
import it.uniroma3.progetto.model.TipologiaEsameFacade;

@ManagedBean
public class TipologiaEsameController {
	private String nome;
	private TipologiaEsame tipologiaEsame;
	private List<TipologiaEsame> tipologieEsame;
	private List<Esame> esami;
	private List<PrerequisitoEsame> prerequisitiEsame;
	
	@EJB
	private TipologiaEsameFacade tipologiaEsameFacade;

	public String createTipologiaEsame() {
		this.tipologiaEsame = tipologiaEsameFacade.createTipologiaEsame(this.nome);
		System.out.println("Nome: " + this.nome);
		System.out.println(this.tipologiaEsame.toString());
		
		// riazzero campi
		this.nome = "";
		return "newTipologiaEsame";
	}
	
	public String listTipologieEsame() {
		this.tipologieEsame = tipologiaEsameFacade.getAllTipologieEsame();
		return "esami";
	}
	
//	public String findEsame() {
//		this.esame = esameFacade.getEsame(this.id);
//		return "esame";
//	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipologiaEsame getTipologiaEsame() {
		return tipologiaEsame;
	}

	public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsame = tipologiaEsame;
	}

	public List<TipologiaEsame> getTipologieEsame() {
		this.tipologieEsame = tipologiaEsameFacade.getAllTipologieEsame();
		return tipologieEsame;
	}

	public void setTipologieEsami(List<TipologiaEsame> tipologieEsame) {
		this.tipologieEsame = tipologieEsame;
	}

}