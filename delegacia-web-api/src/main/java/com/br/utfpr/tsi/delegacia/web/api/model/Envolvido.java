package com.br.utfpr.tsi.delegacia.web.api.model;

public class Envolvido 
{
	private String nome;
	private String email;
	private String telefone;
	
	public Envolvido() {}

	public Envolvido(String nome, String email, String telefone) 
	{
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
