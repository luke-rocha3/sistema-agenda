package com.agendaonline.sistema_agenda.model.repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static final String URL = "jdbc:mysql://localhost:3306/agenda_online";
	private static final String USER = "root";
	// Abaixo colocar a senha do banco de dados.
	private static final String PASSWORD = "24104425";

	private static Connection conn = null;

	static Connection getCurrentConnection() throws SQLException {

		if (conn == null)
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			

		return conn;

	}

	static Connection getNewConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

}
