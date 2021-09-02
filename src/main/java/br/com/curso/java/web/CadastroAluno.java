package br.com.curso.java.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CadastroAluno
 */ 
@WebServlet("/cadastroAluno")
public class CadastroAluno extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Banco banco = new Banco();
		Integer id = banco.getAlunos().size()+1;
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String curso = req.getParameter("curso");
		
		Aluno novoAluno = new Aluno(id ,nome, email, curso, new Date());
		
		banco.adiciona(novoAluno);
		req.setAttribute("nomeAluno", novoAluno.getNome());
		res.sendRedirect("listarAlunos");
	}
}
