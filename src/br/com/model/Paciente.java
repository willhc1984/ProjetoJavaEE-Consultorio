package br.com.model;

import java.io.Serializable;

public class Paciente implements Serializable{
	
	private int idPaciente;
	private String nome;
	private String sexo;
	private String email;
	private String data;
	
	public Paciente() {
		
	}

	public Paciente(String nome, String sexo, String email, String data) {
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
		this.data = data;
	}

	public Paciente(int idPaciente, String nome, String sexo, String email, String data) {
		this.idPaciente = idPaciente;
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
		this.data = data;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Paciente [idPaciente=" + idPaciente + ", nome=" + nome + ", sexo=" + sexo + ", email=" + email
				+ ", data=" + data + "]";
	}

}
