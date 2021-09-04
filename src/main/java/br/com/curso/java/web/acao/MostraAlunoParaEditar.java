package br.com.curso.java.web.acao;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.java.web.model.Aluno;
import br.com.curso.java.web.model.Banco;

public class MostraAlunoParaEditar implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		Integer id = Integer.valueOf(request.getParameter("id"));
		Aluno alunoParaEditar = banco.getById(id);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		alunoParaEditar.setDataFormatada(sdf.format(alunoParaEditar.getData()));
		request.setAttribute("aluno", alunoParaEditar);		
		return "forward:fromEditaAluno.jsp";
	}
		
}
