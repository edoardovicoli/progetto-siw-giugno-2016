package it.uniroma3.progetto.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.routines.DateValidator;

import it.uniroma3.progetto.model.Facade;
import it.uniroma3.progetto.model.Esame;
import it.uniroma3.progetto.model.TipologiaEsame;

public class ActionNuovoEsame extends Action {
	
	@Override
	public String execute(HttpServletRequest request) {
		Facade facade = new Facade();
		Esame esame = new Esame();
		
		esame.setNomeEsame(request.getParameter("nomeEsame"));
		DateValidator dateValidator = new DateValidator();
		esame.setDataSvolgimentoEsame(dateValidator.validate(request.getParameter("dataSvolgimentoEsame")));
		
		String nomeTipologiaEsame = request.getParameter("tipologiaEsame");
		TipologiaEsame tipologiaEsame = new TipologiaEsame();
		tipologiaEsame.setNomeTipologiaEsame(nomeTipologiaEsame);
		esame.setTipologiaEsame(tipologiaEsame);
		
		
		facade.creaEsame(esame);
		request.setAttribute("esame", esame);
		return "/esame.jsp";
	}
}
