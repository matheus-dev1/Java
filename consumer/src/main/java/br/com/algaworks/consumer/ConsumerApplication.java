package br.com.algaworks.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ConsumerApplication {
	/*
	 * Temos 3 maneiras de obter uma instancia do WebClient(Interface).
	 * 1.   
	 * Como neste exemplo eu criei uma Factory do EntityManager da api do JPA, para fazer persistencia
	 * de dados em BD.
	 * private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = 
	 * Persistence.createEntityManagerFactory("lolja"); 
	 * 
	 * WebClient webClient = WebClient.create()
	 * 
	 * 2.
	 * Neste caso usando o .create() com o parametro do tipo BaseUrl, faz com que todas as requisições
	 * do objeto "webClient", // // tenham como base da sua URL, este base url definido no metodo .create()
	 * Se eu fizer uma requisição utilizando este objeto e passar "/produtos", ele vai concatenar com o baseURL
	 * 
	 * WebClient webClient = WebClient.create("http://localhost:8080")
	 * 
	 * 3.
	 * Aqui nos fazemos a criação do objeto WebClient, com o padrão builder, que vai recebendo metodos encadeados
	 * 
	 * WebClient webClient = WebClient.builder()
	 * 
	 * Obs: Não é interessante você deixar a criação destes metodo na "Service" porque eu posso fazer
	 * requisições pra determinada BaseURL, em outra parte da aplicação.
	 * 
	 * A diferença do WebClient para o RestTemplate é que ele não é bloquante, ou seja, ao chamar um metodo
	 * que vai de fato fazer a requisição, ele não vai esperar a requisição retornar uma resposta para
	 * executar outras linhas de codigo.
	 */
	
	// Bean para conseguir exportar este metodo para outro arquivo.
	@Bean
	public WebClient webClientProdutos(WebClient.Builder builder) {
		// Este builder vai me retornar uma instancia de WebClient já montada e configurada.
		return builder
			// URL base para todas as requisições com este objeto.
			.baseUrl("http://localhost:8081")
			// Headers definindo o formato JSON.
			.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
			// Efetuando o build
			.build();
	}
	
	@Bean
	public WebClient webClientPrecos(WebClient.Builder builder) {
		return builder
			.baseUrl("http://localhost:8082")
			.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
			.build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
}
