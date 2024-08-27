package com.br.utfpr.tsi.delegacia.web.api.validators;

import com.br.utfpr.tsi.delegacia.web.api.model.BoletimFurto;

public interface Validator 
{
	String verificadorIdentificador();
	
	public boolean verificarDadosObrigatorios(BoletimFurto boletim);
	
	public boolean verificarEmail(String email);
	
	public boolean verificarData(String data);
	
	public boolean verificarPlaca(String placa);
	
	public boolean verificarTelefone(String numeroTelefone);
	
	public boolean verificarNumero(String numero);
	
	public boolean verificarAnoFabricacao(int anoFabricacao);
}
