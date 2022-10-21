package br.com.alura.alurator.playground.controle;

import java.io.IOException;
import java.util.List;

public class ControleException {
	
	public ControleException() throws IOException {
		throw new IOException();
	}
	
	public ControleException(String string) {}
	
	private ControleException(String string, String string2) {}
	
	private List<String> lista = List.of("item 1", "item 2", "item 3");
	
	public List<String> getLista() {
		return lista;
	}
}
