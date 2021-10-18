package br.com.alura.tdd.calculadora;

public class CalculadoraTestes {
	public static void main(String[] args) {
		// Um teste automatizado não é nada mais que uma classe que simula o uso daquela classe.
		System.out.println(new Calculadora().soma(5, 5));
	}
}
