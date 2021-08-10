package br.com.bytebank.banco.modelo;

public class CalcularImposto {
	public double porcentagemImposto = 0.075;
	
	public void calcula(Tributavel tributavel) {
		if(tributavel.calcula(this.porcentagemImposto)) {
			System.out.println("Ok");
		} else {
			System.out.println("Not ok");
		}
	}
}
