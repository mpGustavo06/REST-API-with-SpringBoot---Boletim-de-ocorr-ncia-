package com.br.utfpr.tsi.delegacia.web.api.model;

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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}
