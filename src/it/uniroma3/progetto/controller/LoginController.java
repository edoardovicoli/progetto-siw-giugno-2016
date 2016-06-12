package it.uniroma3.progetto.controller;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class LoginController {
	private String username;
	private String password;
	private String messaggioErrore;
	
	public String validate() {
		if (username.equals("admin") && password.equals("admin")) {
			System.out.println("Login ok");
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
			session.setAttribute("utente", "admin");
			return "admin";
		} else {
			this.messaggioErrore = "Errore autenticazione";
			return "loginAdmin";
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessaggioErrore() {
		return messaggioErrore;
	}

	public void setMessaggioErrore(String messaggioErrore) {
		this.messaggioErrore = messaggioErrore;
	}
	
}
