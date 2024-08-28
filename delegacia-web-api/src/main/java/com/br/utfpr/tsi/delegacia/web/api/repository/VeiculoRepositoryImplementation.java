package com.br.utfpr.tsi.delegacia.web.api.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.br.utfpr.tsi.delegacia.web.api.controller.CSVLeitor;
import com.br.utfpr.tsi.delegacia.web.api.model.BoletimFurto;
import com.br.utfpr.tsi.delegacia.web.api.model.Veiculo;
import jakarta.annotation.PostConstruct;

@Component
public class VeiculoRepositoryImplementation implements VeiculoRepository 
{
	@Autowired
	private CSVLeitor leitor;
	private Map<String, Veiculo> veiculos = new HashMap<>();

	@PostConstruct
	public void init() {
		List<BoletimFurto> boletins = new ArrayList<>(this.leitor.lerCSV().values());

		for (BoletimFurto boletim : boletins) 
		{
			this.veiculos.put(boletim.getVeiculoFurtado().getEmplacamento().getCodigo(), 
							  boletim.getVeiculoFurtado());
		}
	}
	
	@Override
	public void cadastrarVeiculo(Veiculo veiculo) {
		this.veiculos.put(veiculo.getEmplacamento().getCodigo(), veiculo);
	}

	@Override
	public List<Veiculo> listarVeiculos() {
		return new ArrayList<Veiculo>(this.veiculos.values());
	}

	@Override
	public Veiculo procurarPorPlaca(String placaCodigo) {
		return this.veiculos.get(placaCodigo);
	}

	@Override
	public List<Veiculo> procurarPorCor(String cor) {
		List<Veiculo> veics = new ArrayList<>();
		
		for (Veiculo veic : this.veiculos.values()) 
		{
			if (veic.getCor().equalsIgnoreCase(cor)) 
			{
				veics.add(veic);
			}
		}
		
		return veics;
	}

	@Override
	public List<Veiculo> procurarPorTipo(String tipo) {
		List<Veiculo> veics = new ArrayList<>();
		
		for (Veiculo veic : this.veiculos.values()) 
		{
			if (veic.getTipoVeiculo().equalsIgnoreCase(tipo)) 
			{
				veics.add(veic);
			}
		}
		
		return veics;
	}

	@Override
	public void removerVeiculo(String placa) {
		this.veiculos.remove(placa);
	}

	@Override
	public boolean alterarVeiculo(Veiculo veiculo) {
		boolean aux = false;
		for (Veiculo veic : veiculos.values()) 
		{
			if (veic.getEmplacamento().getCodigo().equals(veiculo.getEmplacamento().getCodigo())) 
			{
				this.removerVeiculo(veic.getEmplacamento().getCodigo());
				this.cadastrarVeiculo(veiculo);
				aux = true;
			}
		}
		return aux;
	}
}
