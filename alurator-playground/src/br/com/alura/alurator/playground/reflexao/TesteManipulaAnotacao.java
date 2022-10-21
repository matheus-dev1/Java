package br.com.alura.alurator.playground.reflexao;

import br.com.alurator.playground.anotacao.NomeTagXml;
import br.com.alurator.playground.modelo.Produto;

public class TesteManipulaAnotacao {
	public static void main(String[] args) {
		Object produto = new Produto("Produto1", 20.0, "Marca1");
		Class<?> classe = produto.getClass();
		
		if(classe.isAnnotationPresent(NomeTagXml.class)) {
			NomeTagXml nomeTagXml = classe.getAnnotation(NomeTagXml.class);
			System.out.println(nomeTagXml.value());
		};
	}
}
