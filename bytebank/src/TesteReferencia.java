
public class TesteReferencia {
	public static void main(String[] args) {
		// Esta variavel primeiraConta nao eh um objeto "Conta", ela na realidade uma referencia deste
		// objeto "Conta".
		
		// Sempre que nos queremos armazenar a referencia da criacao de um objeto, o primeiro nome da 
		// variavel que vai armazenar a referencia tem que ter o nome igual ao da Classe.
		Conta primeiraConta = new Conta();
		primeiraConta.saldo = 200;
		
		System.out.println("Saldo da primeira conta: "+ primeiraConta.saldo);
		
		// Estou criando uma variavel do tipo "Objeto Conta" e estou passando a referencia da variavel
		// primeiraConta em que esta armazenado a referencia a primeira instancia.
		Conta segundaConta = primeiraConta;
		
		System.out.println("Saldo da segunda conta: " + segundaConta.saldo);
		
		segundaConta.saldo += 100;
		
		System.out.println("Saldo da primeira conta: "+ primeiraConta.saldo);
		
		if(primeiraConta == segundaConta) {
			System.out.println("Sao a mesma conta!!!");
		}
		
		System.out.println(primeiraConta);
		System.out.println(segundaConta);
	}
}