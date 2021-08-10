package br.com.alura.io.teste;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class TesteArquivosDePropriedades {

	public static void main(String[] args) throws IOException {
		// Arquivos de propriedades
		Properties props = new Properties();
		props.setProperty("login", "alura");
		props.setProperty("senha", "alurapass");
		props.setProperty("endereco", "www.alura.com.br");
		
		// Escrever em arquivos de propriedades
		props.store(new FileWriter("conf.properties"), "Arquivo de configuracoes");
		
		props.load(new FileReader("conf.properties"));
		
		String login = props.getProperty("login");
		String senha = props.getProperty("senha");
		String endereco = props.getProperty("endereco");
		
		System.out.format("Login: %s \nSenha: %s \nEndereco: %s", login, senha, endereco);
	}

}
