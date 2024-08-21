package com.br.utfpr.tsi.delegacia.web.api.controller;

import java.util.List;
import java.util.Optional;

import com.br.utfpr.tsi.delegacia.web.api.model.BoletimFurto;
import com.br.utfpr.tsi.delegacia.web.api.model.Placa;
import com.br.utfpr.tsi.delegacia.web.api.model.Veiculo;

public interface BoletimFurtoController {
	void cadastrarBoletim(BoletimFurto boletim);
	
	void alterarBoletim(BoletimFurto boletim);

	void removerBoletim(String identificador);
	
	List<BoletimFurto> listarBoletins();
	
	Optional<BoletimFurto> procurarPorIdentificador(String identificador);
	
	List<BoletimFurto> procurarPorCidade(String cidade);
	
	List<BoletimFurto> procurarPorPeriodo(String periodo);
	
	List<Veiculo> listarVeiculos();
	
	Optional<Veiculo> procurarPorPlaca(Placa placaCodigo);
	
	List<Veiculo> procurarPorCor(String cor);
	
	List<Veiculo> procurarPorTipo(String tipo);
}
