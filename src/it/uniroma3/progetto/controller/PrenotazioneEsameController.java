package it.uniroma3.progetto.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;

import it.uniroma3.progetto.model.TipologiaEsame;
import it.uniroma3.progetto.model.TipologiaEsameFacade;

@ManagedBean
public class PrenotazioneEsameController {
	private List<String> tipologieEsamePrenotate;
	private List<String> tipologieEsameSelezionabili;
	
	@EJB
	private TipologiaEsameFacade tipologiaEsameFacade;
	
	public PrenotazioneEsameController() {
		if (this.tipologiaEsameFacade==null) {
			System.out.println("NULLLLLL");
		}
	}
	
	public String register() {
		return "newPrenotazioneEsame";
	}

	public List<String> getTipologieEsamePrenotate() {
		return tipologieEsamePrenotate;
	}

	public void setTipologieEsamePrenotate(List<String> tipologieEsamePrenotate) {
		this.tipologieEsamePrenotate = tipologieEsamePrenotate;
	}

	public List<String> getTipologieEsameSelezionabili() {
		System.out.println("*******GET");
		
		List<TipologiaEsame> ls = this.tipologiaEsameFacade.findAll();
		this.tipologieEsameSelezionabili = new ArrayList<String>();
		for(TipologiaEsame e:ls) {
			System.out.println(e.getNome());
			this.tipologieEsameSelezionabili.add(e.getNome());
		}
		return tipologieEsameSelezionabili;
	}

	public void setTipologieEsameSelezionabili(List<String> tipologieEsameSelezionabili) {
		this.tipologieEsameSelezionabili = tipologieEsameSelezionabili;
	}

	public void setNome(String nome) {
		//this.nome = nome;
	}
	
}
