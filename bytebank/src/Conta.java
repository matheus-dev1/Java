public class Conta{
	// Atributos
	// Uma coisa que temos que perceber eh quando os atributos de uma classe realmente faz sentido pra ela
	// e quando e necessario criar uma nova classe para colocar atributos que se designam a ela.
	double saldo;
	int agencia = 5;
	int numero;
	String titular;
	
	// Colocar void em frente a um metodo quer dizer que este metodo nao vai me retornar nada.
	// Quando definiar um parametro para este metodo, o valor do parametro tem que ter o tipo do valor do parametro
	public void deposita(double valor) {
		// Este atributo "saldo" se refere ao objeto no qual esta invocando este metodo.
		// this. eh uma palavra chave do Java que indica que este atributo(saldo) faz referencia ao objeto criado. 
		// No exemplo do arquivo TestaMetodo.java a visualizaca seria tipo: conta.saldo, porque o objeto
		// instanciado neste arquivo desta classe foi nomeado de "conta"
		this.saldo += valor;
	}
	
	// DIFERENCA ENTRE METODO E FUNCAO.
	// Uma funcao nao estra atrelado a um objeto, enquando um objeto invoca um metodo de sua classe.
	public boolean saca(double valor){
		if(this.saldo >= valor) {
			this.saldo -= valor;
			// Ele vai retornar na invocacao deste metodo o boleano true
			return true;
		} else {
			return false;
		}
	}
	// O parametro contaDestino eh um parametro do tipo conta, que deve receber uma variavel do tipo Conta
	// ou seja, a instancia de um objeto do tipo conta.
	public boolean tranfere(double valor, Conta contaDestino) {
		// No exemplo do TesteMetodo.java o this. eh o contaDoMarcelo
		if(this.saldo >= valor) {
			this.saldo -= valor;
			// Como contaDestino eh uma referencia do objeto do tipo Conta, ele possui os metodos desta classe
			// e como eu estou recebendo esta referencia como parametro eu posso usar um metodo aqui na classe.
			contaDestino.deposita(valor);
			// Eu poderia tambem em vez de usar os metodos para depositar, poderia usar os atributos.
			// Exemplo contaDestion.saldo += valor;
			return true;
		}
		// Como return eh uma palavra chave que para a execucao do metodo se der true ele nem vai chegar nesta
		// linha, entao a gente nao necessariamente precisa do else{}
		return false;
	}
}