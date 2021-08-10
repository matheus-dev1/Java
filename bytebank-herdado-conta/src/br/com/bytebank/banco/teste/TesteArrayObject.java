package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteArrayObject {
	public static void main(String[] args) {
		Object[] referenciasObject = new Object[5];
		
		ContaPoupanca contaPoupanca = new ContaPoupanca(44, 66);
		referenciasObject[0] = contaPoupanca;
		
		ContaCorrente contaCorrente = new ContaCorrente(65, 77);
		referenciasObject[1] = contaCorrente;
		
		ContaCorrente typeCastingExplictReference = (ContaCorrente) referenciasObject[1];
		
		typeCastingExplictReference.setSaldo(444);
		System.out.println(typeCastingExplictReference.getSaldo());
	}
}
