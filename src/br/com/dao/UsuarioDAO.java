package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.factory.ConnectionFactory;
import br.com.model.Usuario;

public class UsuarioDAO {

	private Connection connection;

	public UsuarioDAO() {
		this.connection = new ConnectionFactory().getConection();
	}

	public void inserir(Usuario usuario) throws SQLException {
		String consulta = "INSERT INTO USUARIO VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setString(1, null);
			ps.setString(2, usuario.getNome());
			ps.setString(3, usuario.getLogin());
			ps.setString(4, usuario.getSenha());
			ps.setString(5, usuario.getNivel_acesso());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Usuario consultarId(int idUsuario) throws SQLException {
		String consulta = "SELECT * FROM USUARIO WHERE IDUSUARIO = ?";
		Usuario usuario = null;
		try {
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setInt(1, idUsuario);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			System.out.println(usuario);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return usuario;
	}

	public void excluir(int idUsuario) {
		String consulta = "DELETE FROM USUARIO WHERE IDUSUARIO = ?;";
		try {
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setInt(1, idUsuario);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void alterar(Usuario usuario) throws SQLException {
		String consulta = "UPDATE USUARIO SET NOME = ?, LOGIN = ?, SENHA = ?, NIVEL_ACESSO = ? WHERE IDUSUARIO = ?;";

		try {
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setInt(5, usuario.getIdusuario());
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			ps.setString(4, usuario.getNivel_acesso());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public Usuario consultar(String login, String senha) throws SQLException {
		String consulta = "SELECT IDUSUARIO, NOME, LOGIN, SENHA, NIVEL_ACESSO FROM USUARIO WHERE login = ? and senha = ?";
		Usuario usuario = null;
		try {
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setString(1, login);
			ps.setString(2, senha);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			System.out.println(usuario);
			ps.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return usuario;
	}

}
