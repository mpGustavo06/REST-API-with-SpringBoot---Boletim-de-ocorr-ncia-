package com.br.utfpr.tsi.delegacia.web.api.model;

import lombok.Data;

@Data
public class Placa 
{
	private String codigo;
	private String estado;
	private String cidade;
	
	public Placa() {}

	public Placa(String codigo, String estado, String cidade) 
	{
		this.codigo = codigo;
		this.estado = estado;
		this.cidade = cidade;
	}
}
