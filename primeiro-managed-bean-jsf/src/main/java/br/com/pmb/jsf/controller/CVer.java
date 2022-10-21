package br.com.pmb.jsf.controller;

import javax.annotation.ManagedBean;

/* Um Managed Bean é uma classe que recebe informações de uma página XHTML (View)
 * processa estas informações e devolve para o usuário outra página XHTML.
 */
@ManagedBean(value = "CVer")
public class CVer {
	private int valor;
	private String resultado;

	public CVer() {}

	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	public void Verificar() {
		if (this.valor == 10) { 
			this.resultado = "IGUAL";
		}
		if (this.valor > 10) { 
			this.resultado = "MAIOR"; 
		}
		if (this.valor < 10) { 
			this.resultado = "MENOR";
		}
	}
}
