package com.agenda.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
		} catch (Exception e) {
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

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* READ */
	public ArrayList<JavaBeans> listContacts() {

		ArrayList<JavaBeans> contacts = new ArrayList<>();

		String read = "SELECT * FROM contatos ORDER BY nome";

		try {
			Connection conn = connect();

			PreparedStatement pst = conn.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Integer id = Integer.parseInt(rs.getString(1));
				String nome = rs.getString(2);
				String tel = rs.getString(3);
				String email = rs.getString(4);

				contacts.add(new JavaBeans(id, nome, tel, email));

			}
			
			conn.close();

			return contacts;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
