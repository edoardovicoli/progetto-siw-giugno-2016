package it.uniroma3.progetto.controller;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;

import it.uniroma3.progetto.model.Esame;
import it.uniroma3.progetto.model.EsamePaziente;
import it.uniroma3.progetto.model.EsamePazienteFacade;

@ManagedBean
public class ConsultaRisultatiController {
	private String codiceFiscale;
	private List<EsamePaziente> esamiDelPaziente;
	private DataModel<EsamePaziente> esamiDelPazienteModel;
	private EsamePaziente esamePazienteSelezionato;
	
	private List<Esame> esamiConRisultato;
	
	@EJB
	private EsamePazienteFacade esamePazienteFacade;

	public String getCodiceFiscale() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		this.codiceFiscale = (String)session.getAttribute("cf");
		return codiceFiscale;
	}
	
	public String controlloRisultati() {
		this.esamePazienteSelezionato = this.esamiDelPazienteModel.getRowData();
		this.esamiConRisultato = this.esamePazienteSelezionato.getEsami();
		return "controlloRisultatiEsame";
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public List<EsamePaziente> getEsamiDelPaziente() {
		this.esamiDelPaziente = this.esamePazienteFacade.findAllEsamiByPazienteCF(this.codiceFiscale);
		return esamiDelPaziente;
	}

	public void setEsamiDelPaziente(List<EsamePaziente> esamiDelPaziente) {
		this.esamiDelPaziente = esamiDelPaziente;
	}

	public DataModel<EsamePaziente> getEsamiDelPazienteModel() {
		this.esamiDelPaziente = this.esamePazienteFacade.findAllEsamiByPazienteCF(this.codiceFiscale);
		this.esamiDelPazienteModel = new ListDataModel<EsamePaziente>(esamiDelPaziente);
		return esamiDelPazienteModel;
	}

	public void setEsamiDelPazienteModel(DataModel<EsamePaziente> esamiDelPazienteModel) {
		this.esamiDelPazienteModel = esamiDelPazienteModel;
	}

	public List<Esame> getEsamiConRisultato() {
		return esamiConRisultato;
	}

	public void setEsamiConRisultato(List<Esame> esamiConRisultato) {
		this.esamiConRisultato = esamiConRisultato;
	}

	public EsamePaziente getEsamePazienteSelezionato() {
		return esamePazienteSelezionato;
	}

	public void setEsamePazienteSelezionato(EsamePaziente esamePazienteSelezionato) {
		this.esamePazienteSelezionato = esamePazienteSelezionato;
	}
	
}
