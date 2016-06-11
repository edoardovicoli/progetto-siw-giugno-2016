package it.uniroma3.progetto.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class EsamePaziente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String codice;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPrenotazione;
	
	@Temporal(TemporalType.DATE)
	private Date dataSvolgimento;
	
	@OneToOne
	private TipologiaEsame tipologiaEsame;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
	private List<Esame> esami;
	
	@OneToOne
	private Paziente paziente;
	
	@OneToOne
	private Medico medico;
	
	public EsamePaziente() {}

	public EsamePaziente(String codice, Date dataSvolgimento) {
		super();
		this.codice = codice;
		this.dataSvolgimento = dataSvolgimento;
		this.esami = new ArrayList<Esame>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDataSvolgimento() {
		return dataSvolgimento;
	}

	public void setDataSvolgimento(Date dataSvolgimento) {
		this.dataSvolgimento = dataSvolgimento;
	}

	public List<Esame> getEsami() {
		return esami;
	}

	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}

	public Paziente getPaziente() {
		return paziente;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public TipologiaEsame getTipologiaEsame() {
		return tipologiaEsame;
	}

	public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsame = tipologiaEsame;
	}	
}
