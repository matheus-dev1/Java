
public class TestaContaSemCliente {
	public static void main(String[] args) {
		Conta conta = new Conta();

		// O valor padrao para um atributo do tipo "Referemcia de Objeto" eh "null", podemos entender como, vazio,
		// ou sem referencia pra nenhum objeto.
		System.out.println(conta.titular);
		
		// Eu estou fazendo a criacao e atribuicao da referencia do objeto Cliente no atributo titular da 
		// classe Conta;
		conta.titular = new Cliente();
		System.out.println(conta.titular);
		
		conta.titular.nome = "Matheus";
		System.out.println(conta.titular.nome);
		
		
	}
}
