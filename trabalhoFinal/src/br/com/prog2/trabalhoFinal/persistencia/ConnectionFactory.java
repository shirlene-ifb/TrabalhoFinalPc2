package br.com.prog2.trabalhoFinal.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() {
		String driver = "org.postgresql.Driver";
		String user = "postgres";/* Coloque o usuário criado para acesso ao banco */
		String senha = "3115";/* Coloque a senha para acesso ao banco */
		String url = "jdbc:postgresql://localhost:5433/trabalhofinalpc2";/*
																			 * servidor onde está instalado o banco
																			 */
		Connection con = null;
		try {
			Class.forName(driver);
			con = (Connection) DriverManager.getConnection(url, user, senha);
		} catch (ClassNotFoundException ex) { // caso o driver JDBC não foi instalado
			System.err.print(ex.getMessage());
		} catch (SQLException e) { // caso haja problemas para se conectar ao banco de dados
			System.err.print(e.getMessage());
		}
		return con;
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
		}
	}
}
