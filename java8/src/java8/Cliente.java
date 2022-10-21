package java8;

public class Cliente {

	private String nome;
	private String cpf;
	
	public Cliente(String cpf, String nome) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return "CPF: " + this.cpf + " | " + "Nome: " + this.nome;
	}
}
