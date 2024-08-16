package com.br.utfpr.tsi.delegacia.web.api.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Endereco {

	private String rua;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	
	public Endereco(String logradouro, int numero, String bairro, String cidade, String estado) {
		this.rua = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
}
