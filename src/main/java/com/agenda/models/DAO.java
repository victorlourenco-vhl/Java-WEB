package com.agenda.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {

	private final String url = "jdbc:postgresql://localhost:5432/agenda";
	private final String user = "postgres";
	private final String password = "admin";

	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the PostgreSQL server successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}
	
	public void testConnection() {
		try {
			Connection conn = connect();
			System.out.println(conn);
			conn.close();
		} catch(Exception e ) {
			e.printStackTrace();
		}
	}
	
	/* CREATE */
	public void newContact(JavaBeans contact) {
		String create = "INSERT INTO contatos(nome, telefone, email) VALUES(?, ?, ?)";
		
		try {
			Connection conn = connect();
			
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = conn.prepareStatement(create);
			
			// Substitui os parâmetros na query
			pst.setString(1, contact.getNome());
			pst.setString(2, contact.getTelefone());
			pst.setString(3, contact.getEmail());
			
			// Executa a query
			pst.executeUpdate();
			
			conn.close();
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
}
