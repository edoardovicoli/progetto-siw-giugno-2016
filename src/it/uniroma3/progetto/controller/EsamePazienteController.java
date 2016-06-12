package it.uniroma3.progetto.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;

import it.uniroma3.progetto.model.Esame;
import it.uniroma3.progetto.model.EsamePaziente;
import it.uniroma3.progetto.model.EsamePazienteFacade;
import it.uniroma3.progetto.model.Medico;
import it.uniroma3.progetto.model.MedicoFacade;
import it.uniroma3.progetto.model.Paziente;
import it.uniroma3.progetto.model.PazienteFacade;
import it.uniroma3.progetto.model.TipologiaEsame;
import it.uniroma3.progetto.model.TipologiaEsameFacade;

@ManagedBean
public class EsamePazienteController {
	private String codice;
	private Date dataPrenotazione;
	private String medico;
	private String paziente;
	private String tipologiaEsame;
	private List<String> mediciSelezionabili;
	private List<String> pazientiSelezionabili;
	private List<String> tipologieEsameSelezionabili;
	private List<String> esamiPerTipologiaStringhe;
	private List<String> esamiSelezionati;
	
	private Date dataSvolgimentoCartella;
	private EsamePaziente esamePazienteCartella;
	private TipologiaEsame tipologiaEsameCartella;
	private List<Esame> esamiCartella;
	private Medico medicoCartella;
	private Paziente pazienteCartella;
	
	private String esamiPerTipologia = "";
	
	@EJB
	private MedicoFacade medicoFacade;
	@EJB
	private PazienteFacade pazienteFacade;
	@EJB
	private TipologiaEsameFacade tipologiaEsameFacade;
	@EJB
	private EsamePazienteFacade esamePazienteFacade;
	
	public String createEsamePaziente() {
		this.esamePazienteCartella = new EsamePaziente(this.codice, this.dataSvolgimentoCartella);
		
		this.tipologiaEsameCartella = this.tipologiaEsameFacade.findByName(this.tipologiaEsame);
		this.esamePazienteFacade.setTipologiaEsameCartella(this.esamePazienteCartella, this.tipologiaEsameCartella);
		this.tipologiaEsameCartella.setEsamePaziente(this.esamePazienteCartella);
		
		for (String esame:esamiSelezionati) {
			Esame esameCartella = new Esame(esame);
			this.esamePazienteFacade.addEsame(this.esamePazienteCartella, esameCartella);
		}
		
		this.dataPrenotazione = new Date();
		this.esamePazienteCartella.setDataPrenotazione(this.dataPrenotazione);
		
		this.medicoCartella = this.medicoFacade.findByNomeMedico(this.medico);
		this.esamePazienteFacade.setMedicoCartella(this.esamePazienteCartella, this.medicoCartella);
		
		this.pazienteCartella = this.pazienteFacade.findByCF(this.paziente);
		this.esamePazienteFacade.setPazienteCartella(this.esamePazienteCartella, this.pazienteCartella);
		
		this.esamePazienteFacade.createEsamePaziente(this.esamePazienteCartella);
		return "newPrenotazioneEsame";
	}
	
	public String mostraEsami() {
		List<Esame> esamiPerTipologia = this.tipologiaEsameFacade.findByNomeTipologia(this.tipologiaEsame);
		this.esamiPerTipologiaStringhe = new ArrayList<String>();
		this.esamiSelezionati = new ArrayList<String>();
		for (Esame e:esamiPerTipologia) {
			String nomeEsame = e.getNome();
			this.esamiPerTipologiaStringhe.add(nomeEsame);
		}
		if (!(esamiPerTipologiaStringhe.isEmpty())) {
			this.esamiPerTipologia = "Esami per Tipologia:";
		}
		return "newPrenotazioneEsame";
	}
	
	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public Date getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public List<String> getMediciSelezionabili() {
		List<String> mediciSelezionabili = new ArrayList<String>();
		List<Medico> listaMedici = this.medicoFacade.findAllMedici();
		for(Medico m:listaMedici) {
			String nomeMedico = /* m.getCodice() + ": " + */m.getNome()/* + " " + m.getCognome() + " - " + m.getSpecializzazione()*/;
			mediciSelezionabili.add(nomeMedico);
		}
		return mediciSelezionabili;
	}

	public void setMediciSelezionabili(List<String> mediciSelezionabili) {
		this.mediciSelezionabili = mediciSelezionabili;
	}

	public String getPaziente() {
		return paziente;
	}

	public void setPaziente(String paziente) {
		this.paziente = paziente;
	}

	public List<String> getPazientiSelezionabili() {
		List<String> pazientiSelezionabili = new ArrayList<String>();
		List<Paziente> listaPazienti = this.pazienteFacade.findAllPazienti();
		for(Paziente p:listaPazienti) {
			String nomePaziente = p.getCf()/* + ": " + p.getNome() + " - " + p.getCognome()*/;
			pazientiSelezionabili.add(nomePaziente);
		}
		return pazientiSelezionabili;
	}

	public void setPazientiSelezionabili(List<String> pazientiSelezionabili) {
		this.pazientiSelezionabili = pazientiSelezionabili;
	}

	public List<String> getTipologieEsameSelezionabili() {
		List<String> tipologieEsameSelezionabili = new ArrayList<String>();
		tipologieEsameSelezionabili.add("Seleziona Tipologia Esame");
		List<TipologiaEsame> listaTipologieEsame = this.tipologiaEsameFacade.findAll();
		for(TipologiaEsame te:listaTipologieEsame) {
			String tipologiaEsame = te.getNome();
			tipologieEsameSelezionabili.add(tipologiaEsame);
		}
		return tipologieEsameSelezionabili;
	}

	public void setTipologieEsameSelezionabili(List<String> tipologieEsameSelezionabili) {
		this.tipologieEsameSelezionabili = tipologieEsameSelezionabili;
	}

	public String getTipologiaEsame() {
		return tipologiaEsame;
	}

	public void setTipologiaEsame(String tipologiaEsame) {
		this.tipologiaEsame = tipologiaEsame;
	}

	public List<String> getEsamiPerTipologiaStringhe() {
		return esamiPerTipologiaStringhe;
	}

	public void setEsamiPerTipologiaStringhe(List<String> esamiPerTipologiaStringhe) {
		this.esamiPerTipologiaStringhe = esamiPerTipologiaStringhe;
	}

	public List<String> getEsamiSelezionati() {
		return esamiSelezionati;
	}

	public void setEsamiSelezionati(List<String> esamiSelezionati) {
		this.esamiSelezionati = esamiSelezionati;
	}

	public String getEsamiPerTipologia() {
		return esamiPerTipologia;
	}

	public void setEsamiPerTipologia(String esamiPerTipologia) {
		this.esamiPerTipologia = esamiPerTipologia;
	}

	public TipologiaEsame getTipologiaEsameCartella() {
		return tipologiaEsameCartella;
	}

	public void setTipologiaEsameCartella(TipologiaEsame tipologiaEsameCartella) {
		this.tipologiaEsameCartella = tipologiaEsameCartella;
	}

	public List<Esame> getEsamiCartella() {
		return esamiCartella;
	}

	public void setEsamiCartella(List<Esame> esamiCartella) {
		this.esamiCartella = esamiCartella;
	}

	public Date getDataSvolgimentoCartella() {
		dataSvolgimentoCartella = new Date();
		return dataSvolgimentoCartella;
	}

	public void setDataSvolgimentoCartella(Date dataSvolgimentoCartella) {
		this.dataSvolgimentoCartella = dataSvolgimentoCartella;
	}
	
}
