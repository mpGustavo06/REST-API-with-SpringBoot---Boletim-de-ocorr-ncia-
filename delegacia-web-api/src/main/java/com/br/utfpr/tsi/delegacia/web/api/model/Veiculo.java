package com.br.utfpr.tsi.delegacia.web.api.model;

import lombok.Data;

@Data
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
}
