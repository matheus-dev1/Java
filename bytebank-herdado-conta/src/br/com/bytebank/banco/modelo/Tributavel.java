package br.com.bytebank.banco.modelo;

public abstract interface Tributavel {
	// Se eu nao colocar public abstract ele eh implicito no Java
	double setValorImposto(double valor);
	
	public abstract double getValorImposto();
	
	public abstract boolean calcula(double porcentagemImposto);
}
