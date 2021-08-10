
public class TesteCondicional2 {
	public static void main(String[] args) {
		int idade = 18;
		String id = "asd2334c2ase23";
		String nome = "Romulo";
		boolean tenente = true;
		// Eu posso criar um teste logico e armazenar seu resultado em uma variavel.
		boolean legal = tenente == true;
		// Ou voce tem 18 anos ou seu id conferre do solicitado e tenha o nome igual a romulo.
		// tenente e legal sao variaveis do tipo boleado que nao necessariamente nos precisamos testar
		// se ela eh verdadeira, ela se auto testa, se tenente e legal for verdadeiro execute o bloco deste if.
		if (idade == 18 || id == "asd2334c2ase23" && nome == "Romulo" && tenente && legal) {
			System.out.println("Tudo certo, pode entrar!!!");
		} else {
			System.out.println("Voce nao pode entrar, ");
		}
	}
}
