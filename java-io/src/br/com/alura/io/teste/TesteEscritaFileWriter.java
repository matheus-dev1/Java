package br.com.alura.io.teste;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

public class TesteEscritaFileWriter { 
	public static void main(String[] args) throws IOException {

		// FileOutputStream fileOutputStream = new FileOutputStream("lorem2.txt");
		// OutputStreamWriter outputStreamReader = new OutputStreamWriter(fileOutputStream);
		// BufferedWriter bufferedWriter = new BufferedWriter(outputStreamReader);
		
		// herda de OutputStreamWriter.
		FileWriter fileWriter = new FileWriter("lorem2.txt");
		// BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("lorem2.txt"));
		fileWriter.write("Escrevendo algo....");
		// Pula uma linha, e isso independe de SO.
		fileWriter.write(System.lineSeparator());
		fileWriter.write("Escrevendo algo2....");
		fileWriter.close();
	}
}
