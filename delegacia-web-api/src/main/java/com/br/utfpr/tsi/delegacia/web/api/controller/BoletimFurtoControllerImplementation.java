package com.br.utfpr.tsi.delegacia.web.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.br.utfpr.tsi.delegacia.web.api.model.BoletimFurto;
import com.br.utfpr.tsi.delegacia.web.api.model.Veiculo;
import com.br.utfpr.tsi.delegacia.web.api.repository.BoletimFurtoRepository;
import com.br.utfpr.tsi.delegacia.web.api.repository.VeiculoRepository;
import com.br.utfpr.tsi.delegacia.web.api.validators.Validator;

@Component
public class BoletimFurtoControllerImplementation implements BoletimFurtoController 
{
	@Autowired
	private BoletimFurtoRepository boletimRepository;
	@Autowired
	private VeiculoRepository veiculoRepository;
	@Autowired
	private Validator validator;
	
	@Override
	public void cadastrarBoletim(BoletimFurto boletim) throws Exception {
		if (validator.verificarDadosObrigatorios(boletim)) 
		{
			throw new Exception("Todos as informações são obrigatórias!");
		}
		else if (!validator.verificarEmail(boletim.getEnvolvidos().getEmail())) 
		{
			throw new Exception("Digite o e-mail corretamente!");
		}
		else if (!validator.verificarTelefone(boletim.getEnvolvidos().getTelefone())) 
		{
			throw new Exception("Digite o telefone corretamente! Exemplo: (00)00000-0000");
		}
		else if (!validator.verificarData(boletim.getDataOcorrido().toString())) 
		{
			throw new Exception("Digite a data corretamente! Exemplo: 12/12/1212");
		}
		else if (!validator.verificarPlaca(boletim.getVeiculoFurtado().getEmplacamento().getCodigo())) 
		{
			throw new Exception("Digite a placa corretamente! Exemplo: AAA1111");
		}
		else
		{
			if (boletim.isNull()) 
			{
				boletim.setIdentificador(validator.verificadorIdentificador());
			}
			
			boletimRepository.cadastrarBoletim(boletim);
			
			Veiculo veiculo = boletim.getVeiculoFurtado();
			veiculo.setEnvolvidoEm(new BoletimFurto(boletim.getIdentificador()));
			veiculoRepository.cadastrarVeiculo(veiculo);
		}
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
	public List<BoletimFurto> listarBoletins() throws Exception {
		List<BoletimFurto> boletins = this.boletimRepository.listarBoletins();
		
		for (BoletimFurto boletim : boletins) {
			boletim.setEnvolvidos(null);
		}
		
		if (boletins.isEmpty() || boletins == null) 
		{
			throw new Exception("Boletins não encontrados!");
		}
		else
		{
			return boletins;
		}
	}

	@Override
	public BoletimFurto procurarPorIdentificador(String identificador) throws Exception {
		BoletimFurto boletim = this.boletimRepository.procurarPorIdentificador(identificador);
		
		if (boletim == null) 
		{
			throw new Exception("Boletim não encontrado!");
		}
		else
		{
			boletim.setEnvolvidos(null);
			return boletim;
		}
	}

	@Override
	public List<BoletimFurto> procurarPorCidade(String cidade) throws Exception {
		List<BoletimFurto> boletins = this.boletimRepository.procurarPorCidade(cidade);
		
		for (BoletimFurto boletim : boletins) 
		{
			boletim.setEnvolvidos(null);
		}
		
		if (boletins.isEmpty() || boletins == null) 
		{
			throw new Exception("Boletins da cidade: ("+cidade+") não encontrados!");
		}
		else
		{
			return boletins;
		}
	}

	@Override
	public List<BoletimFurto> procurarPorPeriodo(String periodo) throws Exception {
		List<BoletimFurto> boletins = this.boletimRepository.procurarPorPeriodo(periodo);
		
		for (BoletimFurto boletim : boletins) 
		{
			boletim.setEnvolvidos(null);
		}
		
		if (boletins.isEmpty() || boletins == null) 
		{
			throw new Exception("Boletins do periodo: ("+periodo+") não encontrados!");
		}
		else
		{
			return boletins;
		}
	}
}
