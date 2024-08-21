package com.br.utfpr.tsi.delegacia.web.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.br.utfpr.tsi.delegacia.web.api.model.Placa;
import com.br.utfpr.tsi.delegacia.web.api.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer>{}