package br.com.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.factory.ConnectionFactory;
import br.com.model.Endereco;
import br.com.model.Paciente;

import br.com.model.Usuario;

public class EnderecoDAO {

	private Connection connection;

	public EnderecoDAO() {
		this.connection = new ConnectionFactory().getConection();
	}

	public void inserir(Endereco endereco) throws SQLException {
		String consulta = "INSERT INTO ENDERECO VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setString(1, null);
			ps.setString(2, endereco.getEndereco());
			ps.setString(3, endereco.getBairro());
			ps.setString(4, endereco.getCidade());
			ps.setString(5, endereco.getEstado());
			ps.setString(6, endereco.getPais());
			ps.setInt(7, endereco.getId_paciente());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Endereco consultarId(int idEndereco) throws SQLException {
		String consulta = "SELECT * FROM ENDERECO WHERE IDENDERECO = ?";
		Endereco endereco = null;
		try {
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setInt(1, idEndereco);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				endereco = new Endereco(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7));
			}
			System.out.println(endereco);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return endereco;
	}

	public void alterar(Endereco endereco) throws SQLException {
		String consulta = "UPDATE ENDERECO SET ENDERECO = ?, Bairro = ?, CIDADE = ?, ESTADO = ?, PAIS = ?, ID_PACIENTE = ? WHERE IDENDERECO = ?;";

		try {
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setString(1, endereco.getEndereco());
			ps.setString(2, endereco.getBairro());
			ps.setString(3, endereco.getCidade());
			ps.setString(4, endereco.getEstado());
			ps.setString(5, endereco.getPais());
			ps.setInt(6, endereco.getId_paciente());
			ps.setInt(7, endereco.getIdEndereco());
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
		}
		return lastId;
	}

}
