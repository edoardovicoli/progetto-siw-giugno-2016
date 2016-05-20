package it.uniroma3.progetto.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.validator.routines.DateValidator;

public class HelperNuovaTipologiaEsame {
	public boolean validate(HttpServletRequest request, HttpServletResponse response) {
		String nomeTipologiaEsame;
		String nomeTipologiaEsameError;
		boolean corretto = true;
		
		nomeTipologiaEsame = request.getParameter("nomeTipologiaEsame");
		
		if (nomeEsame.equals("")) {
			corretto = false;
			nomeEsameError = "Nome: Campo Obbligatorio";
			request.setAttribute("nomeEsameError", nomeEsameError);
		}
		
		return corretto;
	}
}