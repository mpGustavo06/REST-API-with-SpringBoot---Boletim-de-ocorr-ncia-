package com.br.utfpr.tsi.delegacia.web.api.model;

import lombok.Data;

@Data
public class BoletimFurto 
{
	private String identificador;
	private Endereco localOcorrido;
	private Veiculo veiculoFurtado;
	private Envolvido envolvidos;
	private String crime;
	private String dataOcorrido;
	private String periodoOcorrido;
	
	public BoletimFurto() {}
	
	public BoletimFurto(String identificador) 
	{
		this.identificador = identificador;
	}

	public BoletimFurto(String identificador, Endereco localOcorrido, Veiculo veiculoFurtado, Envolvido envolvidos,
						String crime, String dataOcorrido, String periodoOcorrido) 
	{
		this.identificador = identificador;
		this.localOcorrido = localOcorrido;
		this.veiculoFurtado = veiculoFurtado;
		this.envolvidos = envolvidos;
		this.crime = crime;
		this.dataOcorrido = dataOcorrido;
		this.periodoOcorrido = periodoOcorrido;
	}
	
	public boolean isNull() {
		if (this.identificador == null || this.identificador.equalsIgnoreCase("")) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
