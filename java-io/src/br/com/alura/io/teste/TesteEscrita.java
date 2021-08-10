package br.com.alura.io.teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

public class TesteEscrita { 
	public static void main(String[] args) throws IOException {
		// Escreve em bytes no arquivo.
		FileOutputStream fileOutputStream = new FileOutputStream("lorem2.txt");
		// Tranforma os bytes em texto.
		OutputStreamWriter outputStreamReader = new OutputStreamWriter(fileOutputStream);
		// Escreve texto propriamente dito no arquivo.
		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamReader);
		
		bufferedWriter.write("Escrevrendo...");
		bufferedWriter.close();
	}
}
