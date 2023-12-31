package com.agenda.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agenda.models.DAO;
import com.agenda.models.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert" })
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String action = request.getServletPath();

		if (action.equals("/main"))
			listContacts(request, response);
		else if (action.equals("/insert"))
			newContact(request, response);
		else
			response.sendRedirect("index.html");

	}

	protected void listContacts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<JavaBeans> list = dao.listContacts();

		request.setAttribute("contacts", list);
		
		// Classe para trabalhar requisições e resposta no JSP
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
		

	}

	protected void newContact(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		contato.setNome(request.getParameter("nome"));
		contato.setTelefone(request.getParameter("telefone"));
		contato.setEmail(request.getParameter("email"));

		dao.newContact(contato);

		response.sendRedirect("main");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
