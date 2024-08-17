package com.br.utfpr.tsi.delegacia.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.br.utfpr.tsi.delegacia.web.api.model.BoletimFurto;
import com.br.utfpr.tsi.delegacia.web.api.repository.BoletimFurtoRepository;

@RestController
@RequestMapping("/boletins")
public class BoletimFurtoController {

	@Autowired
	private BoletimFurtoRepository boletimFurtoRepository;

	@GetMapping
	public List<BoletimFurto> listar() {
		return boletimFurtoRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public BoletimFurto adicionar(@RequestBody BoletimFurto boletim) {
		return boletimFurtoRepository.save(boletim);
	}
}
