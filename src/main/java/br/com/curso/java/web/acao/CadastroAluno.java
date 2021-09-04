package br.com.curso.java.web.acao;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.java.web.model.Aluno;
import br.com.curso.java.web.model.Banco;

public class CadastroAluno implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		Integer id = banco.getAlunos().size() == 0 ? 0 :banco.getAlunos().size();
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String curso = request.getParameter("curso");
		
		if (nome != null && curso != null) {
			Aluno novoAluno = new Aluno(id ,nome, email, curso, new Date());
			banco.adiciona(novoAluno);
			request.setAttribute("nomeAluno", novoAluno.getNome());
		}
		return "redirect:listaAlunos";
		
	}
}
