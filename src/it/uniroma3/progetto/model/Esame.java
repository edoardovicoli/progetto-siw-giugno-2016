package it.uniroma3.progetto.model;

import java.util.Date;

public class Esame {
	private Long idEsame;
	private String nomeEsame;
	private Date dataPrenotazioneEsame;
	private String dataSvolgimentoEsame;
	private String medico; // deve diventare un oggetto (?)
	private TipologiaEsame tipologiaEsame; // deve diventare un oggetto
	private String pazienteEsame; // deve diventare un oggetto
	
	public Esame() {}
	
	public Long getIdEsame() {
		return idEsame;
	}

	public void setIdEsame(Long idEsame) {
		this.idEsame = idEsame;
	}

	public String getNomeEsame() {
		return nomeEsame;
	}

	public void setNomeEsame(String nomeEsame) {
		this.nomeEsame = nomeEsame;
	}

	public Date getDataPrenotazioneEsame() {
		return dataPrenotazioneEsame;
	}

	public void setDataPrenotazioneEsame(Date dataPrenotazioneEsame) {
		this.dataPrenotazioneEsame = dataPrenotazioneEsame;
	}

	public String getDataSvolgimentoEsame() {
		return dataSvolgimentoEsame;
	}

	public void setDataSvolgimentoEsame(String dataSvolgimentoEsame) {
		this.dataSvolgimentoEsame = dataSvolgimentoEsame;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}
	
	public TipologiaEsame getTipologiaEsame() {
		return tipologiaEsame;
	}
	
	public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsame = tipologiaEsame;
	}
	
	public String getPaziente() {
		return pazienteEsame;
	}
	
	public void setPaziente(String pazienteEsame) {
		this.pazienteEsame = pazienteEsame;
	}
}