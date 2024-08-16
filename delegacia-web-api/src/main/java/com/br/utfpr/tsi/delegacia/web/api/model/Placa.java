package com.br.utfpr.tsi.delegacia.web.api.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Placa {

	private String placa;
	private String estado;
	private String cidade;
	
	public Placa(String placa, String estado, String cidade) {
		this.placa = placa;
		this.estado = estado;
		this.cidade = cidade;
	}	
}
