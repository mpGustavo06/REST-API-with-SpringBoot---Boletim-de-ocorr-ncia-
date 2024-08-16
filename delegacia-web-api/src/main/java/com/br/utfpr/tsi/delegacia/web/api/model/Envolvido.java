package com.br.utfpr.tsi.delegacia.web.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Envolvido {

	@Id
	private String cpf;
	
	private String nome;
	private String email;
	private String tipoEnvolvimento;
	private String telefoneContato;
}
