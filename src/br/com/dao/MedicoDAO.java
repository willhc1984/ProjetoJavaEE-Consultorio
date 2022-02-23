package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import br.com.factory.ConnectionFactory;
import br.com.model.Medico;
import br.com.model.Paciente;
import br.com.model.Usuario;

public class MedicoDAO {

	private Connection connection;

	public MedicoDAO() {
		this.connection = new ConnectionFactory().getConection();
	}

	public void inserir(Medico medico) throws SQLException {
		String consulta = "INSERT INTO MEDICO VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setString(1, null);
			ps.setString(2, medico.getNome());
			ps.setString(3, medico.getSexo());
			ps.setString(4, medico.getEspecialidade());
			ps.setString(5, medico.getFuncionario());
			ps.setString(6, medico.getContato());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Medico> consultarTodos() throws SQLException {
		String query = "SELECT * FROM MEDICO";
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		List<Medico> medicos = new LinkedList<>();
		while (rs.next()) {
			Medico medico = new Medico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6));
			medicos.add(medico);
		}
		return medicos;
	}

	public void alterar(Medico medico) throws SQLException {
		String consulta = "UPDATE MEDICO SET NOME = ?, SEXO = ?, ESPECIALIDADE = ?, FUNCIONARIO = ?, CONTATO = ? WHERE IDMEDICO = ?;";

		try {
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setString(1, medico.getNome());
			ps.setString(2, medico.getSexo());
			ps.setString(3, medico.getEspecialidade());
			ps.setString(4, medico.getFuncionario());
			ps.setString(5, medico.getContato());
			ps.setInt(6, medico.getIdMedico());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public Medico consultarId(int idMedico) throws SQLException {
		String consulta = "SELECT * FROM MEDICO WHERE IDMEDICO = ?";
		Medico medico = null;
		try {
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setInt(1, idMedico);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				medico = new Medico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return medico;
	}
	
	public void excluir(int idMedico) {
		String consulta = "DELETE FROM MEDICO WHERE IDMEDICO = ?;";
		try {
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setInt(1, idMedico);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
