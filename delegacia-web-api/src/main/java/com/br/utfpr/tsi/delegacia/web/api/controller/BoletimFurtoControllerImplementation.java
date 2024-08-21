package com.br.utfpr.tsi.delegacia.web.api.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.br.utfpr.tsi.delegacia.web.api.model.BoletimFurto;
import com.br.utfpr.tsi.delegacia.web.api.model.Placa;
import com.br.utfpr.tsi.delegacia.web.api.model.Veiculo;
import com.br.utfpr.tsi.delegacia.web.api.repository.BoletimFurtoRepository;
import com.br.utfpr.tsi.delegacia.web.api.repository.RepositoryImplementation;
import com.br.utfpr.tsi.delegacia.web.api.repository.VeiculoRepository;

@Component
public class BoletimFurtoControllerImplementation implements BoletimFurtoController {
	@Autowired
	BoletimFurtoRepository repositoryBoletim;
	
	@Autowired
	VeiculoRepository repositoryVeiculo;
	
	RepositoryImplementation repositoryImplementation;
	
	@Override
	public void cadastrarBoletim(BoletimFurto boletim) {
		repositoryBoletim.save(boletim);
	}

	@Override
	public void alterarBoletim(BoletimFurto boletim) {
		repositoryImplementation.alterarBoletim(boletim);
	}

	@Override
	public void removerBoletim(String identificador) {
		repositoryBoletim.deleteById(identificador);
	}

	@Override
	public List<BoletimFurto> listarBoletins() {
		return repositoryBoletim.findAll();
	}

	@Override
	public Optional<BoletimFurto> procurarPorIdentificador(String identificador) {
		return repositoryBoletim.findById(identificador);
	}

	@Override
	public List<BoletimFurto> procurarPorCidade(String cidade) {
		return repositoryImplementation.findBoletimByCidade(cidade);
	}

	@Override
	public List<BoletimFurto> procurarPorPeriodo(String periodo) {
		return repositoryImplementation.findBoletimByPeriodo(periodo);
	}

	@Override
	public List<Veiculo> listarVeiculos() {
		return repositoryVeiculo.findAll();
	}

	@Override
	public Optional<Veiculo> procurarPorPlaca(Placa placa) {
		return repositoryImplementation.findVeiculoByPlaca(placa);
	}

	@Override
	public List<Veiculo> procurarPorCor(String cor) {
		return repositoryImplementation.findVeiculoByCor(cor);
	}

	@Override
	public List<Veiculo> procurarPorTipo(String tipo) {
		return repositoryImplementation.findVeiculoByTipo(tipo);
	}
}
