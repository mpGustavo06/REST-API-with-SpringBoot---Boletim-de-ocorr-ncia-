package com.br.utfpr.tsi.delegacia.web.api.validators;

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
		boolean dadosNulos = false; //false = validos | true = invalidos

		List<String> dados = new ArrayList<>();
		
		dados.add(boletim.getDataOcorrido());
		dados.add(boletim.getPeriodoOcorrido());
		dados.add(boletim.getCrime());

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
			if (dado == null) 
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
	        String expression = "[A-Z]{3}[0-9]{4}";
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
}