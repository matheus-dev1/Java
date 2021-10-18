package br.com.alura.tdd.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Funcionario {

	private String nome;
	private LocalDate dataAdmissao;
	private BigDecimal salario;
	private Desempenho desempenho;

	public Funcionario(String nome, LocalDate dataAdmissao, BigDecimal salario, Desempenho desempenho) {
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
		this.desempenho = desempenho;
	}
	
	public Funcionario(String nome, LocalDate dataAdmissao, BigDecimal salario) {
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Desempenho getDesempenho() {
		return desempenho;
	}
	public void setDesempenho(Desempenho desempenho) {
		this.desempenho = desempenho;
	}

	public void setReajusteSalario(BigDecimal reajuste) {
		this.salario = this.salario.add(reajuste);
		arredondarSalario();
	}

	// Obs: Os metodo com o modificador "private" são utilitarios, ou seja, ele serão chamados por outros metodo public, então
	// para eles serem testados nos vamo na realidade testar o metodo que chama ele.
	private void arredondarSalario() {
		this.salario = this.salario.setScale(2, RoundingMode.HALF_UP);
	}
}
