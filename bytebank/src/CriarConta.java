public class CriarConta {
	public static void main(String[] args) {
		// Aqui eu ja estou fazendo a instancia da Classe(molde) Conta, porem eu nao estou armazenando a 
		// referencia em nenhuma variavel.
		// new Conta()
		System.out.println(new Conta());
		// Observe que cada instacia me da o nome do tipo do Objeto @ um numero com letras e repare que tambem
		// a cada instancia temos numeros depois do @ diferentes.
		// Isso eh a referencia da instancia este objeto.
		System.out.println(new Conta().saldo = 200);
		
		// Uma variavel NUNCA recebe um objeto, ele apenas recebe uma referencia deste objeto/instancia
		Conta primeiraConta = new Conta();
		primeiraConta.saldo = 350.99;
		
		System.out.println(primeiraConta.saldo);
		
		Conta segundaConta = new Conta();
		segundaConta.saldo = 200;
		
		if(primeiraConta == segundaConta) {
			System.out.println("Sao a mesma conta!!!");
		} else {
			System.out.println("Contas diferentes");
		}
	}
}
