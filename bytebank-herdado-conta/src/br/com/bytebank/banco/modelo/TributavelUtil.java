package br.com.bytebank.banco.modelo;

import java.io.Serializable;

public class TributavelUtil implements Serializable {
	public double valor;
	
	public double setValorImposto(double valor) {
		return this.valor = valor;
	}
	
	public double getValorImposto() {
		return this.valor;
	}
	
	public boolean calcula(double porcentagemImposto) {
		System.out.println("Valor do Imposto: " + (this.valor * porcentagemImposto));
		return true;
	}
}
