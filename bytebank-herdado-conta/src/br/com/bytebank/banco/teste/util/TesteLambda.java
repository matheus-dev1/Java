package br.com.bytebank.banco.teste.util;

import java.util.List;
import java.util.function.Consumer;
import java.util.ArrayList;
import java.util.Comparator;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.TitularDaContaComparator;

public class TesteLambda {
	public static void main(String[] args) {
		Conta contaCorrente1 = new ContaCorrente(22, 33);
		Conta contaCorrente2 = new ContaCorrente(22, 44);
		Conta contaCorrente3 = new ContaCorrente(22, 22);
		Conta contaCorrente4 = new ContaCorrente(22, 11);
		
        Cliente clienteContaCorrente1 = new Cliente();
        Cliente clienteContaCorrente2 = new Cliente();
        Cliente clienteContaCorrente3 = new Cliente();
        Cliente clienteContaCorrente4 = new Cliente();
        
        clienteContaCorrente1.setNome("a");
        clienteContaCorrente2.setNome("b");
        clienteContaCorrente4.setNome("d");
        clienteContaCorrente3.setNome("c");
       
        
        contaCorrente1.setTitular(clienteContaCorrente1);
        contaCorrente2.setTitular(clienteContaCorrente2);
        contaCorrente3.setTitular(clienteContaCorrente3);
        contaCorrente4.setTitular(clienteContaCorrente4);
        
        contaCorrente1.deposita(363.0);
        contaCorrente2.deposita(353.0);
        contaCorrente3.deposita(343.0);
        contaCorrente4.deposita(373.0);
		
		List<Conta> listaDeContas = new ArrayList<Conta>();
		
		listaDeContas.add(contaCorrente1);
		listaDeContas.add(contaCorrente2);
		listaDeContas.add(contaCorrente3);
		listaDeContas.add(contaCorrente4);
		
		for (Conta conta : listaDeContas) {
			System.out.print(conta + " Indice: ");
			System.out.print(listaDeContas.indexOf(conta));
			System.out.println(conta.getTitular().getNome());
		}
		
		System.out.println(listaDeContas);
		
		System.out.println("----------------------------");
		
		// Isso eh um Lambda.
		// Mas por baixo dos panos ele vai implementar a interface Comparator(e neste caso sera
		// Comparator, porque o metodo solicita uma classe que implemente Comparator e coloquen o 
		// argumento do metodo, mas isso no Lambda fica implicito) com o metodo compareTo
		// listaDeContas.sort((Conta conta1, Conta conta2) -> {
			// return Integer.compare(conta1.getNumero(), conta2.getNumero());
			// }
		// );
		
		// Como a instancia da minha lista recebe um Generics do tipo Conta, e apenas sao
		// comparados objetos dos tipo Conta, eu nao preciso especificar que os argumentos
		// do meu Lambda eh do tipo conta.
		
		// Se minha funcao tiver apenas uma linha, eu posso omitir o "return";
		listaDeContas.sort((c1, c2) -> Integer.compare(c1.getNumero(), c2.getNumero()));
		
		// Neste caso eu nao preciso criar uma classe, implementar a interface Comparator e o 
		// metodo compare, panas crio a funcao da maneira que ela deve funcionar atribuo a interface
		// comparator.
		Comparator<Conta> comp = (Conta conta1, Conta conta2) -> {
			String nomeConta1 = conta1.getTitular().getNome();
			String nomeConta2 = conta2.getTitular().getNome();
			return nomeConta1.compareTo(nomeConta2);
		};
		
		// listaDeContas.forEach(new Consumer<Conta>() {
			// @Override
			// public void accept(Conta conta) {
				// System.out.print(conta + " Indice: ");
				// System.out.print(listaDeContas.indexOf(conta));
				// System.out.println(conta.getTitular().getNome());
			// }
		// });
		
		listaDeContas.forEach((conta) -> System.out.println(conta.getTitular().getNome()));
		
		System.out.println("----------------------------");
		
		for (Conta conta : listaDeContas) {
			System.out.print(conta + " Indice: ");
			System.out.print(listaDeContas.indexOf(conta));
			System.out.println(conta.getTitular().getNome());
		}
	}
}
