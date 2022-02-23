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
import br.com.model.Medico;
import br.com.model.Paciente;

import br.com.model.Usuario;

public class ConsultaDAO {

	private Connection connection;

	public ConsultaDAO() {
		this.connection = new ConnectionFactory().getConection();
	}

	public void inserir(Consulta consulta) {
		String query = "INSERT INTO CONSULTA VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, null);
			ps.setInt(2, consulta.getIdPaciente());
			ps.setInt(3, consulta.getIdMedico());
			ps.setInt(4, consulta.getIdHospital());
			ps.setString(5, consulta.getData());
			ps.setString(6, consulta.getDiagnostico());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Consulta> consultarTodos() throws SQLException {
		String query = "SELECT * FROM CONSULTA";
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		List<Consulta> consultas = new LinkedList<>();
		while (rs.next()) {
			Consulta consulta = new Consulta(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
					rs.getString(6));
			consultas.add(consulta);
			System.out.println(consultas);
		}
		return consultas;
	}

	public Consulta consultarId(int idConsulta) throws SQLException {
		String query = "SELECT * FROM CONSULTA WHERE IDCONSULTA = ?";
		Consulta consulta = null;
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, idConsulta);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				consulta = new Consulta(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getString(6));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return consulta;
	}

	public void alterar(Consulta consulta) throws SQLException {
		String query = "UPDATE CONSULTA SET ID_PACIENTE = ?, ID_MEDICO = ?, ID_HOSPITAL = ?, DATA = ?, DIAGNOSTICO = ? WHERE IDCONSULTA = ?;";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, consulta.getIdPaciente());
			ps.setInt(2, consulta.getIdMedico());
			ps.setInt(3, consulta.getIdHospital());
			ps.setString(4, consulta.getData());
			ps.setString(5, consulta.getDiagnostico());
			ps.setInt(6, consulta.getIdConsulta());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void excluir(int idConsulta) {
		String consulta = "DELETE FROM CONSULTA WHERE IDCONSULTA = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setInt(1, idConsulta);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
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
}
