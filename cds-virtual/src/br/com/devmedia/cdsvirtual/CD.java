package br.com.devmedia.cdsvirtual;

public class CD {
	private long codigo;
	private String titulo;
	private String artista;
	private double preco;
	
	public CD(long codigo, String titulo, String artista, double preco) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.artista = artista;
		this.preco = preco;
	}
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titular) {
		this.titulo = titular;
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
