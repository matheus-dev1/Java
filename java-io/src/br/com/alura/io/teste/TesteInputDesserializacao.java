package br.com.alura.io.teste;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TesteInputDesserializacao {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// A transformação do objeto em um fluxo binário é chamada de serialização.
		// A transformação de um fluxo binário em um objeto é chamada de desserialização.
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.bin"));
		System.out.println(objectInputStream.readObject());
		objectInputStream.close();
	}
}
