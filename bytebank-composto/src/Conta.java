public class Conta{
	// Atributos
	
	// Uma coisa que temos que perceber eh quando os atributos de uma classe realmente faz sentido pra ela
	// e quando e necessario criar uma nova classe para colocar atributos que se designam a ela.
	
	// Uma boa pratica trabalhando com POO, eh nos sempre devemos trabalhar em uma classe atraves de seus 
	// metodos e nunca atraves dos seus atributos, a ideia do atributo e criar uma caracteristica e essa
	// caracteristica sofrer uma alteracao atraves de um mecanismo(metodo) e nao manualmente(atribuindo direto
	// no atributo)
	
	// Ao declarar que um atributo eh do tipo privado, ele so pode ser lido e alterado pela propria classe, no 
	// caso Conta.
	
	// Um beneficio disso eh que, quem eh o dono este atributo eh que pode fazer o que quiser com ele.
	private double saldo;
	int agencia = 5;
	int numero;
	// O pensamento de criar um relacao entre a classe Conta com a classe Cliente, eh o seguinte, toda classe
	// Conta possui uma REFERENCIA da classe CLIENTE.
	// O tipo da variavel titular eh uma Referencia a um objeto do tipo Cliente(classe).
	
	// Se eu quisesse por exemplo sempre que instanciar um objeto do tipo Conta eu tambem ja instanciava e 
	// atribuia ao atributo titular de Conta. Exemplo Cliente titular = new Cliente();
	Cliente titular;
	
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
	
	// Aqui por exemplo eu responsabilizo que apenas a travez desse metodo eu consigo pegar o valor do atributo
	// saldo. Estou criando uma unica responsabilidade.
	
	// Por uma conversao, metodos que apenas nos retonam um valor como por exemplo este, nos colocamos um "get"
	// antes do nome do metodo. Exemplo : getSaldo()
	
	// Dica Eclipse: Nele nos temos uma fucionalidade onde nos conseguimos mudar o nome de alguma coisa (que nao
	// seja uma string) em todos os arquivos de uma so vez. Seleciona o nome que voce quer alterar, botao direito,
	// "Refactor" -> "Rename" -> "Enter"
	public double getSaldo() {
		return (
			this.saldo
		);
	}
}