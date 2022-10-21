package br.com.devmedia.lojavirtual;

public class Usuario {
	private String nome;
	private String endereco;
	private String cartao;
	
	public Usuario() {}
	
	public Usuario(String nome, String endereco, String cartao) {
 		this.nome = nome;
		this.endereco = endereco;
		this.cartao = cartao;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getCartao() {
		return cartao;
	}
	public void setCartao(String cartao) {
		this.cartao = cartao;
	}
}