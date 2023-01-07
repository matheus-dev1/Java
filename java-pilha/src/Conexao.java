
// Classe que simplesmente representa uma conexão com um banco de dados por exemplo.
public class Conexao implements AutoCloseable {
	// Metodo que representa a execução da conexão, mas exibe um println
	public Conexao() { 
		System.out.println("Iniciando conexao...");
	}
	
	// Se voce selecionar o que quer comentar e apertar CTRL + SHIFT + /
	
	public void incicarConexao() {
		System.out.println("Iniciando conexao..."); 
	}
	
	/* Metodo que simula o recebimento de dados, mas que simplemente printa uma string e lança uma exceção (IllegalStateException) que 
	sinaliza que um método foi invocado de forma ilegal ou hora imprópria.*/
	public void getDados() {
		System.out.println("Pegando dados...");
		throw new IllegalStateException();
	}
	
	public void fecharConexao() {
		System.out.println("Fechando conexao...");
	}
	
	// Obs: Quando voce vai assinar um metodo que traz uma excecao na sua assinatura, isso eh opcional,
	// voce pode escolher deixar a exceção como unchecked. 
	@Override
	public void close() {
		System.out.println("Fechando conexao...");
	}
}
