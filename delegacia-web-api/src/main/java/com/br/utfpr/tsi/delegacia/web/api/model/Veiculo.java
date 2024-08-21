package com.br.utfpr.tsi.delegacia.web.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Veiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	private Placa emplacamento;
	
	@ManyToOne
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
