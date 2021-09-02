package br.com.curso.java.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/mostraAlunoParaEditar")
public class MostraAlunoParaEditar extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Banco banco = new Banco();
		Integer id = Integer.valueOf(req.getParameter("id"));
		Aluno alunoParaEditar = banco.getById(id);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		alunoParaEditar.setDataFormatada(sdf.format(alunoParaEditar.getData()));
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/fromEditaAluno.jsp");
		req.setAttribute("aluno", alunoParaEditar);
		requestDispatcher.forward(req, res);
	}

}
