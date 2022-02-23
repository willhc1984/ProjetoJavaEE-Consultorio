package br.com.model;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idUsuario;
	private String nome;
	private String login;
	private String senha;
	private String nivel_acesso;
	
	public Usuario() {
		
	};	
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	
	public Usuario(String nome, String login, String senha, String nivel_acesso) {		
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.nivel_acesso = nivel_acesso;
	};

	public Usuario(int idUsuario, String nome, String login, String senha, String nivel_acesso) {		
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.nivel_acesso = nivel_acesso;
	};

	public int getIdusuario() {
		return idUsuario;
	};

	public void setIdusuario(int idUsuario) {
		this.idUsuario = idUsuario;
	};

	public String getNome() {
		return nome;
	};

	public void setNome(String nome) {
		this.nome = nome;
	};

	public String getLogin() {
		return login;
	};

	public void setLogin(String login) {
		this.login = login;
	};
	
	public String getSenha() {
		return senha;
	};

	public void setSenha(String senha) {
		this.senha = senha;
	};

	public String getNivel_acesso() {
		return nivel_acesso;
	};
	
	public void setNivel_acesso(String nivel_acesso) {
		this.nivel_acesso = nivel_acesso;
	}

	@Override
	public String toString() {
		return "Usuario [idusuario=" + idUsuario + ", nome=" + nome + ", login=" + login + ", senha=" + senha
				+ ", nivel_acesso=" + nivel_acesso + "]";
	};	
		

}
