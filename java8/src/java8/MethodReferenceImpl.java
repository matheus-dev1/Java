package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceImpl {
	public static void main(String[] args) {
		Cliente cliente = new Cliente("396321", "Matheus");
		Cliente cliente2 = new Cliente("3963212", "Matheus2");
		List<Cliente> listaCliente = Arrays.asList(cliente, cliente2);
		// Para conseguir fazer uma chamada a um method reference é necessário que a invocação de método da direita receba os mesmos parâmetros da esquerda do lambda.
		// Ou seja, o eu forEach vai receber apenas o nome do cliente e o metodo getNome também.
		// cliente -> cliente.getNome()
		listaCliente.forEach(clienteTop -> clienteTop.getNome());
		listaCliente.forEach(Cliente::getNome);
		listaCliente.forEach(Cliente::getCpf);
		System.out.println("----------------------------------------------------");
		System.out.println(System.currentTimeMillis());
		
		
		// Como paramtro ele recebe um Runnable que é uma interface Funcional.
		// Nos temos que implementa-la, mas ela mas ela não retorna nada
		medirTempo(() -> {
		    try {
		        Thread.sleep(1000);
		    } catch (InterruptedException e) {
		        throw new RuntimeException(e);
		    }
		    // O que System.currentTimeMillis retorna é um número (no caso, um long) que representa a quantidade de milissegundos que se passou desde este instante.
		    // Obs: currenteTimeMillis e um metodo estatico.
		}, System::currentTimeMillis);
		
		// Isso
		new MethodReferenceImpl().tamanho("teste"::length);
		// é a mesma coisa que isso
		new MethodReferenceImpl().tamanho(() -> "teste".length());
		// Aqui eu estou executando o metodo String.lenght(), da string que esta dentro de "apply"
		String UpperString = new MethodReferenceImpl().tamanhoFuctionString(String::toUpperCase);
		System.out.println(UpperString);
		// Esse metodo vai converter o inteiro dentro de "function.apply()" para Double
		Double integerToDouble = new MethodReferenceImpl().tamanhoFuctionDouble(Integer::doubleValue);
		System.out.println(integerToDouble);
		// Vou instanciar um inteiro com o conteudo de "function.apply()"
		Integer integerConstrutor = new MethodReferenceImpl().tamanhoFuctionConstrutctorInteger(Integer::new);
		System.out.println(integerConstrutor);
	}
	
	public static void medirTempo(Runnable rotinaDemorada, Supplier<Long> timestampSupplier) {
	    long inicio = timestampSupplier.get();
	    rotinaDemorada.run();
	    System.out.format("Tempo: %d ms", timestampSupplier.get() - inicio);
	    System.out.println();
	}
	
	public Object tamanho(Supplier<?> inteiro) {
		System.out.println(inteiro.get());
		return inteiro.get();
	}
	
	public String tamanhoFuctionString(Function<String, String> function) {
	    return function.apply("minusculo");
	}
	
	public Double tamanhoFuctionDouble(Function<Integer, Double> function) {
	    return function.apply(5);
	}
	
	public Integer tamanhoFuctionConstrutctorInteger(Function<Integer, Integer> function) {
	    return function.apply(50);
	}
}
