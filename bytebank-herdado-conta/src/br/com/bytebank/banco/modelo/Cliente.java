package br.com.bytebank.banco.modelo;

import java.io.Serializable;

// Criar um .JAR do projeto que basicamente eh os arquivos compilados(.class) do projeto.
// 1. Click direito no projeto e ir em export.
// 2. Entra na pasta Java e ir no icone JAR file.
// 3. Expandir o arquivos do projeto e seleiconar o que voce quer criar no .JAR.
// 4. Selecionar o local onde ele vai ficar armazenado e dar um nome com .jar no final.

// Por padrao todas as classes herdam de object, isso fica implicito, mesmo que voce nao coloque nada.
public class Cliente extends Object implements Serializable {
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
