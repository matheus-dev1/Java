package br.com.alura;

public class Aula implements Comparable<Aula>{
	private String titulo;
	private Integer tempo;
	
	public Aula(String titulo, Integer tempo) {
		super();
		this.titulo = titulo;
		this.tempo = tempo;
	}
	
	public Integer getTempo() {
		return tempo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	@Override
	public String toString() {
		return "Aula: " + this.titulo + ", " + this.tempo + " minutos";
	}
	
	@Override
	public int compareTo(Aula aula) {
		return this.titulo.compareTo(aula.titulo);
		
		// if(this.tempo > aula.tempo) {
			// return 1;
		// }
		// return -1;
	}
}
