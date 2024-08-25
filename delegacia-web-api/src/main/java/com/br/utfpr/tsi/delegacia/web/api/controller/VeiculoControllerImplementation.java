package com.br.utfpr.tsi.delegacia.web.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.utfpr.tsi.delegacia.web.api.model.Veiculo;
import com.br.utfpr.tsi.delegacia.web.api.repository.VeiculoRepository;

@Component
public class VeiculoControllerImplementation implements VeiculoController 
{
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Override
	public void cadastrarVeiculo(Veiculo veiculo) {
		this.veiculoRepository.cadastrarVeiculo(veiculo);
	}
	
	@Override
	public List<Veiculo> listarVeiculos() throws Exception {
		List<Veiculo> veiculos = this.veiculoRepository.listarVeiculos();
		
		if (veiculos.isEmpty() || veiculos == null) 
		{
			throw new Exception("Veiculos não encontrados!");
		}
		else
		{
			return veiculos;
		}
	}

	@Override
	public Veiculo procurarPorPlaca(String placaCodigo) throws Exception {
		Veiculo veiculo = this.veiculoRepository.procurarPorPlaca(placaCodigo);
		
		if (veiculo == null) 
		{
			throw new Exception("Veiculo não encontrado!");
		}
		else
		{
			return veiculo;
		}
	}

	@Override
	public List<Veiculo> procurarPorCor(String cor) throws Exception {
		List<Veiculo> veiculos = this.veiculoRepository.procurarPorCor(cor);
		
		if (veiculos.isEmpty() || veiculos == null) 
		{
			throw new Exception("Veiculos não encontrados!");
		}
		else
		{
			return veiculos;
		}
	}

	@Override
	public List<Veiculo> procurarPorTipo(String tipo) throws Exception {
		List<Veiculo> veiculos = this.veiculoRepository.procurarPorTipo(tipo);
		
		if (veiculos.isEmpty() || veiculos == null) 
		{
			throw new Exception("Veiculos não encontrados!");
		}
		else
		{
			return veiculos;
		}
	}
}
