package it.uniroma3.progetto.controller;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import it.uniroma3.progetto.model.Paziente;
import it.uniroma3.progetto.model.PazienteFacade;

@ManagedBean
public class LoginPazienteController {
	private String codiceFiscale;
	private String messaggioErrore;
	
	@EJB
	private PazienteFacade pazienteFacade;
	
	public String validate() {
		this.codiceFiscale = this.codiceFiscale.trim();
		Paziente paziente = this.pazienteFacade.findByCF(this.codiceFiscale);
		if (paziente == null) {
			this.messaggioErrore = "Il paziente non è presente nell'anagrafica!";
			return "loginPaziente";
		} else {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
			session.setAttribute("cf", codiceFiscale);
			return "consultaRisultati";
		}
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getMessaggioErrore() {
		return messaggioErrore;
	}

	public void setMessaggioErrore(String messaggioErrore) {
		this.messaggioErrore = messaggioErrore;
	}
	
}
