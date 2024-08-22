package com.br.utfpr.tsi.delegacia.web.api.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.br.utfpr.tsi.delegacia.web.api.model.BoletimFurto;
import com.br.utfpr.tsi.delegacia.web.api.model.Placa;
import com.br.utfpr.tsi.delegacia.web.api.model.Veiculo;

public interface BoletimFurtoController {
	void cadastrarBoletim(BoletimFurto boletim);
	
	BoletimFurto alterarBoletim(String identificador, BoletimFurto boletim);

	void removerBoletim(String identificador);
	
	List<BoletimFurto> listarBoletins();
	
	Optional<BoletimFurto> procurarPorIdentificador(String identificador);
	
	List<BoletimFurto> procurarPorCidade(String cidade) throws SQLException;
	
	List<BoletimFurto> procurarPorPeriodo(String periodo) throws SQLException;
	
	List<Veiculo> listarVeiculos();
	
	Optional<Veiculo> procurarPorPlaca(Placa placaCodigo) throws SQLException;
	
	List<Veiculo> procurarPorCor(String cor) throws SQLException;
	
	List<Veiculo> procurarPorTipo(String tipo) throws SQLException;
}
