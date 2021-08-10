
public class TestaBanco {
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.cpf = "222.222.222-22";
		cliente.nome = "Matheus";
		cliente.profissao = "Programador Java";
		
		Conta conta = new Conta();
		// Aqui eu estou fazendo uma composicao de Objetos, ou seja, eu estou colocando a referencia do objeto
		// cliente no atributo titular da classe Conta, e com isso eu consigo ter acesso a metodos e atributos
		// da classe Cliente a partir da classe Conta
		conta.titular = cliente;
		System.out.println("Valor do atributo 'titular': " + conta.titular);
		System.out.println(cliente);
		System.out.println("Valor do CPF do Cliente: " + conta.titular.cpf);
		System.out.println("Valor do Nome do Cliente: " + conta.titular.nome);
		System.out.println("Valor da Profissao do Cliente: " + conta.titular.profissao);
	}
}
