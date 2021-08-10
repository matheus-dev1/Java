package br.com.bytebank.banco.teste.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteSerializacaoConta {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Cliente cliente = new Cliente();
		cliente.setNome("Matheus");
		cliente.setProfissao("Dev Java");
		cliente.setCpf("344.434.434-22");
		
		ContaCorrente contaCorrente = new ContaCorrente(343, 3434);
		contaCorrente.setTitular(cliente);
		contaCorrente.deposita(434);
		
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(
			new FileOutputStream("contaCorrente.bin")
		);
		objectOutputStream.writeObject(contaCorrente);
		objectOutputStream.close();
	}

}
