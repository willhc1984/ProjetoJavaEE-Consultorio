package br.com.model;

import java.io.Serializable;

public class Endereco implements Serializable{
	
	private int idEndereco;
	private String endereco;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;
	private int id_paciente;
	
	public Endereco(int idEndereco, String endereco, String bairro, String cidade, String estado, String pais,
			int id_paciente) {
		this.idEndereco = idEndereco;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.id_paciente = id_paciente;
	}

	public Endereco(String endereco, String bairro, String cidade, String estado, String pais, int id_paciente) {
		super();
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.id_paciente = id_paciente;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(int id_paciente) {
		this.id_paciente = id_paciente;
	}

	@Override
	public String toString() {
		return "Endereco [idEndereco=" + idEndereco + ", endereco=" + endereco + ", bairro=" + bairro + ", cidade="
				+ cidade + ", estado=" + estado + ", pais=" + pais + ", id_paciente=" + id_paciente + "]";
	}
	
}
