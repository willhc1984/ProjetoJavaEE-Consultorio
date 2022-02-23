package br.com.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import br.com.factory.ConnectionFactory;
import br.com.model.Consulta;
import br.com.model.Paciente;

import br.com.model.Usuario;

public class PacienteDAO {

	private Connection connection;

	public PacienteDAO() {
		this.connection = new ConnectionFactory().getConection();
	}

	/*
	 * public static void inserir(Paciente paciente) throws SQLException{ // TODO
	 * Auto-generated method stub String consulta =
	 * "INSERT INTO PACIENTE VALUES(null, '" + paciente.getNome() + "', '" +
	 * paciente.getSexo() + "', '" + paciente.getEmail() + "', '" +
	 * paciente.getData() + "')"; System.out.println(consulta); Statement stmt =
	 * conexao.createStatement(); stmt.executeUpdate(consulta); conexao.commit();
	 * stmt.close(); }
	 */

	public void inserir(Paciente paciente) {
		String consulta = "INSERT INTO PACIENTE VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setString(1, null);
			ps.setString(2, paciente.getNome());
			ps.setString(3, paciente.getSexo());
			ps.setString(4, paciente.getEmail());
			ps.setString(5, paciente.getData());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Paciente> consultarTodos() throws SQLException {
		String query = "SELECT * FROM PACIENTE";
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		List<Paciente> pacientes = new LinkedList<>();
		while (rs.next()) {
			Paciente paciente = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5));
			pacientes.add(paciente);
		}
		return pacientes;
	}

	public int getLastId() throws SQLException {
		String consulta = "SELECT LAST_INSERT_ID()";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(consulta);
		int lastId = 0;
		while (rs.next()) {
			lastId = rs.getInt(1);
			System.out.println(lastId);
		}
		return lastId;
	}

	public Paciente consultarId(int idPaciente) throws SQLException {
		String consulta = "SELECT * FROM PACIENTE WHERE IDPACIENTE = ?";
		Paciente paciente = null;
		try {
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setInt(1, idPaciente);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				paciente = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			System.out.println(paciente);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return paciente;
	}
	
	public void alterar(Paciente paciente) throws SQLException {
		String consulta = "UPDATE PACIENTE SET NOME = ?, SEXO = ?, EMAIL = ?, dataNasc = ? WHERE IDPACIENTE = ?;";

		try {
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setString(1, paciente.getNome());
			ps.setString(2, paciente.getSexo());
			ps.setString(3, paciente.getEmail());
			ps.setString(4, paciente.getData());
			ps.setInt(5, paciente.getIdPaciente());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
