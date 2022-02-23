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
import br.com.model.Internacao;
import br.com.model.Paciente;

import br.com.model.Usuario;

public class InternacaoDAO {

	private Connection connection;

	public InternacaoDAO() {
		this.connection = new ConnectionFactory().getConection();
	}

	public void inserir(Internacao internacao) {
		String query = "INSERT INTO INTERNACAO VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, null);
			ps.setString(2, internacao.getDataEntrada());
			ps.setInt(3, internacao.getQuarto());
			ps.setString(4, internacao.getDataSaida());
			ps.setString(5, internacao.getObs());
			ps.setInt(6, internacao.getIdConsulta());
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

	public void alterar(Internacao internacao) throws SQLException {
		String query = "UPDATE INTERNACAO SET ENTRADA = ?, QUARTO = ?, SAIDA = ?, OBSERVACOES = ?, ID_CONSULTA = ? WHERE IDINTERNACAO = ?;";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, internacao.getDataEntrada());
			ps.setInt(2, internacao.getQuarto());
			ps.setString(3, internacao.getDataSaida());
			ps.setString(4, internacao.getObs());
			ps.setInt(5, internacao.getIdConsulta());
			ps.setInt(6, internacao.getIdInternacao());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void excluir(int idInternacao) {
		String consulta = "DELETE FROM INTERNACAO WHERE IDINTERNACAO = ?;";
		try {
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setInt(1, idInternacao);
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
