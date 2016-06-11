package it.uniroma3.progetto.controller;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import it.uniroma3.progetto.model.Esame;
import it.uniroma3.progetto.model.EsamePaziente;
import it.uniroma3.progetto.model.EsamePazienteFacade;

@ManagedBean
public class ElencoEsamiInCorsoController {
	private List<EsamePaziente> esamiSostenuti;
	private DataModel<EsamePaziente> esamiSostenutiModel;
	private EsamePaziente esamePazienteSelezionato;
	
	private List<Esame> esamiFatti;
	
	@EJB
	private EsamePazienteFacade esamePazienteFacade;
	
	public String inserimentoRisultati() {
		this.esamePazienteSelezionato = this.esamiSostenutiModel.getRowData();
		this.esamiFatti = this.esamePazienteSelezionato.getEsami();
		return "inserimentoRisultatiEsame";
	}
	
	public String salvaRisultati() {
		this.esamePazienteFacade.updateEsamePaziente(this.esamePazienteSelezionato);
		return "inserimentoRisultatiEsame";
	}

	public List<EsamePaziente> getEsamiSostenuti() {
		this.esamiSostenuti = this.esamePazienteFacade.findAllEsamiPaziente();
		return esamiSostenuti;
	}

	public void setEsamiSostenuti(List<EsamePaziente> esamiSostenuti) {
		this.esamiSostenuti = esamiSostenuti;
	}

	public DataModel<EsamePaziente> getEsamiSostenutiModel() {
		this.esamiSostenuti = this.esamePazienteFacade.findAllEsamiPaziente();
		this.esamiSostenutiModel = new ListDataModel<EsamePaziente>(esamiSostenuti);
		return esamiSostenutiModel;
	}

	public void setEsamiSostenutiModel(DataModel<EsamePaziente> esamiSostenutiModel) {
		this.esamiSostenutiModel = esamiSostenutiModel;
	}

	public EsamePaziente getEsamePazienteSelezionato() {
		return esamePazienteSelezionato;
	}

	public void setEsamePazienteSelezionato(EsamePaziente esamePazienteSelezionato) {
		this.esamePazienteSelezionato = esamePazienteSelezionato;
	}

	public List<Esame> getEsamiFatti() {
		return esamiFatti;
	}

	public void setEsamiFatti(List<Esame> esamiFatti) {
		this.esamiFatti = esamiFatti;
	}
	
}
