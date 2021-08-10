// Uma interface eh como fosse uma classe, com as seguintes diferencas.
// No java isso e chamado de "contrato" e a classe que implmenta este "contrato" deve "assinar" colocando
// um bloco de comandos dentro destes metodos.

// Uma interface eh uma classe abstrata com todos os metodos abstratos.
public abstract interface Autenticavel {
	public abstract void setSenha(int senha);
	
	public abstract void setLogin(String login);
	
	public abstract boolean autentica(int senha, String login);
}
