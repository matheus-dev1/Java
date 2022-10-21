package br.com.devmedia.lojavirtual;

public class CD {
	private long codigo;
	private String titular;
	private String artista;
	private double preco;
	
	public CD(long codigo, String titular, String artista, double preco) {
		this.codigo = codigo;
		this.titular = titular;
		this.artista = artista;
		this.preco = preco;
	}
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
}
