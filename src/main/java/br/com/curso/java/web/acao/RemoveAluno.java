package br.com.curso.java.web.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.java.web.model.Banco;

public class RemoveAluno implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		Banco banco = new Banco();
		banco.remove(id);
		return "redirect:listaAlunos";
	}
}
