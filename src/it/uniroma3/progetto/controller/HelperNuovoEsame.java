package it.uniroma3.progetto.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.validator.routines.DateValidator;

public class HelperNuovoEsame {
	public boolean validate(HttpServletRequest request, HttpServletResponse response) {
		String nomeEsame, dataSvolgimentoEsame, tipologiaEsame;
		String nomeEsameError, dataSvolgimentoEsameError, tipologiaEsameError;
		boolean corretto = true;
		
		nomeEsame = request.getParameter("nomeEsame");
		dataSvolgimentoEsame = request.getParameter("dataSvolgimentoEsame");
		tipologiaEsame = request.getParameter("tipologiaEsame");
		
		DateValidator dateValidator = new DateValidator();
		
		if (nomeEsame.equals("")) {
			corretto = false;
			nomeEsameError = "Nome: Campo Obbligatorio";
			request.setAttribute("nomeEsameError", nomeEsameError);
		}
		
		if (dataSvolgimentoEsame.equals("")) {
			corretto = false;
			dataSvolgimentoEsameError = "Data svolgimento: Campo Obbligatorio";
			request.setAttribute("dataSvolgimentoEsameError", dataSvolgimentoEsameError);
		}
		
		if (tipologiaEsame.equals("")) {
			corretto = false;
			tipologiaEsameError = "Tipologia esame: Campo Obbligatorio";
			request.setAttribute("tipologiaEsameError", tipologiaEsameError);
		}
		
		if (dateValidator.validate(dataSvolgimentoEsame)==null) {
			corretto = false;
			dataSvolgimentoEsameError = "Formato data non valido";
		    request.setAttribute("dataSvolgimentoEsameError", dataSvolgimentoEsameError);
		}
		
		return corretto;
	}
}
