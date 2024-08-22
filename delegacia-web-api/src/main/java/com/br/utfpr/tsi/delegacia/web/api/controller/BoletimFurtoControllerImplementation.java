package com.br.utfpr.tsi.delegacia.web.api.controller;

import java.sql.SQLException;
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
	public BoletimFurto alterarBoletim(String identificador, BoletimFurto boletim) {
		Optional<BoletimFurto> novoBoletim = procurarPorIdentificador(identificador);
		
		novoBoletim.get().setCrime(boletim.getCrime());
		novoBoletim.get().setDataOcorrido(boletim.getDataOcorrido());
		novoBoletim.get().setEnvolvidos(boletim.getEnvolvidos());
		novoBoletim.get().setLocalOcorrido(boletim.getLocalOcorrido());
		novoBoletim.get().setPeriodoOcorrido(boletim.getPeriodoOcorrido());
		novoBoletim.get().setVeiculoFurtado(boletim.getVeiculoFurtado());
		
		return repositoryBoletim.save(novoBoletim.get());
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
	public List<BoletimFurto> procurarPorCidade(String cidade) throws SQLException {
		return repositoryImplementation.findBoletimByCidade(cidade);
	}

	@Override
	public List<BoletimFurto> procurarPorPeriodo(String periodo) throws SQLException {
		return repositoryImplementation.findBoletimByPeriodo(periodo);
	}

	@Override
	public List<Veiculo> listarVeiculos() {
		return repositoryVeiculo.findAll();
	}

	@Override
	public Optional<Veiculo> procurarPorPlaca(Placa placa) throws SQLException {
		return repositoryImplementation.findVeiculoByPlaca(placa.getCodigo());
	}

	@Override
	public List<Veiculo> procurarPorCor(String cor) throws SQLException {
		return repositoryImplementation.findVeiculoByCor(cor);
	}

	@Override
	public List<Veiculo> procurarPorTipo(String tipo) throws SQLException {
		return repositoryImplementation.findVeiculoByTipo(tipo);
	}
	
	public Optional<Veiculo> procurarPorId(int id) {
		return repositoryVeiculo.findById(id);
	}
}
