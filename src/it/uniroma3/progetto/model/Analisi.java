package it.uniroma3.progetto.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
public class Analisi {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//private String codiceAnalisi;
	@Column(nullable = false)
	private String pazienteAnalisi;
	
	@Column(nullable = false)
	private Date dataPrenotazioneEsame;
	
	@Column(nullable = false)
	private Date dataSvolgimentoEsame;
	
	@Column(nullable = false)
	private String medico;
	
	@Column(nullable = false)
	private List<Esame> esamiAnalisi;

	public Analisi() {}
	
	
}
