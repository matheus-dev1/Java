package br.com.alura.io.teste;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TesteInputDesserializacao {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// A transforma��o do objeto em um fluxo bin�rio � chamada de serializa��o.
		// A transforma��o de um fluxo bin�rio em um objeto � chamada de desserializa��o.
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.bin"));
		System.out.println(objectInputStream.readObject());
		objectInputStream.close();
	}
}
