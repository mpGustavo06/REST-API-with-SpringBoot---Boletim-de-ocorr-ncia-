package com.br.utfpr.tsi.delegacia.web.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Envolvido {
   
	@Id
	private String cpf;
	
	private String nome;
	private String email;
	private String tipoEnvolvimento;
	private String telefoneContato;
	
	public Envolvido() {}

	public Envolvido(String cpf, String nome, String email, String tipoEnvolvimento, String telefoneContato) 
	{
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.tipoEnvolvimento = tipoEnvolvimento;
		this.telefoneContato = telefoneContato;
	}
}
