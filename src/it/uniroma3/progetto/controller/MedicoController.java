package it.uniroma3.progetto.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;

import it.uniroma3.progetto.model.EsamePaziente;
import it.uniroma3.progetto.model.EsamePazienteFacade;
import it.uniroma3.progetto.model.Medico;
import it.uniroma3.progetto.model.MedicoFacade;

@ManagedBean
public class MedicoController {
	private String codice;
	private String nome;
	private String cognome;
	private String specializzazione;
	private Medico medico;
	private String messaggioSuccesso;
	private String messaggioFallimento;
	
	private Long idMedicoPerEsami;
	private String nomeMedicoPerEsami;
	private String cognomeMedicoPerEsami;
	private Medico medicoPerEsami;
	private List<EsamePaziente> listaEsamiPazientePerEsami;
	
	private String medicoSelezionato;
	private List<String> mediciSelezionabili;
	
	@EJB
	private MedicoFacade medicoFacade;
	
	@EJB
	private EsamePazienteFacade esamePazienteFacade;
	
	public MedicoController() {}
	
	public String createMedico() {
		this.medico = this.medicoFacade.findByCodiceMedico(this.codice);
		if (this.medico==null) {
			this.medico = new Medico(this.codice, this.nome, this.cognome, this.specializzazione);
			this.medico = this.medicoFacade.createMedico(this.medico);
			this.messaggioSuccesso = "Medico inserito con successo!";
		} else {
			this.messaggioSuccesso = null;
			this.messaggioFallimento = "Il medico inserito è già presente nell'anagrafica!";
		}
		
		// riazzero i campi
		this.codice = "";
		this.nome = "";
		this.cognome = "";
		this.specializzazione = "";
		return "newMedico";
	}
	
	public String esamiMedico() {
		if (this.nomeMedicoPerEsami.equals("") && this.cognomeMedicoPerEsami.equals("")) {
			this.medicoSelezionato.trim();
			int indiceSpazioBianco = this.medicoSelezionato.indexOf(" ");
			this.nomeMedicoPerEsami = this.medicoSelezionato.substring(0, indiceSpazioBianco);
			this.cognomeMedicoPerEsami = this.medicoSelezionato.substring(indiceSpazioBianco+1);
			System.out.println("NOME MEDICO: " + this.nomeMedicoPerEsami);
			System.out.println("COGNOME MEDICO: " + this.cognomeMedicoPerEsami);
		}
		this.listaEsamiPazientePerEsami = this.esamePazienteFacade.findAllEsamiByMedicoNomeCognome(this.nomeMedicoPerEsami, this.cognomeMedicoPerEsami);
		if (this.listaEsamiPazientePerEsami.isEmpty()) {
			System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||");
		} else {
			for (EsamePaziente ep:listaEsamiPazientePerEsami) {
				System.out.println("_______________________________________________" + ep.getDataSvolgimento());
			}
		}
		this.nomeMedicoPerEsami = "";
		this.cognomeMedicoPerEsami = "";
		return "esamiMedico";
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getSpecializzazione() {
		return specializzazione;
	}

	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public String getMessaggioSuccesso() {
		return messaggioSuccesso;
	}

	public void setMessaggioSuccesso(String messaggioSuccesso) {
		this.messaggioSuccesso = messaggioSuccesso;
	}

	public String getMessaggioFallimento() {
		return messaggioFallimento;
	}

	public void setMessaggioFallimento(String messaggioFallimento) {
		this.messaggioFallimento = messaggioFallimento;
	}

	public String getNomeMedicoPerEsami() {
		return nomeMedicoPerEsami;
	}

	public void setNomeMedicoPerEsami(String nomeMedicoPerEsami) {
		this.nomeMedicoPerEsami = nomeMedicoPerEsami;
	}

	public String getCognomeMedicoPerEsami() {
		return cognomeMedicoPerEsami;
	}

	public void setCognomeMedicoPerEsami(String cognomeMedicoPerEsami) {
		this.cognomeMedicoPerEsami = cognomeMedicoPerEsami;
	}

	public Medico getMedicoPerEsami() {
		return medicoPerEsami;
	}

	public void setMedicoPerEsami(Medico medicoPerEsami) {
		this.medicoPerEsami = medicoPerEsami;
	}

	public Long getIdMedicoPerEsami() {
		return idMedicoPerEsami;
	}

	public void setIdMedicoPerEsami(Long idMedicoPerEsami) {
		this.idMedicoPerEsami = idMedicoPerEsami;
	}

	public List<EsamePaziente> getListaEsamiPazientePerEsami() {
		return listaEsamiPazientePerEsami;
	}

	public void setListaEsamiPazientePerEsami(List<EsamePaziente> listaEsamiPazientePerEsami) {
		this.listaEsamiPazientePerEsami = listaEsamiPazientePerEsami;
	}

	public String getMedicoSelezionato() {
		return medicoSelezionato;
	}

	public void setMedicoSelezionato(String medicoSelezionato) {
		this.medicoSelezionato = medicoSelezionato;
	}

	public List<String> getMediciSelezionabili() {
		List<String> mediciSelezionabili = new ArrayList<String>();
		List<Medico> listaMedici = this.medicoFacade.findAllMedici();
		for(Medico m:listaMedici) {
			String nomeMedico = /* m.getCodice() + ": " + */m.getNome() + " " + m.getCognome()/* + " - " + m.getSpecializzazione()*/;
			mediciSelezionabili.add(nomeMedico);
		}
		return mediciSelezionabili;
	}

	public void setMediciSelezionabili(List<String> mediciSelezionabili) {
		this.mediciSelezionabili = mediciSelezionabili;
	}
	
}
