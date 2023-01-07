public class TesteConexao {
	public static void main(String[] args) {
		// try-with-resources
		// Nos podemos instanciar um objeto e armazenar um referencia no try ( ) { }.
		
		// Porem ele precisa implementar/assinar uma interface chamada AutoCloseable, e implementar um metodo
		// chamado close(), e nos podemos definir o que ele vai fazer da maneira que quisermos.
		
		// E a instancia do objeto fica disponivel para todos so escopos, try, catch e finally.
		
		// E o metodo close() fica implicito, voce não precisa escrever um finally e coloca-lo.
		
		// O que eu escrevi no close vai ocorrer aqui neste codigo mesmo eu nao precisando escreve-lo, simplesmente porque a minha conexão, implementou AutoCloseable.
		try (Conexao conexao = new Conexao()) {
			conexao.getDados();
			// A exceção IllegalStateException indica que um objeto possui um estado invalido.
		} catch(IllegalStateException exception) {
			System.out.println("Ocorreu um erro no recebimento dos dados.");
		}
	}

}
