package br.com.alura.io.teste;

import java.io.Serializable;

// Interface de Marcacao - Interface vazia apenas para marcar que uma classe eh aquilo.
public class Cliente extends Object implements Serializable {
	// serialVersionID, eh o Indentificador do meu objeto.
	// Ele serve para quando eu tentar fazer uma serializacao ou desserializacao, saber em qual
	// versao do meu id este objeto esta.
	
	// Se eu nao definir um valor para o serialVersionUID, ele vai gerar um automaticamente.
	
	// Qualquer alteracao que faca na classe que torne a desserializacao incompativel, eu tenho que
	// criar um serialVersionUID com uma nova versao.
	
	// Quando o objeto eh serializado(gravado em disco) o seu serialVersionUID eh gravado junto
	// com ele, sabendo sempre em qual versao o serialVersionUID esta.
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String cpf;
	private String profissao;
	
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	@Override
	public String toString() {
		return "Amor por favor nao desligue o telefone!";
	}
}
