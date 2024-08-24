package com.br.utfpr.tsi.delegacia.web.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.br.utfpr.tsi.delegacia.web.api.model.BoletimFurto;
import com.br.utfpr.tsi.delegacia.web.api.model.Veiculo;
import com.br.utfpr.tsi.delegacia.web.api.repository.BoletimFurtoRepository;
import com.br.utfpr.tsi.delegacia.web.api.repository.VeiculoRepository;

@Component
public class BoletimFurtoControllerImplementation implements BoletimFurtoController 
{
	@Autowired
	private BoletimFurtoRepository boletimRepository;
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Override
	public void cadastrarBoletim(BoletimFurto boletim) {
		if (boletim.getIdentificador() == null) 
		{
			boletim.setIdentificador(UUID.randomUUID().toString());
		}

		boletimRepository.cadastrarBoletim(boletim);
		
		Veiculo veiculo = boletim.getVeiculoFurtado();
		veiculo.setEnvolvidoEm(new BoletimFurto(boletim.getIdentificador()));
		veiculoRepository.cadastrarVeiculo(veiculo);
	}

	@Override
	public void alterarBoletim(BoletimFurto boletim) {
		this.boletimRepository.alterarBoletim(boletim);
	}

	@Override
	public void removerBoletim(String identificador) {
		this.boletimRepository.removerBoletim(identificador);
	}

	@Override
	public List<BoletimFurto> listarBoletins() {
		List<BoletimFurto> boletins = this.boletimRepository.listarBoletins();
		
		for (BoletimFurto boletim : boletins) {
			boletim.setEnvolvidos(null);
		}
		
		return boletins;
	}

	@Override
	public BoletimFurto procurarPorIdentificador(String identificador) {
		return this.boletimRepository.procurarPorIdentificador(identificador);
	}

	@Override
	public List<BoletimFurto> procurarPorCidade(String cidade) {
		List<BoletimFurto> boletins = this.boletimRepository.procurarPorCidade(cidade);
		
		for (BoletimFurto boletim : boletins) {
			boletim.setEnvolvidos(null);
		}
		
		return boletins;
	}

	@Override
	public List<BoletimFurto> procurarPorPeriodo(String periodo) {
		List<BoletimFurto> boletins = this.boletimRepository.procurarPorPeriodo(periodo);
		
		for (BoletimFurto boletim : boletins) {
			boletim.setEnvolvidos(null);
		}
		
		return boletins;
	}
}
