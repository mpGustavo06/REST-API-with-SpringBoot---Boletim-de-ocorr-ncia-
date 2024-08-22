package com.br.utfpr.tsi.delegacia.web.api.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.br.utfpr.tsi.delegacia.web.api.ConnectionDB;
import com.br.utfpr.tsi.delegacia.web.api.controller.BoletimFurtoControllerImplementation;
import com.br.utfpr.tsi.delegacia.web.api.model.BoletimFurto;
import com.br.utfpr.tsi.delegacia.web.api.model.Placa;
import com.br.utfpr.tsi.delegacia.web.api.model.Veiculo;

public class RepositoryImplementation {	 
	
	@Autowired
	private ConnectionDB connection;
	
	@Autowired
	BoletimFurtoRepository repository;
	
	private BoletimFurtoControllerImplementation conImpl;
	
	public List<BoletimFurto> findBoletimByPeriodo(String periodo) throws SQLException {
		String query = "SELECT * FROM BOLETIM_FURTO WHERE PERIODO_OCORRIDO=?";
		List<BoletimFurto> boletins = new ArrayList<>();
		
	    PreparedStatement statementCon = connection.getConnection().prepareStatement(query);
	    statementCon.setString(1, periodo);
	    ResultSet rs = statementCon.executeQuery();

	    while (rs.next())
	    {
	    	boletins.add(boletimSearch(rs).get());
	    }
	    
		return boletins;
	}
	
	public List<BoletimFurto> findBoletimByCidade(String cidade) throws SQLException {
		String query = "SELECT * FROM BOLETIM_FURTO WHERE CIDADE=?";
		List<BoletimFurto> boletins = new ArrayList<>();
		
	    PreparedStatement statementCon = connection.getConnection().prepareStatement(query);
	    statementCon.setString(1, cidade);
	    ResultSet rs = statementCon.executeQuery();

	    while (rs.next())
	    {
	    	boletins.add(boletimSearch(rs).get());
	    }
	    
		return boletins;
	}
	
	public List<Veiculo> findVeiculoByCor(String cor) throws SQLException {
		String query = "SELECT * FROM VEICULO WHERE COR=?";
		List<Veiculo> veics = new ArrayList<>();
		
	    PreparedStatement statementCon = connection.getConnection().prepareStatement(query);
	    statementCon.setString(1, cor);
	    ResultSet rs = statementCon.executeQuery();

	    while (rs.next())
	    {
	    	veics.add(veiculoSearch(rs).get());
	    }
	    
		return veics;
	}
	
	public List<Veiculo> findVeiculoByTipo(String tipo) throws SQLException {
		String query = "SELECT * FROM VEICULO WHERE TIPO=?";
		List<Veiculo> veics = new ArrayList<>();
		
	    PreparedStatement statementCon = connection.getConnection().prepareStatement(query);
	    statementCon.setString(1, tipo);
	    ResultSet rs = statementCon.executeQuery();

	    while (rs.next())
	    {
	    	veics.add(veiculoSearch(rs).get());
	    }
	    
		return veics;
	}
	
	public Optional<Veiculo> findVeiculoByPlaca(String placaCodigo) throws SQLException {
	    String query = "SELECT * FROM VEICULO WHERE PLACA=?";
	    
	    PreparedStatement statementCon = connection.getConnection().prepareStatement(query);
	    statementCon.setString(1, placaCodigo);
	    ResultSet rs = statementCon.executeQuery();
	    
		return veiculoSearch(rs);
	}
	
	public Optional<Veiculo> veiculoSearch(ResultSet rs) throws SQLException{
		Optional<Veiculo> a = conImpl.procurarPorId(rs.getInt("ID"));
	    
	    Veiculo veic = new Veiculo();
	    veic.setId(rs.getInt("ID"));
	    veic.setAnoFabricacao(rs.getInt("ANO"));
	    veic.setCor(rs.getString("COR"));
	    veic.setMarca(rs.getString("MARCA"));
	    veic.setTipoVeiculo(rs.getString("TIPO"));
	    veic.setEmplacamento(a.get().getEmplacamento());
	    veic.setEnvolvidoEm(null);
		
		return Optional.of(veic);
	}
	
	public Optional<BoletimFurto> boletimSearch(ResultSet rs) throws SQLException{
		Optional<BoletimFurto> a = conImpl.procurarPorIdentificador(rs.getString("IDENTIFICADOR"));
	    
	    BoletimFurto boletim = new BoletimFurto();
	    boletim.setIdentificador(rs.getString("IDENTIFICADOR"));
	    boletim.setDataOcorrido(a.get().getDataOcorrido());
	    boletim.setVeiculoFurtado(a.get().getVeiculoFurtado());
	    boletim.setCrime(rs.getString("CRIME"));
	    boletim.setLocalOcorrido(a.get().getLocalOcorrido());
	    boletim.setPeriodoOcorrido(rs.getString("PERIODO_OCORRIDO"));
	    boletim.setEnvolvidos(null);
		
		return Optional.of(boletim);
	}
 }
