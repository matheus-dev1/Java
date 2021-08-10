package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.*;

public class TesteSacaUnchecked {

	public static void main(String[] args) {
		ContaCorrente conta1 = new ContaCorrente(54646, 34534);
		conta1.deposita(200);
		try {
			conta1.saca(199);
		} catch(SaldoInsuficienteException exception) {
			System.out.println(exception);
		}
		
		
		System.out.println(conta1.getSaldo());
		
		// ---------------------------------------------------
		
		ContaPoupanca conta2 = new ContaPoupanca(2323, 3434);
		
		conta2.deposita(4000);
		try {
			conta2.saca(3500);
		} catch(SaldoInsuficienteException exception) {
			System.out.println(exception);
		}
		
		System.out.println(conta2.getSaldo());
	}

}
