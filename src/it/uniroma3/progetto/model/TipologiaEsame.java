package it.uniroma3.progetto.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
public class TipologiaEsame {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String codice;
	
	@Column(nullable = false)
	private String costo;
	
	@Column(nullable = false)
	private String descrizione;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
	private List<PrerequisitoEsame> prerequisitiEsame;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
	private List<Esame> esami;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private EsamePaziente esamePaziente;
	
	public TipologiaEsame() {}
	
	public TipologiaEsame(String nome, String codice, String costo, String descrizione) {
		this.nome = nome;
		this.codice = codice;
		this.costo = costo;
		this.descrizione = descrizione;
		this.esami = new ArrayList<Esame>();
		this.prerequisitiEsame = new ArrayList<PrerequisitoEsame>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<PrerequisitoEsame> getPrerequisitiEsame() {
		return prerequisitiEsame;
	}

	public void setPrerequisitiEsame(List<PrerequisitoEsame> prerequisitiEsame) {
		this.prerequisitiEsame = prerequisitiEsame;
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

	public EsamePaziente getEsamePaziente() {
		return esamePaziente;
	}

	public void setEsamePaziente(EsamePaziente esamePaziente) {
		this.esamePaziente = esamePaziente;
	}

	@Override
	public String toString() {
		return "TipologiaEsame [id=" + id + ", nome=" + nome + "]";
	}
	
}
