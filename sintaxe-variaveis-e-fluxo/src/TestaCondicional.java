
public class TestaCondicional {
	public static void main(String[] args) {
		// sysout + CTRL + Space | Auto completa o System.out.println()
		System.out.println("Testando condicionais");
		int idade = 10;
		// Ctrl + Shift + F | Ele deixa o nosso codigo identado!
		if (idade >= 18) {
			// Se o nosso if possui apenas uma instricao no seu bloco de execucao, entao ele nao
			// necessariamente precisa das chaves
			System.out.println("Voce tem mais de 18 anos!");
		} else if (idade < 18 && idade > 16){
			// Se eu der "Double Click" em uma view ele maximiza.
			System.out.println("Voce tem menos que 18 anos! mas esta quase la!!!");
		} else {
			System.out.println("Voce esta quase la!!");
		}
	}
}
