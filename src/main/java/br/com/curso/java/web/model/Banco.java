package br.com.curso.java.web.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Banco {
	private static List<Aluno> alunoList = new ArrayList<>();
	private static Integer id = 1;
	
	public void adiciona(Aluno novoAluno) {
		alunoList.add(novoAluno.getId(),novoAluno);
	}
	
	public List<Aluno> getAlunos() {
		return this.alunoList;
	}
	
	public void remove(Integer id) {
		List<Aluno> alunoParaSerExcluido = this.getAlunos().stream().filter(obj -> obj.getId().equals(id)).collect(Collectors.toList());
		if(alunoParaSerExcluido.size() == 1) {
			this.getAlunos().remove(alunoParaSerExcluido.get(0));	
		}else {
			throw new RuntimeException("Id duplicado");
		}
		
	}
	
	public Aluno getById(Integer id) {
		List<Aluno> aluno = this.getAlunos().stream().filter(obj -> obj.getId().equals(id)).collect(Collectors.toList());
		if(aluno.size() == 1) {
			return aluno.get(0);
		}else {
			throw new RuntimeException("Id duplicado");
		}
	}
	
	public void edita(Aluno aluno) {
		remove(aluno.getId());
		alunoList.add(aluno.getId(), aluno);
	}
	
	
}
