/**
 * Documentacao(Javadoc). Normalmente documentamos tudo que for publico.
 * @author Matheus de Oliveira Silva
 * @version 1.0
 */

package br.com.bytebank.banco.modelo;

// Importando, ou seja eu vou pre colocar este pacote no inicio de toda classe que ela pertence.
import br.com.bytebank.banco.teste.*;

import java.io.Serializable;

import br.com.bytebank.banco.modelo.*;

// Para gerar um Javadoc -> Project -> Generate Javadoc.

/**
 * Classe que representa a conta do usuario.
 * @author mathe (usado na classe ou interface)
 * @version 1.0 (usado na classe ou interface)
 *
 */ 
// A interface Comparable possui apenas um metodo abstrato, chamado compareTo, usado para compara
// uma classe com outra.

// Todo classe que voce herdar/instanciar voce precisa implementar um Serializable nela.
public abstract class Conta extends Object implements Comparable<Conta>, Serializable {
	// Modificadores de acesso/visibilidade
	// Public - visivel em todo lugar, dentro e fora do package/pacote.
	// Protected - Protectec eh visiavel para a propria class e public para as classes 
	// filhas e o pacote nao importa, desde que a classe seja filha.
	// Obs: Se por exemplo eu tirar a visibilidade public do construtor e deixar em branco eu nao 
	// consigo instanciar(new ClassConstrutorExemploBlaBlaBla();) em outro pacote.
	// <<package private>> - Quando voce nao define nenhuma visibilidade voce internamente usa o
	// "package private", que basicamente, deixa o membro(atributos, class, metodo, ou contrustor)
	// privado ao PACOTE.
	// Private - Visivel apenas dentro da classe.
	
	// private (visível apenas na classe)
	// <<package private>> (visível na classe E em qualquer outro membro do mesmo pacote, podendo
	// ser chamado de default)
	// protected (visível na classe E em qualquer outro membro do mesmo pacote E para qualquer filho)
	// public (visível em qualquer pacote)
	
	protected double saldo;
	private int agencia;
	private int numero;
	public Cliente titular;
	private static int total;
	
	Teste teste = new Teste();
	
	/**
	 * Construtor para iniciar o objeto Conta, com os parametros agencia, referente a agencia da conta
	 * e numero referente ao numero da conta.
	 * @param agencia
	 * @param numero
	 */
	public Conta(int agencia, int numero){
		if (agencia < 0) {
			// A IllegalArgumentException verifica argumentos/parametros invalidos.
			throw new IllegalArgumentException("Agencia invalida!");
		}
		if (numero < 0) {
			throw new IllegalArgumentException("Numero de conta invalido!");
		}
		
		br.com.bytebank.banco.modelo.Conta.total++;
		
		System.out.println("Todal de contas registradas: " + Conta.total);
		
		// if  (agencia <= 0 || numero <= 0) {
			// System.out.println("Agencia ou numero com numero invalidos!");
			// return;
		// }
		
		this.setAgencia(agencia);
		this.setNumero(numero);
		
		System.out.println("Agencia: " + this.agencia + " - " + "Numero da Conta: " + this.numero);
	}
	
	//	public Conta() {
	//		Conta.total++;
	//		System.out.println("Segundo Construtor!");
	//	}
	
	public void deposita(double valor) {
		this.saldo += valor;
	}
	
	/**
	 * Metodo saca, para efetuar um saque em conta, solicitando um valor como parametro e tendo 
	 * uma excecao {@link SaldoInsuficienteException} caso o saldo da conta seja insufiente ao tentar
	 * efetuar o saque.
	 * @param valor
	 * @throws SaldoInsuficienteException
	 */
	public void saca(double valor) throws SaldoInsuficienteException {
		// Se o saldo for menor que o valor do saque execute esta excecao.
		if (this.saldo < valor) {
			throw new SaldoInsuficienteException("Seu saldo: " + this.saldo + ", valor que foi tentado efetuar o saque: " + valor);
		}
		this.saldo -= valor;
	}
	
	// Eu consigo passar para como parametro a classe padrao do parametro, no caso Conta, mas eu tambem
	// consigo passar classes que HERDAM da classe Conta, ou seja, se eu passar a classe ContaCorrente
	// vai funcionar porque ela herda de funcionario, ou seja, "existe" dentro da classe gerente
	// a classe funcionario.
	public void tranfere(double valor, Conta contaDestino) throws SaldoInsuficienteException {
		// logica aqui eh o seguinte, o objeto tenta invocar o metodo tranfere, e passar um valor,
		// eu pego este valor e executo saldo para verificar se o objeto tem saldo e se tiver
		// ele vai retirar o saldo e depois pegar o valor do paraemtro e passar para a 
		// conta de destino/tranferencia.
		this.saca(valor);
		contaDestino.deposita(valor);
		
		// if (this.saldo >= valor) {
			// this.saldo -= valor;
			// Conta eh uma classe que foi herdada nas classe ContaCorrente e ContaPoupanca.
			// Se eu por por exemplo passo como parametro uma Referencia do tipo ContaConrrente.
			// O "contaDestino" sera a referencia do objeto passado como segundo parametro.
			// contaDestino.deposita(valor);
			// return true;
		// }
		// return false;
	}
	
	/**
	 * @return (usado apenas no método)
	 */
	public double getSaldo() {
		return (this.saldo);
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public int getNumero() {
		return(this.numero);
	}
	public void setNumero(int numero) {
		if (numero <= 0) {
			System.out.println("Numero da conta menor ou igual a zero.");
			return;
		}
		this.numero = numero;
	}

	public int getAgencia() {
		return this.agencia;
	}
	public void setAgencia(int agencia) {
		if (agencia <= 0) {
			System.out.println("Agencia menor ou igual a zero.");
			return;
		}
		this.agencia = agencia;
	}
	
	public Cliente getTitular() {
		return this.titular;
	}
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	public static int getTotal() {
		// Essa qualificacao (Full Qualified Name(FQN)), nao eh necessaria quando eu uso 
		// a Classe dentro do proprio pacote, mas posso colocar.
		return(br.com.bytebank.banco.modelo.Conta.total);
	}
	
	// O metodo toString() eh padrao, se voce nao executar nenhuma metodo em alguma referencia de algum objeto
	// ele ira executar to String. Aqui nos sobreescrevemos ele.
	@Override
	public String toString() {
		return "Numero: " + this.numero + " Saldo: " + this.saldo;
	}
	// Sobreescrevendo o metodo equals da classe Object.
	// Este metodo por padrao compara uma referencia com outra, mas eu sobreescrevi e defini a minha 
	// regra de negocio, eu quero usar este metodo mas do meu jeito.
	// Obs: A classe java.lang.Util possui um metodo chamado constains() que 
	@Override
	public boolean equals(Object object) {
		// Type casting object passado deve herdar de conta.
		Conta conta = (Conta) object;
		
		if(this.agencia != conta.agencia) {
			return false;
		}
		
		if(this.numero != conta.numero) {
			return false;
		}
		
		return true;
	}
	
	// Nao estou sobreescrevendo, estou implementando...
	
	// Aqui estou definindo a Ordem Natural da minha classe Conta, onde quando eu usar algum metodo de 
	// comparadao do Java, ele vai verificar aqui, qual criterio eu estou utiliando...
	public int compareTo(Conta conta) {
		return Double.compare(this.saldo, conta.saldo);
	}
}