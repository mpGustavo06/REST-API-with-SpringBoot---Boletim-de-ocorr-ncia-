package com.br.utfpr.tsi.delegacia.web.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class BoletimFurto {

	@Id
	private String identificador;
	
	private String dataOcorrido;
	private String periodoOcorrido;
	private String envolvidos;
	private String localOcorrido;
	private String veiculoFurtado;
}
