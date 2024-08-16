package com.br.utfpr.tsi.delegacia.web.api.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Veiculo {
	
	private Placa placa;
	private int ano;
	private String cor;
	private String marca;
	private String tipoVeiculo;
	private BoletimFurto boletim;
}
