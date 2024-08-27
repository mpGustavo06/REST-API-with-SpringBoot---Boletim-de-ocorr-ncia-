package com.br.utfpr.tsi.delegacia.web.api.model;

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

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Endereco getLocalOcorrido() {
		return localOcorrido;
	}

	public void setLocalOcorrido(Endereco localOcorrido) {
		this.localOcorrido = localOcorrido;
	}

	public Veiculo getVeiculoFurtado() {
		return veiculoFurtado;
	}

	public void setVeiculoFurtado(Veiculo veiculoFurtado) {
		this.veiculoFurtado = veiculoFurtado;
	}

	public Envolvido getEnvolvidos() {
		return envolvidos;
	}

	public void setEnvolvidos(Envolvido envolvidos) {
		this.envolvidos = envolvidos;
	}

	public String getCrime() {
		return crime;
	}

	public void setCrime(String crime) {
		this.crime = crime;
	}

	public String getDataOcorrido() {
		return dataOcorrido;
	}

	public void setDataOcorrido(String dataOcorrido) {
		this.dataOcorrido = dataOcorrido;
	}

	public String getPeriodoOcorrido() {
		return periodoOcorrido;
	}

	public void setPeriodoOcorrido(String periodoOcorrido) {
		this.periodoOcorrido = periodoOcorrido;
	}
}
