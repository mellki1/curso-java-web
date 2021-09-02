package br.com.curso.java.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editaAluno")
public class EditaAluno extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Banco banco = new Banco();
		Integer id = Integer.valueOf(req.getParameter("id"));
		Aluno alunoParaEditar = banco.getById(id);
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String curso = req.getParameter("curso");
		String dataFormatada = req.getParameter("data");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			alunoParaEditar.setData(sdf.parse(dataFormatada));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Aluno novoAluno = new Aluno(id ,nome, email, curso, new Date());
		banco.edita(novoAluno);
		res.sendRedirect("listarAlunos");
	}
}
