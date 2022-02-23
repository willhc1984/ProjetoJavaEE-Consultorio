package br.com.model;

import java.io.Serializable;

public class Consulta implements Serializable{
	
	private int idConsulta;
	private int idPaciente;
	private int idMedico;
	private int idHospital;
	private String data;
	private String diagnostico;
	
	public Consulta() {
		
	}

	public Consulta(int idConsulta, int idPaciente, int idMedico, int idHospital, String data, String diagnostico) {
		this.idConsulta = idConsulta;
		this.idPaciente = idPaciente;
		this.idMedico = idMedico;
		this.idHospital = idHospital;
		this.data = data;
		this.diagnostico = diagnostico;
	}

	public Consulta(int idPaciente, int idMedico, int idHospital, String data, String diagnostico) {
		this.idPaciente = idPaciente;
		this.idMedico = idMedico;
		this.idHospital = idHospital;
		this.data = data;
		this.diagnostico = diagnostico;
	}

	public int getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public int getIdHospital() {
		return idHospital;
	}

	public void setIdHospital(int idHospital) {
		this.idHospital = idHospital;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	@Override
	public String toString() {
		return "Consulta [idConsulta=" + idConsulta + ", idPaciente=" + idPaciente + ", idMedico=" + idMedico
				+ ", idHospital=" + idHospital + ", data=" + data + ", diagnostico=" + diagnostico + "]";
	}	

}