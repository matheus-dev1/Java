package br.com.alurator.playground.modelo;

public class SuperProduto {
	// Este metodo nunca vai ser encontrado pelo .getDeclaredField("id") por estar sendo herdada por Produto e estar como privado.
	private int id;
}
