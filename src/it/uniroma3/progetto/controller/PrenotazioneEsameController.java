package it.uniroma3.progetto.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;

import it.uniroma3.progetto.model.TipologiaEsame;
import it.uniroma3.progetto.model.TipologiaEsameFacade;

@ManagedBean
public class PrenotazioneEsameController {
	private String nome;
	private List<String> tipologieEsamePrenotate;
	private List<String> tipologieEsameSelezionabili;
	
	@EJB
	private TipologiaEsameFacade tipologiaEsameFacade;
	
	public PrenotazioneEsameController() {
		System.out.println("*******COSTRUTTORE");
		if (this.tipologiaEsameFacade==null) {
			System.out.println("NULLLLLL");
		}
//		TipologiaEsame t = this.tipologiaEsameFacade.findByName("sangue");
//		System.out.println(t.getNome() + t.getCodice());
//		this.tipologieEsamePrenotate = new ArrayList<String>();
//		List<TipologiaEsame> ls = this.tipologiaEsameFacade.findAll();
//		this.tipologieEsameSelezionabili = new ArrayList<String>();
//		for(TipologiaEsame e:ls) {
//			System.out.println(e.getNome());
//			this.tipologieEsameSelezionabili.add(e.getNome());
//		}
		this.nome = "Ciao";
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

	public String getNome() {
		List<TipologiaEsame> ls = this.tipologiaEsameFacade.findAll();
		this.tipologieEsameSelezionabili = new ArrayList<String>();
		for(TipologiaEsame e:ls) {
			System.out.println(e.getNome());
			this.tipologieEsameSelezionabili.add(e.getNome());
		}
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
