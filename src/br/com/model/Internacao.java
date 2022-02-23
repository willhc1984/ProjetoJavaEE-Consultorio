package br.com.model;

public class Internacao {
	
	private int idInternacao;
	private int idConsulta;
	private int quarto;
	private String dataEntrada;
	private String dataSaida;
	private String obs;
	
	public Internacao() {
		
	}
	
	public Internacao(int idInternacao, String dataEntrada, int quarto, String dataSaida, String obs, int idConsulta) {
		this.idInternacao = idInternacao;
		this.idConsulta = idConsulta;
		this.quarto = quarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.obs = obs;
	}

	public Internacao(int idConsulta, int quarto, String dataEntrada, String dataSaida, String obs) {
		this.idConsulta = idConsulta;
		this.quarto = quarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.obs = obs;
	}

	public int getIdInternacao() {
		return idInternacao;
	}

	public void setIdInternacao(int idInternacao) {
		this.idInternacao = idInternacao;
	}

	public int getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	public int getQuarto() {
		return quarto;
	}

	public void setQuarto(int quarto) {
		this.quarto = quarto;
	}

	public String getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	@Override
	public String toString() {
		return "Internacao [idInternacao=" + idInternacao + ", idConsulta=" + idConsulta + ", quarto=" + quarto
				+ ", dataEntrada=" + dataEntrada + ", dataSaida=" + dataSaida + ", obs=" + obs + "]";
	}

}
