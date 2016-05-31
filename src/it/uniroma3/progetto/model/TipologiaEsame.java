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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
public class TipologiaEsame {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@OneToMany
	private List<PrerequisitoEsame> prerequisitiEsame;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
	private List<Esame> esami;
	
	public TipologiaEsame() {}
	
	public TipologiaEsame(String nome) {
		this.nome = nome;
		this.esami = new ArrayList<Esame>();
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

	@Override
	public String toString() {
		return "TipologiaEsame [id=" + id + ", nome=" + nome + "]";
	}
	
}
