package br.com.alura.alurator.playground.controle;

import java.io.IOException;

public class SubControleExeption extends ControleException {

	public SubControleExeption() throws IOException {}
	
	private SubControleExeption(String string) throws IOException {
		System.out.println(string);
	}

}
