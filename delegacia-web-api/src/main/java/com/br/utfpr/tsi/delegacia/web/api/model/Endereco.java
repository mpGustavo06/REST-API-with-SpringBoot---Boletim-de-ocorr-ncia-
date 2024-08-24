package com.br.utfpr.tsi.delegacia.web.api.model;

import lombok.Data;

@Data
public class Endereco 
{
	private String rua;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	
	public Endereco() {}

	public Endereco(String rua, int numero, String bairro, String cidade, String estado) 
	{
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
}