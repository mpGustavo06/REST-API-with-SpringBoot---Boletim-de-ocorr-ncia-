package com.br.utfpr.tsi.delegacia.web.api.controller;

import java.util.List;
import com.br.utfpr.tsi.delegacia.web.api.model.Placa;
import com.br.utfpr.tsi.delegacia.web.api.model.Veiculo;

public interface VeiculoController 
{
	void cadastrarVeiculo(Veiculo veiculo);
	
	List<Veiculo> listarVeiculos();
	
	Veiculo procurarPorPlaca(Placa placaCodigo);
	
	List<Veiculo> procurarPorCor(String cor);
	
	List<Veiculo> procurarPorTipo(String tipo);
}
