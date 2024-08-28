package com.br.utfpr.tsi.delegacia.web.api.repository;

import java.util.List;
import com.br.utfpr.tsi.delegacia.web.api.model.Veiculo;

public interface VeiculoRepository 
{
	void cadastrarVeiculo(Veiculo veiculo);
	
	boolean alterarVeiculo(Veiculo veiculo);
	
	void removerVeiculo(String placa);
	
	List<Veiculo> listarVeiculos();
	
	Veiculo procurarPorPlaca(String placaCodigo);
	
	List<Veiculo> procurarPorCor(String cor);
	
	List<Veiculo> procurarPorTipo(String tipo);
}
