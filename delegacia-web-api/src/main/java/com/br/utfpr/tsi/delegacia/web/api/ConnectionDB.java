package com.br.utfpr.tsi.delegacia.web.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.Data;

@Data
public class ConnectionDB {
	private Connection connection;
	
	public void Connection() throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
	    connection = DriverManager.getConnection("jdbc:h2:mem:db;DB_CLOSE_ON_EXIT=FALSE", "admin", "123");
	}
}
