package com.br.utfpr.tsi.delegacia.web.api.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.utfpr.tsi.delegacia.web.api.model.BoletimFurto;
import com.br.utfpr.tsi.delegacia.web.api.repository.BoletimFurtoRepository;

@Component
public class ValidatorImplementation implements Validator
{
	@Autowired
	private BoletimFurtoRepository repository;
	
	@Override
	public String verificadorIdentificador() {
		boolean aux = true;
		String identificador = "";
		
		while (aux == true) 
		{
			String auxIdent = UUID.randomUUID().toString();
			
			BoletimFurto boletim = this.repository.procurarPorIdentificador(auxIdent);
			
			if (boletim == null) 
			{
				identificador = auxIdent;
				aux = false;
			}
		}
		
		return identificador;
	}

	@Override
	public boolean verificarDadosObrigatorios(BoletimFurto boletim) {
		boolean dadosNulos = false;

		List<String> dados = new ArrayList<>();
		
		dados.add(boletim.getDataOcorrido());
		dados.add(boletim.getPeriodoOcorrido());

		if (boletim.getLocalOcorrido() != null) 
		{
			int numero = boletim.getLocalOcorrido().getNumero();
			
			if (numero == 0) {
				dados.add(null);
			}
			else
			{
				dados.add(String.valueOf(numero));
			}
			
			dados.add(boletim.getLocalOcorrido().getRua());
			dados.add(boletim.getLocalOcorrido().getBairro());
			dados.add(boletim.getLocalOcorrido().getCidade());
			dados.add(boletim.getLocalOcorrido().getEstado());
			
		}
		else
		{
			dados.add(null);
		}
		
		if (boletim.getVeiculoFurtado() != null) 
		{
			dados.add(String.valueOf(boletim.getVeiculoFurtado().getAnoFabricacao()));
			dados.add(boletim.getVeiculoFurtado().getCor());
			dados.add(boletim.getVeiculoFurtado().getMarca());
			dados.add(boletim.getVeiculoFurtado().getTipoVeiculo());
			
			if (boletim.getVeiculoFurtado().getEmplacamento() != null) 
			{
				dados.add(boletim.getVeiculoFurtado().getEmplacamento().getCodigo());
				dados.add(boletim.getVeiculoFurtado().getEmplacamento().getCidade());
				dados.add(boletim.getVeiculoFurtado().getEmplacamento().getEstado());
			}
			else
			{
				dados.add(null);
			}
		}
		else
		{
			dados.add(null);
		}
		
		if (boletim.getEnvolvidos() != null) 
		{
			dados.add(boletim.getEnvolvidos().getNome());
			dados.add(boletim.getEnvolvidos().getEmail());
			dados.add(boletim.getEnvolvidos().getTelefone());
		}
		else
		{
			dados.add(null);
		}

		for (String dado : dados) 
		{
			if (dado == null || dado.isEmpty()) 
			{
				dadosNulos = true;
				break;
			}
		}
		
		return dadosNulos;
	}

	@Override
	public boolean verificarEmail(String email) {
		String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		return Pattern.matches(regex, email);
	}

	@Override
	public boolean verificarData(String data) {
		String regex = "^(0?[1-9]|[12][0-9]|3[01])[\\/](0?[1-9]|1[012])[\\/]\\d{4}$";
		return Pattern.matches(regex, data);
	}

	@Override
	public boolean verificarPlaca(String placa) {
		String regex = "^[A-Za-z]{3}[-]?\\d{4}$";
		return Pattern.matches(regex, placa);
	}

	@Override
	public boolean verificarTelefone(String numeroTelefone) {
		String regex = "^\\(\\d{2}\\)\\d{4,5}[-]\\d{4}$";
		return Pattern.matches(regex, numeroTelefone);
	}
}