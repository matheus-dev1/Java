package br.com.alura.io.teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;
import java.security.DigestInputStream;

public class TesteCopiarArquivo {
	public static void main(String[] args) throws IOException {
		// System.in.println(); È um metodo que eu posso passar antecipadamente para ele mandar
		// para System.out;
		// O System.out faz a mesma coisa, com uma diferenca que eu defino o valor de System.in
		// Na execucao, ele me abre o console para digiar o que eu quiser sem restricao.
		// E tudo vai para System.out quando System.in eh finalizado.
		System.out.print("Digite algo: ");
		InputStream fileInputStream = System.in; // new FileInputStream("lorem.txt");
		Reader inputStreamReader = new InputStreamReader(fileInputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		OutputStream fileOutputStream = System.out; // new FileOutputStream("lorem2.txt");
		Writer outputStreamReader = new OutputStreamWriter(fileOutputStream);
		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamReader);
		
		String buffedReaderLinha = bufferedReader.readLine();
		
		// O bufferReader nao pode estar vazio nem com o valor de null.
		while(buffedReaderLinha != null && buffedReaderLinha.isEmpty() != true) {
			System.out.println("Digite algo: ");
			bufferedWriter.write(buffedReaderLinha);
			bufferedWriter.newLine();
			// Basicamente ele escreve no output forcadamente o conteudo do buffer.
			bufferedWriter.flush();
			buffedReaderLinha = bufferedReader.readLine();
		}
		
		bufferedReader.close();
		bufferedWriter.close();
	}

}
