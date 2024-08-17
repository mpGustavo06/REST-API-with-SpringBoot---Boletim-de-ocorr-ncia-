package com.br.utfpr.tsi.delegacia.web.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.br.utfpr.tsi.delegacia.web.api.model.BoletimFurto;

@Repository
public interface BoletimFurtoRepository extends JpaRepository<BoletimFurto, String> {

}
