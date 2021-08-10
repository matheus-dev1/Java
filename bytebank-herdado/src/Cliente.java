
// Aqui eu estou implementando os metodos da interface Autenticavel, ou seja, estou definindo o que os 
// metodos da interface Autenticavel vao fazer.

// Eu posso implementar mais de uma interface por classe.

// Uma outra forma da utilizacao do Polimorfismo(polimorfismo é o princípio pelo qual duas ou mais classes 
// derivadas da mesma superclasse ou interface podem invocar métodos que têm a mesma 
// assinatura, mas comportamentos distintos.)
public class Cliente implements Autenticavel {
	
	// Atributo como referencia da instanco de AutenticacaoUtil.
	private AutenticacaoUtil autenticador;
	
	// Composicao - É instanciar, ou usar, uma classe/objeto em outra(o). É como se elas se comunicassem,
	// trocassem informações. Ou seja, serve para reutilizar dados, sem ter que criar mais código pra isso.
	// ... Costuma-se dizer que composição é o ato de delegar trabalho para outro objeto.
	
	// Nesta ideia nos estamos centralizando as logicas dos metodos em um lugar so...
	public Cliente() {
		this.autenticador = new AutenticacaoUtil();
	}
	
	public void setSenha(int senha) {
		this.autenticador.setSenha(senha);
	}
	
	public void setLogin(String login) {
		this.autenticador.setLogin(login);
	}
	
	public boolean autentica(int senha, String login) {
		return this.autenticador.autentica(senha, login);
	}
}
