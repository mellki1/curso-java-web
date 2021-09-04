package br.com.curso.java.web.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.java.web.model.Aluno;
import br.com.curso.java.web.model.Banco;

public class EditaAluno implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		Integer id = Integer.valueOf(request.getParameter("id"));
		Aluno alunoParaEditar = banco.getById(id);
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String curso = request.getParameter("curso");
		String dataFormatada = request.getParameter("data");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Aluno alunoEditado = new Aluno(id, nome, email, curso, sdf.parse(dataFormatada));
			banco.edita(alunoEditado);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return "redirect:listaAlunos";
	}

}
