package com.br.utfpr.tsi.delegacia.web.api.controller;

import java.util.List;
import com.br.utfpr.tsi.delegacia.web.api.model.Veiculo;

public interface VeiculoController 
{
	void cadastrarVeiculo(Veiculo veiculo);
	
	List<Veiculo> listarVeiculos() throws Exception;
	
	Veiculo procurarPorPlaca(String placaCodigo) throws Exception;
	
	List<Veiculo> procurarPorCor(String cor) throws Exception;
	
	List<Veiculo> procurarPorTipo(String tipo) throws Exception;
}
