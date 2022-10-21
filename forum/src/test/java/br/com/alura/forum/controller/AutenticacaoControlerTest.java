package br.com.alura.forum.controller;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
// Anotação para testar controller, ele vai carregar apenas as classes da parte MVC @WebMvcTest
// Por não usar o @WebMvcTest eu preciso usar a anotação @AutoConfigureMockMvc para poder injetar 
// a classe "private MockMvc mockMvc"
@AutoConfigureMockMvc
@SpringBootTest
// Usar o perfil de testes
@ActiveProfiles("test")
public class AutenticacaoControlerTest {
	/*
	 * Sempre que vamos fazer uma atualização de uma versão de um framework lib e etc, podemos ter
	 * problemas de compatibilidade, pelo fato de algumas mudanças, na documentação do framework ou
	 * lib por exemplo, eles terão explcando a mudança, e coisas que vocÊ precisar fazer se você
	 * estiver migrando de uma determinada versão.
	 * 
	 * Gerar o build de um projeto spring boot
	 * Botão direito no projeto -> Maven - > Maven Build -> 
	 * Argumentos que normalmente sao passadados: clean package
	 * Ele vai gerar um .jar na pasta target do projeto.
	 * Para rodar este projeto .jar usamos o comando java -jar "nome-do-.jar"
	 * 
	 * Essa é a classe que faz um Mock, que simula uma requisição MVC.
	 * Então não vamos injetar diretamente o Controller, eu vou injetar como se fosse o Postman.
	 * Vamos pensar que esse é o Postman e ele vai disparar a requisição.
	 * E ela vai cair automaticamente no nosso Controller.
	 */
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void deveriaDevolver400CasoDadosDeAutenticacaoEstejamIncorretos() throws Exception {
		// Para testar um controller precisamos criar uma URL, definir o corpo da Requisição.
		URI uri = new URI("/auth");
		// Com o \" nos consguimos colocar mais uma chave sem o Java achar que estamos fechando a string.
		// Representação do Json enviado no corpo da requisição como RequestBody
		String JsonBody = "{\"email\":\"emailInvalido@email.com\", \"senha\": \"senhaInvalida1234\"}";
		
		mockMvc
		// Perform, para performar(executar/chamar) uma requisição.
		// MockMvcRequestBuilders.post(uri) para definir qual o tipo do verbo HTTP e passando a nossa URI
		.perform(MockMvcRequestBuilders
				.post(uri)
				// Conteudo que eu estou enviando na requisição.
				.content(JsonBody)
				.contentType(MediaType.APPLICATION_JSON))
		// Por baixo dos panos do metodo andExpect ele faz um Assert e nos também falamos o que nos 
		// estamos esperando como resposta.
		.andExpect(MockMvcResultMatchers
				// Quero apenas que ele me retorna um status.
				.status()
				// E que sejá 400.
				.is(400));
	}

}
