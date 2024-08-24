package com.br.utfpr.tsi.delegacia.web.api.controller;

import java.util.List;
import com.br.utfpr.tsi.delegacia.web.api.model.BoletimFurto;

public interface BoletimFurtoController 
{
	void cadastrarBoletim(BoletimFurto boletim);
	
	void alterarBoletim(BoletimFurto boletim);

	void removerBoletim(String identificador);
	
	List<BoletimFurto> listarBoletins();
	
	BoletimFurto procurarPorIdentificador(String identificador);
	
	List<BoletimFurto> procurarPorCidade(String cidade);
	
	List<BoletimFurto> procurarPorPeriodo(String periodo);
}
