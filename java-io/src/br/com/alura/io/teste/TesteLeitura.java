package br.com.alura.io.teste;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

// Padroes de Projeto Decorator Java

// Quase todas as classes genericas porem receber referencias das classes filhas.

// O FileInputStream le o nosso arquivo e tranforma em bytes, o InputStreamReader tranforma
// os nossos em bytes em caracteres e o BufferReader junta todos os caracteres em uma 
// linha e realmente ler linha por linha.
public class TesteLeitura {
	// IOException checked 
	public static void main(String[] args) throws IOException {
		// Fluxo de entrada com arquivo de texto.
		// Obs: Java.io eh cheio de excecoes unchecked.
		// Instanciando um objeto do tipo FileInputStream com o construtor que solicita uma String
		// com o nome e extensao do arquivo que eu quero ler.
		InputStream fileInputStream = new FileInputStream("lorem.txt");
		
		// Lê um/os byte/bytes de dados deste fluxo de entrada(arquivo).
		// Stream - Le bits e bytes / Reader - Le caracteres
		System.out.println(fileInputStream.read());
		
		// Pega o int do retorno dos bytes da classe FileInputStream referente ao metodo read()
		Reader inputStreamReader = new InputStreamReader(fileInputStream);
		
		// instanciado um char com 1000 posicoes.
		char[] a = new char[1000];
		
		// Aqui ele me retornar a quantidade de caracteres que o meu arquivo de texto tem e faz
		// alguma coisa que modifica o conteudo do arquivo.
		// Obs: Herda da classe Header.
		// System.out.println(inputStreamReader.read(a));
		
		// Guardar os nosso caracteres ate preencher uma linha.
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		// Lendo a primeira linha do arquivo de texto.
		// System.out.println("Teste BuffedReader: " + bufferedReader.readLine());
		
		// Sempre armazene em uma variavel o retornod e bufferedReader!!!
		String buffedReaderLinha = bufferedReader.readLine();
		
		// Enquanto tiver conteudo no arquivo de texto ele continua lendo.
		while(buffedReaderLinha != null) {
			// Enquanto ha texto, continue lendo.
			// Ele me retorna null quando se acabou o texto.
			System.out.println(buffedReaderLinha);
			// Sempre atribua a um atributo para nao ter erro de nao capturar a linha.
			buffedReaderLinha = bufferedReader.readLine();
		}
		// Fecha o buffer
		bufferedReader.close();
	}

}
