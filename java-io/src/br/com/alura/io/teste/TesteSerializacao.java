package br.com.alura.io.teste;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TesteSerializacao {

	public static void main(String[] args) throws IOException {
		// ----- String nome = "Matheus de Olivera Silva";

		// O objeto ObjectOutputStream serve para pegar um arquivo binario no caso o object.bin
		// e poder fazer manipulacoes com ele.
		// Objeto FileOutputStream passando como parametro um objeto em formato de String criar um
		// arquivo desta forma, e a referencia da criacao deste arquivo tem que estar no parametro
		/// do construtor de FileOutputStream.
		// ----- ObjectOutputStream objectOutputStrem = new ObjectOutputStream(new FileOutputStream("object.bin"));
		
		// Escrever o objeto no arquivo binarios, um objeto por exemplo por ser a instancia de 
		// uma classe criada por nos mesmo.
		// ----- objectOutputStrem.writeObject(nome);
		// ----- objectOutputStrem.close();
	}

}
