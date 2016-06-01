package it.uniroma3.progetto.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import it.uniroma3.progetto.model.Esame;
import it.uniroma3.progetto.model.EsameFacade;
import it.uniroma3.progetto.model.PrerequisitoEsame;
import it.uniroma3.progetto.model.TipologiaEsame;
import it.uniroma3.progetto.model.TipologiaEsameFacade;

@ManagedBean
public class TipologiaEsameController {
	private String nome;
	private TipologiaEsame tipologiaEsame;
	private Esame esame;
	private String nomeEsame;
	private List<Esame> esami;
	
	public TipologiaEsameController() {}
	
	@EJB
	private TipologiaEsameFacade tipologiaEsameFacade;
	@EJB
	private EsameFacade esameFacade;

	public String createTipologiaEsame() {
		this.tipologiaEsame = tipologiaEsameFacade.findByName(this.nome);
		if (this.tipologiaEsame==null) {
			this.tipologiaEsame = new TipologiaEsame(this.nome);
			this.esame = new Esame(this.nomeEsame);
			this.esami=tipologiaEsameFacade.addEsame(this.tipologiaEsame, this.esame);
			this.tipologiaEsame = tipologiaEsameFacade.createTipologiaEsame(this.tipologiaEsame);
		} else {
			this.esame = new Esame(this.nomeEsame);
			this.esami=tipologiaEsameFacade.addEsame(this.tipologiaEsame, this.esame);
			this.tipologiaEsameFacade.updateTipologiaEsame(tipologiaEsame);
		}	
			
		// riazzero campi
		this.nomeEsame = "";
		return "newTipologiaEsame";
	}
	
	public void addEsame(Esame esame) {
		this.esami.add(esame);
	}
	
	public Esame createEsame() {
		this.esame=esameFacade.createEsame(this.nomeEsame);
		this.esami=tipologiaEsameFacade.addEsame(this.tipologiaEsame, this.esame);
		return this.esame;
	}
 	
//	public String listTipologieEsame() {
//		this.tipologieEsame = tipologiaEsameFacade.getAllTipologieEsame();
//		return "esami";
//	}
	
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

//	public List<TipologiaEsame> getTipologieEsame() {
//		this.tipologieEsame = tipologiaEsameFacade.getAllTipologieEsame();
//		return tipologieEsame;
//	}
//
//	public void setTipologieEsami(List<TipologiaEsame> tipologieEsame) {
//		this.tipologieEsame = tipologieEsame;
//	}

	public Esame getEsame() {
		return esame;
	}

	public void setEsame(Esame esame) {
		this.esame = esame;
	}

	public String getNomeEsame() {
		return nomeEsame;
	}

	public void setNomeEsame(String nomeEsame) {
		this.nomeEsame = nomeEsame;
	}

	public TipologiaEsameFacade getTipologiaEsameFacade() {
		return tipologiaEsameFacade;
	}

	public void setTipologiaEsameFacade(TipologiaEsameFacade tipologiaEsameFacade) {
		this.tipologiaEsameFacade = tipologiaEsameFacade;
	}

	public List<Esame> getEsami() {
		return esami;
	}

	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}
	
}