package com.br.utfpr.tsi.delegacia.web.api.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class BoletimFurto {

	@Id
	private String identificador;
	
	@ManyToOne
	private Endereco localOcorrido;
	
	@ManyToOne
	private Veiculo veiculoFurtado;
	
	private final String crime = "Furto (art. 155) - VEICULO";
	private LocalDate dataOcorrido; //formato data no DB: 2004-12-31
	private String periodoOcorrido;
	private String envolvidos;
}
