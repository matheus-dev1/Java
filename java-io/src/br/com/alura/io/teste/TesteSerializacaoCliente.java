package br.com.alura.io.teste;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TesteSerializacaoCliente {

	public static void main(String[] args) throws IOException {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Matheus");
		cliente.setProfissao("Dev Java");
		cliente.setCpf("344.434.434-22");
		
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(
			new FileOutputStream("objectCliente.bin")
		);
		objectOutputStream.writeObject(cliente);
		objectOutputStream.close();
	}
}
