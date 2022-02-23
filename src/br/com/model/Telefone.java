package br.com.model;

import java.io.Serializable;

public class Telefone implements Serializable{
	
	private int idTelefone;
	private String numero;
	private String tipo;
	private int id_paciente;
	
	public Telefone() {
		
	}
	
	public Telefone(int idTelefone, String numero, String tipo, int id_paciente) {
		this.idTelefone = idTelefone;
		this.numero = numero;
		this.tipo = tipo;
		this.id_paciente = id_paciente;
	}

	public Telefone(String numero, String tipo, int id_paciente) {
		this.numero = numero;
		this.tipo = tipo;
		this.id_paciente = id_paciente;
	}

	public int getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(int idTelefone) {
		this.idTelefone = idTelefone;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(int id_paciente) {
		this.id_paciente = id_paciente;
	}

	@Override
	public String toString() {
		return "Telefone [idTelefone=" + idTelefone + ", numero=" + numero + ", tipo=" + tipo + ", id_paciente="
				+ id_paciente + "]";
	}

}
