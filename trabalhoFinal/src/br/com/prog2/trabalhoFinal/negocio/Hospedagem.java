package br.com.prog2.trabalhoFinal.negocio;

import java.time.LocalDate;

public class Hospedagem {

	private String codHospedagem;
	private String codChale;
	private String estado;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Integer qtdPessoas;
	private Double desconto;
	private Double valorFinal;

	public String getCodHospedagem() {
		return codHospedagem;
	}

	public void setCodHospedagem(String codHospedagem) {
		this.codHospedagem = codHospedagem;
	}

	public String getCodChale() {
		return codChale;
	}

	public void setCodChale(String codChale) {
		this.codChale = codChale;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate localDate) {
		this.dataInicio = localDate;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate localDate) {
		this.dataFim = localDate;
	}

	public Integer getQtdPessoas() {
		return qtdPessoas;
	}

	public void setQtdPessoas(Integer qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}
}
