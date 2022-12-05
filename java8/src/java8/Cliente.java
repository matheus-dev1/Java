package java8;

public class Cliente {

	private String nome;
	private String cpf;
	
	public Cliente(String cpf, String nome) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getNome() {
		System.out.println(this.nome);
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		System.out.println(this.cpf);
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "CPF: " + this.cpf + " | " + "Nome: " + this.nome;
	}
}
