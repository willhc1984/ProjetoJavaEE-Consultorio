package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import br.com.factory.ConnectionFactory;
import br.com.model.Hospital;
import br.com.model.Medico;

public class HospitalDAO {

	private Connection connection;

	public HospitalDAO() {
		this.connection = new ConnectionFactory().getConection();
	}

	public void inserir(Hospital hospital) throws SQLException {
		String consulta = "INSERT INTO HOSPITAL VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setString(1, null);
			ps.setString(2, hospital.getNome());
			ps.setString(3, hospital.getEndereco());
			ps.setString(4, hospital.getBairro());
			ps.setString(5, hospital.getCidade());
			ps.setString(6, hospital.getEstado());
			ps.setString(7, hospital.getPais());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Hospital> consultarTodos() throws SQLException {
		String query = "SELECT * FROM HOSPITAL";
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		List<Hospital> hospitais = new LinkedList<>();
		while (rs.next()) {
			Hospital hospital = new Hospital(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
			hospitais.add(hospital);
		}
		return hospitais;
	}
	
	public void alterar(Hospital hospital) throws SQLException {
		String consulta = "UPDATE HOSPITAL SET NOME = ?, ENDERECO = ?, BAIRRO = ?, CIDADE = ?, ESTADO = ?, PAIS = ? WHERE IDHOSPITAL = ?;";

		try {
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setString(1, hospital.getNome());
			ps.setString(2, hospital.getEndereco());
			ps.setString(3, hospital.getBairro());
			ps.setString(4, hospital.getCidade());
			ps.setString(5, hospital.getEstado());
			ps.setString(6, hospital.getPais());
			ps.setInt(7, hospital.getIdHospital());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Hospital consultarId(int idHospital) throws SQLException {
		String consulta = "SELECT * FROM HOSPITAL WHERE IDHOSPITAL = ?";
		Hospital hospital = null;
		try {
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setInt(1, idHospital);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				hospital = new Hospital(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return hospital;
	}
	
	public void excluir(int idHospital) {
		String consulta = "DELETE FROM HOSPITAL WHERE IDHOSPITAL = ?;";
		try {
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setInt(1, idHospital);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
