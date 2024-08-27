package com.br.utfpr.tsi.delegacia.web.api.model;

public class Veiculo 
{
	private Placa emplacamento;
	private BoletimFurto envolvidoEm;
	private int anoFabricacao;
	private String cor;
	private String marca;
	private String tipoVeiculo;
	
	public Veiculo() {}

	public Veiculo(Placa emplacamento, BoletimFurto envolvidoEm, 
					int anoFabricacao, String cor, String marca, String tipoVeiculo) 
	{
		this.emplacamento = emplacamento;
		this.envolvidoEm = envolvidoEm;
		this.anoFabricacao = anoFabricacao;
		this.cor = cor;
		this.marca = marca;
		this.tipoVeiculo = tipoVeiculo;
	}

	public Placa getEmplacamento() {
		return emplacamento;
	}

	public void setEmplacamento(Placa emplacamento) {
		this.emplacamento = emplacamento;
	}

	public BoletimFurto getEnvolvidoEm() {
		return envolvidoEm;
	}

	public void setEnvolvidoEm(BoletimFurto envolvidoEm) {
		this.envolvidoEm = envolvidoEm;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
}
