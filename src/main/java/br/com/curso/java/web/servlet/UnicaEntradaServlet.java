package br.com.curso.java.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.java.web.acao.Acao;


/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/")
public class UnicaEntradaServlet extends HttpServlet {
	   
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
		String url  = req.getRequestURI();
		url = url.split("/")[2];
		String nomeChamada = null;
		try {
			url = url.isEmpty() ? url : Character.toUpperCase(url.charAt(0)) + url.substring(1);
			Class clazz = Class.forName("br.com.curso.java.web.acao."+ url);
			Acao acao = (Acao) clazz.newInstance();
			nomeChamada = acao.executa(req, res);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new ServletException();
		}
		
		if (nomeChamada != null) {
			if (nomeChamada.contains("forward")) {
				nomeChamada = nomeChamada.replace("forward:", "");
				RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/" + nomeChamada);
				dispatcher.forward(req, res);
			}else {
				nomeChamada = nomeChamada.replace("redirect:", "");
				res.sendRedirect(nomeChamada);
			}
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/paginaNaoEncontrada.jsp");
			dispatcher.forward(req, res);
		}
		
	
	}

}
