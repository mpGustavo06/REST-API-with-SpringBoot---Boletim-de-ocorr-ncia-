package com.br.utfpr.tsi.delegacia.web.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.br.utfpr.tsi.delegacia.web.api.model.Placa;
import com.br.utfpr.tsi.delegacia.web.api.model.Veiculo;
import com.br.utfpr.tsi.delegacia.web.api.repository.VeiculoRepository;

public class VeiculoControllerImplementation implements VeiculoController 
{
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Override
	public void cadastrarVeiculo(Veiculo veiculo) {
		this.veiculoRepository.cadastrarVeiculo(veiculo);
	}
	
	@Override
	public List<Veiculo> listarVeiculos() {
		return this.veiculoRepository.listarVeiculos();
	}

	@Override
	public Veiculo procurarPorPlaca(Placa placaCodigo) {
		return this.veiculoRepository.procurarPorPlaca(placaCodigo);
	}

	@Override
	public List<Veiculo> procurarPorCor(String cor) {
		return this.veiculoRepository.procurarPorCor(cor);
	}

	@Override
	public List<Veiculo> procurarPorTipo(String tipo) {
		return this.veiculoRepository.procurarPorTipo(tipo);
	}
}
