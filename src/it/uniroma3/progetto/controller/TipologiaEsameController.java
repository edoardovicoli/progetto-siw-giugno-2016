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
	private String codice;
	private String costo;
	private String descrizione;
	private TipologiaEsame tipologiaEsame;
	private Esame esame;
	private String nomeEsame;
	private List<Esame> esami;
	private PrerequisitoEsame prerequisitoEsame;
	private String nomePrerequisito;
	private String valorePrerequisito;
	private List<PrerequisitoEsame> prerequisitiEsame;
	private List<TipologiaEsame> tipologieEsame;
	
	private String nomeTipologiaEsameDettaglio;
	private List<Esame> esamiPerDettaglio;
	
	private List<String> stringhe = new ArrayList<String>();
	
	@EJB
	private TipologiaEsameFacade tipologiaEsameFacade;
	@EJB
	private EsameFacade esameFacade;
	
	public TipologiaEsameController() {}

	public String createTipologiaEsame() {
		this.tipologiaEsame = tipologiaEsameFacade.findByName(this.nome);
		if (this.tipologiaEsame==null) {
			this.tipologiaEsame = new TipologiaEsame(this.nome, this.codice, this.costo, this.descrizione);
			
			this.esame = new Esame(this.nomeEsame);
			this.esami = tipologiaEsameFacade.addEsame(this.tipologiaEsame, this.esame);
			
			this.prerequisitoEsame = new PrerequisitoEsame(this.nomePrerequisito, this.valorePrerequisito);
			this.prerequisitiEsame = tipologiaEsameFacade.addPrerequisito(this.tipologiaEsame, this.prerequisitoEsame);
			
			this.tipologiaEsame = tipologiaEsameFacade.createTipologiaEsame(this.tipologiaEsame);
			
			// per tipologieEsame.jsp
			
			this.tipologieEsame = this.tipologiaEsameFacade.findAll();
		} else {
			List<Esame> esami = this.tipologiaEsame.getEsami();
			boolean esameTrovato = false;
			
			// se c'è già un esame uguale...
			for(Esame e:esami) {
				if (e.getNome().equals(this.nomeEsame)) {
					esameTrovato = true;
					break;
				}
			}
			if (!esameTrovato) {
				this.esame = new Esame(this.nomeEsame);
				this.esami=tipologiaEsameFacade.addEsame(this.tipologiaEsame, this.esame);
			}
			//this.tipologiaEsameFacade.updateTipologiaEsame(tipologiaEsame);
			
			List<PrerequisitoEsame> prerequisiti = this.tipologiaEsame.getPrerequisitiEsame();
			boolean prerequisitoTrovato = false;
			
			// se c'è già un prerequisito uguale...
			for (PrerequisitoEsame pe:prerequisiti) {
				if (pe.getNome().equals(this.nomePrerequisito) && pe.getValore().equals(this.valorePrerequisito)) {
					prerequisitoTrovato = true;
					break;
				}
			}
			if (!prerequisitoTrovato) {
				this.prerequisitoEsame = new PrerequisitoEsame(this.nomePrerequisito, this.valorePrerequisito);
				this.prerequisitiEsame = tipologiaEsameFacade.addPrerequisito(this.tipologiaEsame, this.prerequisitoEsame);
			}
			this.tipologiaEsameFacade.updateTipologiaEsame(tipologiaEsame);
		}	
			
		// riazzero campi
		this.nomeEsame = "";
		return "newTipologiaEsame";
	}
	
	public String tipologiaEsameDettaglio(String nomeDettaglio) {
		this.nomeTipologiaEsameDettaglio = nomeDettaglio;
		System.out.println(this.nomeTipologiaEsameDettaglio);
		this.esamiPerDettaglio = this.tipologiaEsameFacade.findByNomeTipologia(nomeTipologiaEsameDettaglio);
		for(Esame e:esamiPerDettaglio) {
			System.out.println(e.getNome());
		}
		return "tipologiaEsameDetail";
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

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getCosto() {
		return costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public PrerequisitoEsame getPrerequisitoEsame() {
		return prerequisitoEsame;
	}

	public void setPrerequisitoEsame(PrerequisitoEsame prerequisitoEsame) {
		this.prerequisitoEsame = prerequisitoEsame;
	}

	public String getValorePrerequisito() {
		return valorePrerequisito;
	}

	public void setValorePrerequisito(String valorePrerequisito) {
		this.valorePrerequisito = valorePrerequisito;
	}

	public String getNomePrerequisito() {
		return nomePrerequisito;
	}

	public void setNomePrerequisito(String nomePrerequisito) {
		this.nomePrerequisito = nomePrerequisito;
	}

	public List<PrerequisitoEsame> getPrerequisitiEsame() {
		return prerequisitiEsame;
	}

	public void setPrerequisitiEsame(List<PrerequisitoEsame> prerequisitiEsame) {
		this.prerequisitiEsame = prerequisitiEsame;
	}

	public List<String> getStringhe() {
		return stringhe;
	}

	public void setStringhe(List<String> stringhe) {
		this.stringhe = stringhe;
	}
	
	public List<TipologiaEsame> getTipologieEsame() {
		return tipologieEsame;
	}

	public void setTipologieEsame(List<TipologiaEsame> tipologieEsame) {
		this.tipologieEsame = tipologieEsame;
	}

	public String getNomeTipologiaEsameDettaglio() {
		return nomeTipologiaEsameDettaglio;
	}

	public void setNomeTipologiaEsameDettaglio(String nomeTipologiaEsameDettaglio) {
		this.nomeTipologiaEsameDettaglio = nomeTipologiaEsameDettaglio;
	}
	
	public List<Esame> getEsamiPerDettaglio() {
		return esamiPerDettaglio;
	}

	public void setEsamiPerDettaglio(List<Esame> esamiPerDettaglio) {
		this.esamiPerDettaglio = esamiPerDettaglio;
	}

	public String register() {
		for(String s:this.stringhe) {
			System.out.println(s);
		}
		return "newPrenotazioneEsame";
	}
	
}