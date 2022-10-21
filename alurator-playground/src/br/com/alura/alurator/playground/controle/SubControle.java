package br.com.alura.alurator.playground.controle;

public class SubControle extends Controle {

	public SubControle() {}
	
	private SubControle(String string) {
		System.out.println(string);
	}
	
	public void metodoSubControle1() {
		System.out.println("Executando o metodo SubControle.metodoSubControle1()");
	}

	private String metodoSubControle2() {
		System.out.println("Executando o metodo SubControle.metodoSubControle2");
		return "Retoro do metodo SubControle.metodoSubControle2";
	}
}
