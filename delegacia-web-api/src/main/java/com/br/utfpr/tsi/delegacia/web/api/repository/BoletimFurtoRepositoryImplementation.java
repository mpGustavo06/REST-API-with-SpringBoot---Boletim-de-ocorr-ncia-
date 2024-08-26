package com.br.utfpr.tsi.delegacia.web.api.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.utfpr.tsi.delegacia.web.api.controller.CSVLeitor;
import com.br.utfpr.tsi.delegacia.web.api.model.BoletimFurto;
import jakarta.annotation.PostConstruct;

@Component
public class BoletimFurtoRepositoryImplementation implements BoletimFurtoRepository 
{
	@Autowired
	CSVLeitor leitor;
	Map<String, BoletimFurto> memory = new HashMap<>();

	@PostConstruct
	public void init() {
		this.memory = leitor.lerCSV();
	}
	
	@Override
	public void cadastrarBoletim(BoletimFurto boletim) {
		this.memory.put(boletim.getIdentificador(), boletim);
	}

	@Override
	public void alterarBoletim(BoletimFurto boletim) throws IOException {
		for (BoletimFurto bof : memory.values()) 
		{
			if (bof.getIdentificador().equalsIgnoreCase(boletim.getIdentificador())) 
			{
				removerBoletim(bof.getIdentificador());
				cadastrarBoletim(boletim);
			}
		}
	}

	@Override
	public void removerBoletim(String identificador) throws IOException {
		try 
		{
			this.memory.remove(identificador);
		} 
		catch (Exception e) 
		{
			throw new IOException("Não foi possível remover o registro!");
		} 
	}

	@Override
	public List<BoletimFurto> listarBoletins() {
		return new ArrayList<BoletimFurto>(this.memory.values());
	}

	@Override
	public BoletimFurto procurarPorIdentificador(String identificador) {
		return this.memory.get(identificador);
	}

	@Override
	public List<BoletimFurto> procurarPorCidade(String cidade) {
		List<BoletimFurto> boletins = new ArrayList<>();
		
		for (BoletimFurto bof : memory.values()) 
		{
			if (bof.getLocalOcorrido().getCidade().equalsIgnoreCase(cidade)) 
			{
				boletins.add(bof);
			}
		}
		
		return boletins;
	}

	@Override
	public List<BoletimFurto> procurarPorPeriodo(String periodo) {
		List<BoletimFurto> boletins = new ArrayList<>();
		
		for (BoletimFurto bof : memory.values()) 
		{
			if (bof.getPeriodoOcorrido().equalsIgnoreCase(periodo)) 
			{
				boletins.add(bof);
			}
		}
		
		return boletins;
	}
}
