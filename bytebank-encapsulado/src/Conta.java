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
	
	// Estes atributos, sao atributos de instancias/objetos e cada um objeto instanciado por essa clase vai ter
	// um atribudo do tipo saldo diferente, por exemplo.
	private double saldo;
	private int agencia = 5;
	private int numero;
	// O pensamento de criar um relacao entre a classe Conta com a classe Cliente, eh o seguinte, toda classe
	// Conta possui uma REFERENCIA da classe CLIENTE.
	// O tipo da variavel titular eh uma Referencia a um objeto do tipo Cliente(classe).
	
	// Se eu quisesse por exemplo sempre que instanciar um objeto do tipo Conta eu tambem ja instanciava e 
	// atribuia ao atributo titular de Conta. Exemplo Cliente titular = new Cliente();
	private Cliente titular;
	
	// static nos garante que somente haverá uma, e não mais que uma, referência para determinada
	// variável/atributo ou método disponível em mémoria.
	
	// Em outras palavras, declarando alguma coisa como static, todas as instâncias da classe irão
	// compartilhar a mesma cópia da variável ou método.
	
	// Entao nao existe mais por exemplo this.total e apenas Conta.total(Conta porque o nome da classe
	// em que ele pertence se chama conta).
	private static int total;
	
	// O "construtor padrao", a gente nem necessariamente precisa escrever ele e ele vem sem nada.
	
	// Um construtor nao eh um metodo, ele eh uma rotida de inicializacao.
	
	// Ele so eh executado uma vez, quando voce constroi/cria o objeto.
	
	// Voce pode ter varios construtores.
	
	// inicialização de atributos é a principal responsabilidade do construtor.
	
	// Passando estes parametros o meu estado(conjunto de atributos) nao esta mais inconsistente, por voce
	// eh obrigado a passar um valor de agencia e numero de conta validos para criar o objeto.
	public Conta(int agencia, int numero){
		// Como este eh um atributo static a gente nao mais referenia a instancia e sim a classe.
		Conta.total++;
		System.out.println("Todal de contas registradas: " + Conta.total);
		if(agencia <= 0 || numero <= 0) {
			System.out.println("Agencia ou numero com numero invalidos!");
			return;
		}
		this.setAgencia(agencia);
		this.setNumero(numero);
		System.out.println("Agencia: " + agencia + " - " + "Numero da Conta: " + numero);
	}
	
	// Segundo construtor, ou seja, eu posso criar um objeto atendendo os requisitos daquele construtor
	// de cima ou este de baixo.
	public Conta() {
		Conta.total++;
		System.out.println("Segundo Construtor!");
	}
	
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
		return (this.saldo);
	}
	public int getNumero() {
		return(this.numero);
	}
	// Por convencao, o nome de parametros de metodos do tipo "set" receberem o mesmo nome do atributo.
	public void setNumero(int numero) {
		if(numero <= 0) {
			System.out.println("Numero da conta menor ou igual a zero.");
			return;
		}
		this.numero = numero;
	}
	// Dica do Eclipse: Se voce comecar a escrever Set ou Get e o nome de algum atributo, mais ou menos a 
	// metade dele, e clicar CTRL + Space, na segunda sugestao de autocomplete, ele vai sugerir criar 
	// um metodo getter ou setter pra voce.
	public int getAgencia() {
		return this.agencia;
	}
	// Metodos tambem sao conhecidos como - INTERFACE DE UM OBJETO.
	public void setAgencia(int agencia) {
		if(agencia <= 0) {
			System.out.println("Agencia menor ou igual a zero.");
			return;
		}
		this.agencia = agencia;
	}
	// Observe o que o tipo de retono deste metodo getter eh um objeto do tipo "Cliente"
	public Cliente getTitular() {
		return this.titular;
	}
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	public static int getTotal() {
		// Eu nao posso acessar atributos de instancia em metodos "estaticos"
		return(Conta.total);
	}
}