package com.br.utfpr.tsi.delegacia.web.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Placa {
	
	@Id
	private String codigo;
	
	private String estado;
	private String cidade;
}
