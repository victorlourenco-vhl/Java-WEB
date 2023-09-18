package com.agenda.models;

import java.sql.Connection;
import java.sql.DriverManager;

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
}
