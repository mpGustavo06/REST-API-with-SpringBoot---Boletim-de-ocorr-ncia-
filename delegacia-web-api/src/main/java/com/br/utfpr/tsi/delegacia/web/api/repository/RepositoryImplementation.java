package com.br.utfpr.tsi.delegacia.web.api.repository;

import java.util.List;
import java.util.Optional;
import com.br.utfpr.tsi.delegacia.web.api.model.BoletimFurto;
import com.br.utfpr.tsi.delegacia.web.api.model.Placa;
import com.br.utfpr.tsi.delegacia.web.api.model.Veiculo;

public class RepositoryImplementation {
	public void alterarBoletim(BoletimFurto boletim) {
		
	}
	
	public List<BoletimFurto> findBoletimByPeriodo(String periodo) {
		return null;
	}
	
	public List<BoletimFurto> findBoletimByCidade(String periodo) {
		return null;
	}
	
	public List<Veiculo> findVeiculoByCor(String cor) {
		return null;
	}
	
	public List<Veiculo> findVeiculoByTipo(String tipo) {
		return null;
	}
	
	public Optional<Veiculo> findVeiculoByPlaca(Placa placa) {
		return null;
	}
}
