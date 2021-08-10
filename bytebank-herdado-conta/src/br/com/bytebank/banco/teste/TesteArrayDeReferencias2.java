package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteArrayDeReferencias2 {

	public static void main(String[] args) {
		// Array de referecia com 5 posicoes.
		Conta[] contas = new Conta[5];
		
		ContaPoupanca contaPoupanca = new ContaPoupanca(44, 66);
		contas[0] = contaPoupanca;
		
		ContaCorrente contaCorrente = new ContaCorrente(65, 77);
		contas[1] = contaCorrente;
		
		// Nos podemos pegar a referencia de um objeto ContaCorrente e colocar em um objeto Conta, porque
		// ContaCorrente tambem eh Conta, porque ContaCorrente herda Conta.
		Conta ref = contas[1];
		
		// O nosso array foi criado com o tipo Conta, mesmo sabendo que no indice 0 do array conta
		// se enconta uma referencia do tipo ContaPoupanca o array ainda eh do tipo Conta, entao para 
		// resolver isso nos podemos fazer uma conversao na propria linha chamada "type cast ou type casting"
		ContaPoupanca ref2 = (ContaPoupanca) contas[0];
		
		System.out.println(contas[0].getNumero()); // 66
		System.out.println(contas[1].getNumero()); // 77
		System.out.println(ref.getNumero()); // 77
		System.out.println(ref2.getNumero()); // 66
	}

}
