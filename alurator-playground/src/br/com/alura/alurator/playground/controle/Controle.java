package br.com.alura.alurator.playground.controle;

import java.util.List;

public class Controle {
	
	public Controle() {}
	
	public Controle(String string) {}
	
	private Controle(String string, String string2) {}
	
	private List<String> lista = List.of("item 1", "item 2", "item 3");
	
	public List<String> getLista() {
		return lista;
	}
	
	public void metodoControle1() {}
	
	public void metodoControle2(String string) {
		System.out.println("metodoControle2(String string)");
		System.out.println("Parametro: " + string);
	}
	
	private void metodoControle2(String string, String string2) {
		System.out.println("metodoControle2(String string, String string2)");
		System.out.println("Parametro: " + string);
		System.out.println("Parametro2: " + string2);
	}
	
	public void metodoControle2(String string, Integer integer) {
		System.out.println("metodoControle2(String string, Integer integer)");
		System.out.println("Parametro: " + string);
		System.out.println("Parametro Integer: " + integer);
	}
}
