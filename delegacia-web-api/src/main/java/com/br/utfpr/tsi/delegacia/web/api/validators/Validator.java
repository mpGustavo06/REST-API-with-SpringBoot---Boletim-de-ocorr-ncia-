package com.br.utfpr.tsi.delegacia.web.api.validators;

import java.io.IOException;

import com.br.utfpr.tsi.delegacia.web.api.model.BoletimFurto;

public interface Validator 
{
	String verificadorIdentificador() throws IOException;
	
	public boolean verificarDadosObrigatorios(BoletimFurto boletim);
	
	public boolean verificarEmail(String email);
	
	public boolean verificarData(String data);
	
	public boolean verificarPlaca(String placa);
	
	public boolean verificarTelefone(String numeroTelefone);

	public boolean verificarAnoFabricacao(int anoFabricacao);
	
	public boolean verificarNumero(int numero);
}
