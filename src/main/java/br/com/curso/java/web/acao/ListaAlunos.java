package br.com.curso.java.web.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.java.web.model.Aluno;
import br.com.curso.java.web.model.Banco;

public class ListaAlunos implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		request.setAttribute("alunosList", banco.getAlunos());
		return "forward:listaAlunos.jsp";
	}
}	
