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
	
	@ManyToOne
	private Envolvido envolvidos;
	
	private String crime;
	private LocalDate dataOcorrido;
	private String periodoOcorrido;
	
	public BoletimFurto() {}
	
	public BoletimFurto(String identificador) 
	{
		this.identificador = identificador;
	}
	
	public BoletimFurto(String identificador, Endereco localOcorrido, Veiculo veiculoFurtado, 
						Envolvido envolvidos, String crime, LocalDate dataOcorrido, String periodoOcorrido) 
	{
		this.identificador = identificador;
		this.localOcorrido = localOcorrido;
		this.veiculoFurtado = veiculoFurtado;
		this.envolvidos = envolvidos;
		this.crime = crime;
		this.dataOcorrido = dataOcorrido;
		this.periodoOcorrido = periodoOcorrido;
	}
}
