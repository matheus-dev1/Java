package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteTitular {

	public static void main(String[] args) {
		// ------ Cliente cliente = new Cliente();
		// ------ cliente.setNome("Matheus");
		
		// ------ ContaCorrente contaCorrente = new ContaCorrente(2323, 4343);
		
		// Tenho que passar um referencia do tipo cliente, sendo a propria classe Cliente, ou quem herdar 
		// da classe cliente.
		// ------ contaCorrente.setTitular(cliente);
		
		// A ideia da classe cliente eh, diferenciar atributos e metodos do cliente para atributos e metodos
		// da CONTA do CLIENTE.
		
		// contaCorrente = Armazenando a referencia da instancia de um objeto do tipo ContaCorrente();
		// Atributo que armazena uma referencia de uma classe do tipo Cliente();
		// Metodo da classe Cliente();
		// ------- ContaCorrente.titular.setNome("Matheus");
		// ------- System.out.println(ContaCorrente.titular.getNome());
		// Obs: Observe que eu nao precisei instaciar conta corrente. Porque o atributo titular eh do tipo
		// referencia da classe Cliente e esta como statico ou seja não precisa instanciar
		// um objeto pra acessar algum método dela.
	}

}
