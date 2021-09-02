package br.com.curso.java.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class listarAlunos
 */
@WebServlet("/listarAlunos")
public class ListarAlunos extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Banco banco = new Banco();
		req.setAttribute("alunosList", banco.getAlunos());
		RequestDispatcher dispatcher = req.getRequestDispatcher("listarAlunos.jsp");
		dispatcher.forward(req, resp);
	}
}
