package br.com.bytebank.banco.modelo;

public class GuardadorDeReferencias {
	// Do tipo Object
	private Object[] referencias;
	private int posicaoIndice;
	
	public GuardadorDeReferencias() {
		this.referencias = new Object[10];
	}
	
	public void adiciona(Object referencia) {
		this.referencias[this.posicaoIndice] = referencia;
		this.posicaoIndice++;
	}
	
	public int getQtdElementos() {
		return this.posicaoIndice;
	}
	
	public Object getReferencia(int indice) {
		return this.referencias[indice];
	}
}
