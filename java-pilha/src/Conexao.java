
// Classe que simplesmente representa uma conex�o com um banco de dados por exemplo.
public class Conexao implements AutoCloseable {
	// Metodo que representa a execu��o da conex�o, mas exibe um println
	public Conexao() { 
		System.out.println("Iniciando conexao...");
	}
	
	// Se voce selecionar o que quer comentar e apertar CTRL + SHIFT + /
	
	public void incicarConexao() {
		System.out.println("Iniciando conexao..."); 
	}
	
	/* Metodo que simula o recebimento de dados, mas que simplemente printa uma string e lan�a uma exce��o (IllegalStateException) que 
	sinaliza que um m�todo foi invocado de forma ilegal ou hora impr�pria.*/
	public void getDados() {
		System.out.println("Pegando dados...");
		throw new IllegalStateException();
	}
	
	public void fecharConexao() {
		System.out.println("Fechando conexao...");
	}
	
	// Obs: Quando voce vai assinar um metodo que traz uma excecao na sua assinatura, isso eh opcional,
	// voce pode escolher deixar a exce��o como unchecked. 
	@Override
	public void close() {
		System.out.println("Fechando conexao...");
	}
}
