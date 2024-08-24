package com.br.utfpr.tsi.delegacia.web.api.model;

import lombok.Data;

@Data
public class Envolvido 
{
	private String nome;
	private String email;
	private String tipoEnvolvimento;
	private String telefoneContato;
	
	public Envolvido() {}

	public Envolvido(String nome, String email, String tipoEnvolvimento, String telefoneContato) 
	{
		this.nome = nome;
		this.email = email;
		this.tipoEnvolvimento = tipoEnvolvimento;
		this.telefoneContato = telefoneContato;
	}
}
