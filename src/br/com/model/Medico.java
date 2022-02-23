package br.com.model;

import java.io.Serializable;

public class Medico implements Serializable{
	
	private int idMedico;
	private String nome;
	private String sexo;
	private String especialidade;
	private String funcionario;
	private String contato;
	
	public Medico() {
		
	}

	public Medico(String nome, String sexo, String especialidade, String funcionario, String contato) {
		this.nome = nome;
		this.sexo = sexo;
		this.especialidade = especialidade;
		this.funcionario = funcionario;
		this.contato = contato;
	}

	public Medico(int idMedico, String nome, String sexo, String especialidade, String funcionario, String contato) {
		this.idMedico = idMedico;
		this.nome = nome;
		this.sexo = sexo;
		this.especialidade = especialidade;
		this.funcionario = funcionario;
		this.contato = contato;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
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

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	@Override
	public String toString() {
		return "Medico [idMedico=" + idMedico + ", nome=" + nome + ", sexo=" + sexo + ", especialidade=" + especialidade
				+ ", funcionario=" + funcionario + ", contato=" + contato + "]";
	}
	

}
