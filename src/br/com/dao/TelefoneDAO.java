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
import br.com.model.Telefone;
import br.com.model.Usuario;

public class TelefoneDAO {

	private Connection connection;

	public TelefoneDAO() {
		this.connection = new ConnectionFactory().getConection();
	}

	public void inserir(Telefone telefone) throws SQLException {
		// TODO Auto-generated method stub
		String consulta = "INSERT INTO TELEFONE VALUES(?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setString(1, null);
			ps.setString(2, telefone.getNumero());
			ps.setString(3, telefone.getTipo());
			ps.setInt(4, telefone.getId_paciente());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Telefone consultarId(int idTelefone) throws SQLException {
		String consulta = "SELECT * FROM TELEFONE WHERE IDTELEFONE = ?";
		Telefone telefone = null;
		try {
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setInt(1, idTelefone);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				telefone = new Telefone(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}			

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return telefone;
	}

	public void alterar(Telefone telefone) throws SQLException {
		String consulta = "UPDATE TELEFONE SET NUMERO = ?, TIPO = ?, ID_PACIENTE = ? WHERE IDTELEFONE = ?;";

		try {
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setString(1, telefone.getNumero());
			ps.setString(2, telefone.getTipo());
			ps.setInt(3, telefone.getId_paciente());
			ps.setInt(4, telefone.getIdTelefone());
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
