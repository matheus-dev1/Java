package br.com.alura.bytebank;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

// Para utilizar um arquivo .jar(Java Archive) voce de clicar com o botao direito e ir Build Path ->
// Add to Build Path para o compilador enxergar as classes deste arquivo .jar

public class TesteBiblioteca {

	public static void main(String[] args) {
		Conta conta = new ContaCorrente(2323, 2323);
		
		conta.deposita(200);
		
		System.out.println(conta.getSaldo());

	}

}
