package br.com.alura.io.teste;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;

public class TestePrintStreamPrintWriter { 
	public static void main(String[] args) throws IOException {
		
		long timerInicio = System.currentTimeMillis();
		
		// FileWriter fileWriter = new FileWriter("lorem2.txt");
		// BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("lorem2.txt"));
		
		// Stream eh algo binario.
		// PrintStream printStream = new PrintStream(new File("lorem2.txt"));
		PrintWriter printWriter = new PrintWriter("lorem2.txt");
		
		// System.out.println(); | .println(); retorna para .out e System exibe no console com o 
		// valor de .out
		printWriter.println("Escrevendo algo println....");
		printWriter.println();
		printWriter.println("Escrevendo algo println2....");
		printWriter.println();
		printWriter.print("Escrevendo algo println3....");
		
		printWriter.close();
		
		long timerFim = System.currentTimeMillis();
		
		System.out.println("Passaram " + (timerFim - timerInicio) + " milissegundos...");
	}
}
