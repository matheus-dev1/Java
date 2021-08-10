package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteObject {

	public static void main(String[] args) {
		Object cc = new ContaCorrente(22, 22);
		System.out.println(cc.toString());
		
		Cliente cliente = new Cliente();
		System.out.println(cliente.toString());
		
		ContaCorrente contaCorrente = new ContaCorrente(55, 767);
		ContaPoupanca contaPoupanca = new ContaPoupanca(54, 888);
		
		System.out.println(contaCorrente.toString());
		System.out.println(contaPoupanca.toString());
		
		println(contaPoupanca);
	}
	
	public static String println(Object a) {
		return "a";
	}
}
