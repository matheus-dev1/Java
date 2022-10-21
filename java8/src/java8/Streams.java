package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Streams {
	public static void main(String[] args) {
		/* Considerando uma lista de Clientes List<Cliente> clientes podemos usar Streams
		 * para executar várias tarefas que antes precisavam de muito código e que poderiam
		 * ser escritas de maneiras distintas. Com Streams essas tarefas ficam mais simples,
		 * estruturadas e padronizadas. Vamos conhecer algumas funcionalidades desta API.
		 */
		
		Cliente clienteMatheus = new Cliente("Matheus", "26129469518");
		Cliente clienteMatheus2 = new Cliente("Matheus2", "5664566");
		Cliente clienteMatheus3 = new Cliente("Matheus3", "34634563456");
		Cliente clienteMatheus4 = new Cliente("Matheus4", "768566585");
		Cliente clienteMatheus5 = new Cliente("Matheus5", "32345233452435");
		Cliente clienteMatheus6 = new Cliente("Matheus6", "68568567");
		Cliente clienteMatheus7 = new Cliente("Matheus7", "34523527425");
		
		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes.add(clienteMatheus);
		listaClientes.add(clienteMatheus2);
		listaClientes.add(clienteMatheus3);
		listaClientes.add(clienteMatheus4);
		listaClientes.add(clienteMatheus5);
		listaClientes.add(clienteMatheus6);
		listaClientes.add(clienteMatheus7);
		
		// Os stream só podem fazer uma operação por vez.
		Stream<Cliente> clientesStream1 = listaClientes.stream();
		
		// count - Retorna a quantidade de elementos presentes em uma stream.
		Long quantidadeClientes = clientesStream1.count();
		System.out.println(quantidadeClientes);
		
		// limit - Retorna uma nova stream que contém apenas os N primeiros elementos da stream original.
		Stream<Cliente> clientesStream2 = listaClientes.stream();
		Stream<Cliente> clientesStreamLimit = clientesStream2.limit(5);
		// Verificando que apemas retornaram 5 streams de cliente.
		quantidadeClientes = clientesStreamLimit.count();
		System.out.println(quantidadeClientes);
		
		// skip - Retorna uma nova stream que não contém os N primeiros elementos da stream original.
		Stream<Cliente> clientesStream3 = listaClientes.stream();
		Stream<Cliente> novoStreamCliente = clientesStream3.skip(3);
		System.out.println(novoStreamCliente.count());
		
		
	}
}
