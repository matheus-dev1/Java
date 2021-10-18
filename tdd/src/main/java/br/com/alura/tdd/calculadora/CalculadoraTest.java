package br.com.alura.tdd.calculadora;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

// Por padrão as classes de teste tem o nome da classe mais o sufixo "Test"
public class CalculadoraTest {
	
	// Cada cenario de teste é um METODO.
	@Test
	public void deveriaSomarDoisNumerosPositivosEDarDez() {
		Calculadora calculadora = new Calculadora();
		int soma = calculadora.soma(5, 5);
		// Valor esperado e o Valor testado/comparado
		Assert.assertEquals(10, soma);
	}
	
}
