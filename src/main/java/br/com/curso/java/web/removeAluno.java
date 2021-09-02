package br.com.curso.java.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/removeAluno")
public class removeAluno extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer id = Integer.valueOf(req.getParameter("id"));
		Banco banco = new Banco();
		banco.remove(id);
		res.sendRedirect("listarAlunos");
	}

}
