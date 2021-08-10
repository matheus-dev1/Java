package br.com.alura.io.teste;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class TesteLeitura2 {

	public static void main(String[] args) throws Exception {
		// Scanner como outros Leitores/Stream/Reader voce pode definir varios tipos de arquivos
		// e ou maneiras para leitura como o teclado por exemplo.
		Scanner scanner = new Scanner(new File("contas.csv"));
		
		// System.out.println(scanner.findInLine("CC"));
		
		while(scanner.hasNextLine()) {
			// O metodo .split() cria um array de string, separado por um regex/pattern, no nosso 
			// caso uma virgula.
			// String[] arrayLinha = scanner.nextLine().split(",");
			// System.out.println(Arrays.toString(arrayLinha));
			// System.out.println(arrayLinha[2]); // Nomes do arquivo CSV
			
			// O primeiro Scanner eh usado para ler linha a linha, depois dessa leitura eu nao
			// consigo usar novamente, entao para analisar cada linha separadamente eu preciso
			// instanciar outro scanner.
			
			// Como eu vou analisar a linha o Scanner tem um construtor (String source) que seria
			// a fonte o valor propriamente dito que eu gostaria de analisar.
			Scanner scannerLinha = new Scanner(scanner.nextLine());
			// Delimita a linha analisa por uma virgula(pattern/regex).
			scannerLinha.useDelimiter(",");
			// Configurando para usar o padrao americano. Por padrao pega o Eclipse define o padrao
			// referente a linguagem que voce usa ou a regiao em que esta.
			scannerLinha.useLocale(Locale.US);
			
			// Em cada linha eu desejo encontrar estes 5 valores. Cada um separados por uma virgula.
			String conta = scannerLinha.next(); // Tipo String
			int agencia = scannerLinha.nextInt(); // Tipo int
			int numero = scannerLinha.nextInt();
			String nome = scannerLinha.next();
			double saldo = scannerLinha.nextDouble(); // Tipo Double
			
			// Podemos crair o nosso proprio locale, passando o idioma e o pais.
			// O metodo .format() permite a gente criar um padrao, e passar variaveis que a gente
			// gostaria de usar neste padrao.
			// Quando escrevendo em uma string nos temos metodos de formatacao, ou seja,
			// eu consigo definir que naquele ponto eu vou receber um variavel, o tipo dela
			// e algumas regras de regex.
			String linhaFormatada = String.format(
				new Locale("pt", "BR"),
				"Conta: %2s"
				+ "\nAgencia: %04d"
				+ "\nNumero da Conta: %05d"
				+ "\nNome do Cliente: %24s"
				+ "\nSaldo em Conta: R$%010.2f", 
				conta, agencia, numero, nome, saldo
			);
			
			System.out.println("---------------------");
			// System.out.printf("Conta: %s \n", conta);
			// System.out.format("Agencia: %d", agencia);
			// System.out.println("Numero da Conta: " + numero);
			// System.out.println("Nome do Cliente: " + nome);
			// System.out.println("Saldo em Conta: " + saldo);
			
			System.out.println(linhaFormatada);
			
			// Close tem que estar aqui dentro por causa do Escopo.
			scannerLinha.close();
		}
		
		scanner.close();
	}

}
