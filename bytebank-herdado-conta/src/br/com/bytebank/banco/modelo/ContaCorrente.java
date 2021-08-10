package br.com.bytebank.banco.modelo;

import java.io.Serializable;

// No eclipe na criacao de conta, eu ja consigo colocar uma classe mae ou super classe neste classe, no campo
// "Superclass: " e no input, coloca o nome da super que classe que deseja herdar.

// Na heranca, eu herdo os atributos e metodos, mas nao o construtor.
public class ContaCorrente extends Conta implements Serializable{
	
	// transient | Significa que nao faz parte da serializacao.
	// private transient TributavelUtil calcular;
	private TributavelUtil calcular;
	
	// Se sua classe esta herdando de uma outra classe existem duas possibilidades.
	// 1. Se a classe herdada possui um construtor padrao implicito, entao aqui(ContaCorrente) voce tambem nao
	// precisa escrever nada ate porque esta implicito aqui tambem.
	// 2. Se a classe herdada possui parametros, voce deve criar um construtor aqui(ContaCorrente) com os mesmos
	// parametros e usar o super para executar o construtor da classe mae.
	public ContaCorrente(int agencia, int numero) {
		// Super passa os parametro desta classe(ContaCorrente) para a classe mae e tambem executa ela.
		
		// O super() serve para chamar o construtor da superclasse. Ele sempre é chamado, mesmo quando não está
		// explícito no código, quando for explicitado deve ser o primeiro item dentro do construtor.
		super(agencia, numero);
		
		System.out.println("Consturtor da Classe ContaCorrente");
		
		this.calcular = new TributavelUtil();
	}
	
	// Dica do Eclipse: Se voce escrever o nome de um metodo que voce queira sobreescrever e CTRL + 
	// ele vai completar pra voce o metodo e ainda vai adicionar uma "anotacao" @override mostrando que este metodo
	// eh uma sobreescrita de um metodo da classe mae.
	//	@Override
	//	public boolean saca(double valor) {
	//		double valorSacar = valor + 0.2;
	//		return (super.saca(valorSacar));
	//	}
	
	public void saca(double valor) throws SaldoInsuficienteException {
		super.saca(valor + 1);
	}
	
	// ------------------------------------------------------
	
	public double setValorImposto(double valor) {
		return this.calcular.setValorImposto(valor);
	}
	
	public double getValorImposto() {
		return this.calcular.getValorImposto();
	}
	
	public boolean calcula(double porcentagemImposto) {
		return this.calcular.calcula(porcentagemImposto);
	}
	@Override
	public String toString() {
		return "ContaCorrente, " + super.toString();
	}
}
