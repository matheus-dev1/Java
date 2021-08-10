package br.com.bytebank.banco.modelo;

public class ContaPoupanca extends Conta {
	public ContaPoupanca(int agencia, int numero) {
		super(agencia, numero);
		
		System.out.println("Consturtor da Classe ContaPoupanca");
	}
	
	public void saca(double valor) throws SaldoInsuficienteException {
		super.saca(valor + 3);
	}
	@Override
	public String toString() {
		return "ContaPoupanca" + super.toString();
	}
}