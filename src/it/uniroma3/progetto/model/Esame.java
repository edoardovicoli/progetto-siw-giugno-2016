package it.uniroma3.progetto.model;

import java.util.*;

public class Esame {
	private Long idEsame;
	private String codiceEsame;
	private String nomeEsame;

	public Esame() {}
	
	public Long getIdEsame() {
		return idEsame;
	}

	public void setIdEsame(Long idEsame) {
		this.idEsame = idEsame;
	}
	
	public String getCodiceEsame() {
		return codiceEsame;
	}

	public void setCodiceEsame(String codiceEsame) {
		this.codiceEsame = codiceEsame;
	}
	
	public String getNomeEsame() {
		return nomeEsame;
	}

	public void setNomeEsame(String nomeEsame) {
		this.nomeEsame = nomeEsame;
	}
}