// A classe Scanner serve para fazer a entrada de dados no Console.
// Obs: Por ser um classe ela precisa ser instanciada.

// Scanner scanner = new Scanner(System.in);
// Obs: System.in eh basicameneto nosso console.

// int numeroInteiro = scanner.nextInt();
// Primeiro o tipo da variavel e depois o nome que vai receber a entrada de dados do tipo inteiro

// byte numeroByte = scanner.nextByte();
// long numeroLong = scanner.nextLong();
// boolean booleano = scanner.nextBoolean();
// float numeroFloat = scanner.nextFloat();
// double numeroDouble = scanner.nextDouble();

import java.util.Scanner;

public class Eleitores {
	public static void main(String[] args) {
		// Instanciando o Scanner no console
		Scanner console = new Scanner(System.in);

		// Declarando todas as variaveis do tipo inteiro porque Java eh uma linguagem nao tipada.
		int QtEleitores, vtBrancos, vtNulos, vtValidos = 0;

		// Exibindo esta mensagem no console.
		System.out.print("Quantidade de Eleitores: ");

		// O try e basicamente eu vou tentar executar o que tem dentro do bloco try, se nao ocorrer erro ele nao passa pelo catch.
		try {
			// Pegando os dados do console e armazenando na variavel.
            QtEleitores = console.nextInt();
		// O catch e se o try der erro, ele vai capturar o erro e armazenar na variavel error.
        } catch(Exception e) {
			QtEleitores = 1;
            System.out.print("O valor informado não é um número! Error: " + e);
        }
		
		System.out.print("Quantidade de votos Brancos: ");
		vtBrancos = console.nextInt();
		
		System.out.print("Quantidade de votos Nulos: ");
		vtNulos = console.nextInt();
		
		System.out.print("Quantidade de votos Validos: ");
		vtValidos = console.nextInt();
		
		// Nos fazemos uma multiplicacao vezes 100 dos votos em branco e dividimos pela quantidade de eleitores.
		vtBrancos = (vtBrancos * 100) / QtEleitores;
		vtNulos = (vtNulos * 100) / QtEleitores;
		vtValidos = (vtValidos * 100) / QtEleitores;
		
		// Exibindo um texto com o valor das variaveis.
		System.out.println("Votos Brancos: " + vtBrancos + "%");
		System.out.println("Votos Nulos: " + vtNulos + "%");
		System.out.println("Votos Validos: " + vtValidos + "%");
	}
}
