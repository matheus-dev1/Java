package br.com.alura.cliente;

import java.io.IOException;

// A partir desta lib, nos conseguimos fazer requisicoes web, mesmo nao sendo um projeto Web.
import org.apache.http.client.fluent.Request;
import org.apache.http.client.HttpResponseException;

public class ClienteWebService {

	public static void main(String[] args) throws Exception, IOException, HttpResponseException {
		// Fazer um Request
		String conteudo = Request
				// Com o metodo POST, para este endpoint
			    .Post("http://localhost:8080/gerenciador/empresas")
			    // Definindo um cabecalho para que o retorno seja apenas em JSON
			    // "Eu como cliente aceito qual formato?"
			    .addHeader("Accept", "application/json")
			    // Executa a requisicao
			    .execute()
			    // Retorna o conteudo
			    .returnContent()
			    // Como String
			    .asString();

			// Exibe o conteudo do retorno do endpoint
			System.out.println(conteudo);
	}

}
