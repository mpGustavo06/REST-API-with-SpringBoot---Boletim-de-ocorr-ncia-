package com.br.utfpr.tsi.delegacia.web.api.model;

import lombok.Data;

@Data
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
}
