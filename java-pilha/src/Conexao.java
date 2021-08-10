
public class Conexao implements AutoCloseable{
	public Conexao() { 
		System.out.println("Iniciando conexao...");
	}
	
	// Se voce selecionar o que quer comentar e apertar CTRL + SHIFT + / 
	// Ele comenta desta maneira.
	/*
	 * public void incicarConexao() { System.out.println("Iniciando conexao..."); }
	 */
	public void getDados() {
		System.out.println("Pegando dados...");
		throw new IllegalStateException();
	}
//	public void fecharConexao() {
//		System.out.println("Fechando conexao...");
//	}
	
	// Obs: Quando voce vai assinar um metodo que traz uma excecao na sua assinatura, isso eh opcional,
	// voce pode escolher deixar a excecao unchecked
	@Override
	public void close() {
		System.out.println("Fechando conexao...");
	}
}
