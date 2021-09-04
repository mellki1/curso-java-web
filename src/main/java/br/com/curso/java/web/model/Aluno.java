package br.com.curso.java.web.model;

import java.util.Date;

public class Aluno {
	private Integer id;
	private String nome;
	private String email;
	private String curso;
	private Date data;
	private String dataFormatada;
 	
	
	
	public Aluno(Integer id, String nome, String email, String curso, Date data) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.curso = curso;
		this.data = data;
	}
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDataFormatada() {
		return dataFormatada;
	}

	public void setDataFormatada(String dataFormatada) {
		this.dataFormatada = dataFormatada;
	}
	
	
}
