package it.uniroma3.progetto.action;

import javax.servlet.http.HttpServletRequest;

public abstract class Action {
	public abstract String execute(HttpServletRequest request) throws ServletException;
}
