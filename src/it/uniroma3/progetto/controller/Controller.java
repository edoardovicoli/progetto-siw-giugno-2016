package it.uniroma3.progetto.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.progetto.action.ActionNuovoEsame;
import it.uniroma3.progetto.controller.HelperNuovoEsame;

///**
// * Servlet implementation class Controller
// */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public Controller() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HelperNuovoEsame helperNuovoEsame = new HelperNuovoEsame();
		ActionNuovoEsame actionNuovoEsame = new ActionNuovoEsame();
		String nextPage = "/creaEsame.jsp";
		
		if (helperNuovoEsame.validate(request, response)) {
			nextPage = actionNuovoEsame.execute(request);
		}
		
		nextPage = response.encodeURL(nextPage);
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		doGet(request, response);
	}

}
