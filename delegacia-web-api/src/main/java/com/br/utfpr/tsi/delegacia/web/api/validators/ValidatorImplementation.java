package com.br.utfpr.tsi.delegacia.web.api.validators;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
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
	public String verificadorIdentificador() throws IOException {
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
		boolean dadosNulos = false; //false = validos | true = invalidos

		List<String> dados = new ArrayList<>();
		
		dados.add(boletim.getDataOcorrido() != null ? boletim.getDataOcorrido() : null);
		dados.add(boletim.getPeriodoOcorrido() != null ? boletim.getPeriodoOcorrido() : null);
		dados.add(boletim.getCrime() != null ? boletim.getCrime() : null);
		

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
			
			dados.add(boletim.getLocalOcorrido().getRua() != null ? boletim.getLocalOcorrido().getRua() : null);
			dados.add(boletim.getLocalOcorrido().getBairro() != null ? boletim.getLocalOcorrido().getBairro() : null);
			dados.add(boletim.getLocalOcorrido().getCidade() != null ? boletim.getLocalOcorrido().getCidade() : null);
			dados.add(boletim.getLocalOcorrido().getEstado() != null ? boletim.getLocalOcorrido().getEstado() : null);
		}
		else
		{
			dados.add(null);
		}
		
		if (boletim.getVeiculoFurtado() != null) 
		{
			int ano = boletim.getVeiculoFurtado().getAnoFabricacao();
			
			if (ano == 0) {
				dados.add(null);
			}
			else
			{
				dados.add(String.valueOf(ano));
			}
			
			dados.add(boletim.getVeiculoFurtado().getCor() != null ? boletim.getVeiculoFurtado().getCor() : null);
			dados.add(boletim.getVeiculoFurtado().getMarca() != null ? boletim.getVeiculoFurtado().getMarca() : null);
			dados.add(boletim.getVeiculoFurtado().getTipoVeiculo() != null ? boletim.getVeiculoFurtado().getTipoVeiculo() : null);
		}
		else
		{
			dados.add(null);
		}
		
		if (boletim.getVeiculoFurtado().getEmplacamento() != null) 
		{
			dados.add(boletim.getVeiculoFurtado().getEmplacamento().getCodigo() != null ? boletim.getVeiculoFurtado().getEmplacamento().getCodigo() : null);
			dados.add(boletim.getVeiculoFurtado().getEmplacamento().getCidade() != null ? boletim.getVeiculoFurtado().getEmplacamento().getCidade() : null);
			dados.add(boletim.getVeiculoFurtado().getEmplacamento().getEstado() != null ? boletim.getVeiculoFurtado().getEmplacamento().getEstado() : null);
		}
		else
		{
			dados.add(null);
		}
		
		if (boletim.getEnvolvidos() != null) 
		{
			dados.add(boletim.getEnvolvidos().getNome() != null ? boletim.getEnvolvidos().getNome() : null);
			dados.add(boletim.getEnvolvidos().getEmail() != null ? boletim.getEnvolvidos().getEmail() : null);
			dados.add(boletim.getEnvolvidos().getTelefone() != null ? boletim.getEnvolvidos().getTelefone() : null);
		}
		else
		{
			dados.add(null);
		}

		for (String dado : dados) 
		{
			if (dado == null || dado.isEmpty() || dado == "") 
			{
				dadosNulos = true;
				break;
			}
		}
		
		return dadosNulos;
	}

	@Override
	public boolean verificarEmail(String email) {
	    boolean isEmailIdValid = false;
	    if (email != null && email.length() > 0) {
	        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	        Matcher matcher = pattern.matcher(email);
	        if (matcher.matches()) {
	            isEmailIdValid = true;
	        }
	    }
	    return isEmailIdValid;
	}

	@Override
	public boolean verificarData(String data) {
		String dateFormat = "dd/MM/uuuu";
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat).withResolverStyle(ResolverStyle.STRICT);
		try 
		{
			LocalDate date = LocalDate.parse(data, dtf);
			return true;
		} 
		catch (DateTimeParseException e) 
		{
			return false;
		}
	}

	@Override
	public boolean verificarPlaca(String placa) {
		boolean isValid = false;
	    if (placa != null && placa.length() > 0) {
	        String expression = "[A-Z]{3}[0-9]{1}[A-Z]{1}[0-9]{2}|[A-Z]{3}[0-9]{4}";
	        Pattern pattern = Pattern.compile(expression);
	        Matcher matcher = pattern.matcher(placa);
	        if (matcher.matches()) {
	            isValid = true;
	        }
	    }
	    return isValid;
	}

	@Override
	public boolean verificarTelefone(String numeroTelefone) {
		boolean isValid = false;
	    if (numeroTelefone != null && numeroTelefone.length() > 0) {
	        String expression = "^\\(\\d{2}\\)\\d{4,5}[-]\\d{4}$";
	        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	        Matcher matcher = pattern.matcher(numeroTelefone);
	        if (matcher.matches()) {
	            isValid = true;
	        }
	    }
	    return isValid;
	}

	@Override
	public boolean verificarAnoFabricacao(int anoFabricacao) {
		boolean isValid = false;
	    if (anoFabricacao > 0) {
	    	
	        String expression = "^\\d{4}$";
	        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	        Matcher matcher = pattern.matcher(String.valueOf(anoFabricacao));
	        if (matcher.matches()) {
	            isValid = true;
	        }
	    }
	    return isValid;
	}
	
	@Override
	public boolean verificarNumero(int numero) {
		boolean isValid = false;
	    if (numero > 0) {
	    	
	        String expression = "^\\d{1,4}$";
	        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	        Matcher matcher = pattern.matcher(String.valueOf(numero));
	        if (matcher.matches()) {
	            isValid = true;
	        }
	    }
	    return isValid;
	}
}