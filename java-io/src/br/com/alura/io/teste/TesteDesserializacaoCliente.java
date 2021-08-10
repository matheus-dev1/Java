package br.com.alura.io.teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TesteDesserializacaoCliente {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("objectCliente.bin"));
		Cliente cliente = (Cliente) objectInputStream.readObject();
		System.out.println(cliente.getCpf());
		System.out.println(cliente.getProfissao());
		System.out.println(cliente.getNome());
		objectInputStream.close();
	}
}
