package com.br.utfpr.tsi.delegacia.web.api.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class BoletimFurto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	private LocalDate dataOcorrido;
	private String periodoOcorrido;
	private Endereco localOcorrido;
	private Veiculo veiculoFurtado;
	private List<Envolvido> envolvidos;
	private final String crime = "Furto de veiculo -  art. 155";
	
	public BoletimFurto() {	}
	
}
