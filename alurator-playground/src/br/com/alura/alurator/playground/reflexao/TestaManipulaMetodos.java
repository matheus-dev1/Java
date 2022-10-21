package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Field;

import br.com.alurator.playground.modelo.Produto;
import br.com.alurator.playground.modelo.SuperProduto;

public class TestaManipulaMetodos extends SuperProduto {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Object produto = new Produto("Produto1", 20.0, "Marca1");
		Class<?> classe = produto.getClass();
		// Retorna todos os atriubutos da classe em questão
		Field[] atributosProduto = classe.getDeclaredFields();
		for (Field field : atributosProduto) {
			field.setAccessible(true);
			// field.getName() - Vai mostrar o nome do atributo
			// field.get(Object classe) - Vai mostrar o valor do campo
			System.out.println(field.getName() + " - " + field.get(produto));
		}
		// produto.getClass().getDeclaredField("id").setAccessible(true);
		// System.out.println(produto.getClass().getDeclaredField("id"));
	}
}
