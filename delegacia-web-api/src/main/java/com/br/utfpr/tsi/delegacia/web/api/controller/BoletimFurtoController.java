package com.br.utfpr.tsi.delegacia.web.api.controller;

import java.util.List;
import com.br.utfpr.tsi.delegacia.web.api.model.BoletimFurto;

public interface BoletimFurtoController 
{
	void cadastrarBoletim(BoletimFurto boletim) throws Exception;
	
	void alterarBoletim(BoletimFurto boletim);

	void removerBoletim(String identificador);
	
	List<BoletimFurto> listarBoletins() throws Exception;
	
	BoletimFurto procurarPorIdentificador(String identificador) throws Exception;
	
	List<BoletimFurto> procurarPorCidade(String cidade) throws Exception;
	
	List<BoletimFurto> procurarPorPeriodo(String periodo) throws Exception;
}
