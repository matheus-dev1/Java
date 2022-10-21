package br.com.algaworks.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.algaworks.consumer.model.ProdutoComPreco;
import reactor.core.publisher.Mono;

@Service
public class PrecoProdutoService {

	// Injetando os WebClients instanciandos.
	@Autowired
	private WebClient webClientProdutos;
	
	@Autowired
	private WebClient webClientPrecos;
	
	// Em paralelo quer dizer que eles são executados cada um em paralelo em uma unica função, ou seja, 
	// o .zip(), nos pegamos os dois monos e aguardamos a requisição responder. No final é mais rapido.
	public ProdutoComPreco obterPorCodigoParalelo(Long codigoProduto) {
		// O objeto Mono nos da uma serie de metodos que permite tratar o retorno quando a requisição 
		// FINALIZAR, sem bloquear o método no caso o método "obterPorCodigoParalelo". 
		Mono<ProdutoComPreco> monoProduto = this.webClientProdutos
			// Metodo que eu vou usar para fazer está requisição.
			.method(HttpMethod.GET)
			// 1. URI da qual eu vou concatenar com a BaseUrl, para ter toda a URL para fazer a requisição.
			// 2. E o segundo parametro é o valor que vai ser colocado em "{codigo}" para fazer a requisição.
			.uri("/produtos/{codigo}", codigoProduto)
			// De fato disparar a requisição.
			.retrieve()
			/* 
			 * Como a requisição a "/produtos/{codigo}" vai me retonar um codigo e um nome, eles cosiguirão
			 * ser atribuidos ao model "ProdutoComPreco" por ter os respectivos nomes.
			 * Ele só não vai atribuir nada ao "preco" porque na requisição GET não vai ter este valor.
			 * 
			 * O retorno deste builder será um objeto do Tipo Mono<ProdutoComPreco>.
			 * */
			.bodyToMono(ProdutoComPreco.class);
	
		Mono<ProdutoComPreco> monoPreco = this.webClientPrecos
			.method(HttpMethod.GET)
			.uri("/precos/{codigo}", codigoProduto)
			.retrieve()
			.bodyToMono(ProdutoComPreco.class);
		
		// Faz mais de fato mais uma requisição simultanea.
		ProdutoComPreco produtoComPreco = Mono
				// Ele recebe todos os monos do método, no caso monoProduto e monoPreco e juntar
				// as respostas destas requisições.
				.zip(monoProduto, monoPreco)
				// O .map() tem acesso a todas as respostas do zip que junto tudo em um valor só, no caso
				// a variavel "tuple".
				.map(tuple -> {
						tuple
						.getT1() // monoProduto
						//.getT2() // monoPreco
						// Aqui eu vou setar o valor do atributo "preco" o model ProdutoComPreco com o
						// retorno de getT2 que é o monoPreco que de fato me vai na api de Preco e
						// retorna o preco do produto de getT1.
						.setPreco(tuple.getT2().getPreco());
						
						return tuple.getT1();
					})
				// Depois de executar o codigo acima, ele bloqueia ou seja, espera o retorno
				// da requisição para continuar o codigo abaixo.
				.block();
		
		return produtoComPreco;
	}
	
	// Aqui ele vai executar as duas requisições porem, ele vai dar block primeiro no modoProduto esperar ele
	// responder e depois dar block no monoPreco e esperar ele responder causando uma lentidão na requisição.
	public ProdutoComPreco obterPorCodigoSincrono(Long codigoProduto) {
		Mono<ProdutoComPreco> monoProduto = this.webClientProdutos
			.method(HttpMethod.GET)
			.uri("/produtos/{codigo}", codigoProduto)
			.retrieve()
			.bodyToMono(ProdutoComPreco.class);
	
		Mono<ProdutoComPreco> monoPreco = this.webClientPrecos
			.method(HttpMethod.GET)
			.uri("/precos/{codigo}", codigoProduto)
			.retrieve()
			.bodyToMono(ProdutoComPreco.class);
		
		// O metodo .subscribe() vai ficar escutando a requisição até ser retornado.
		monoProduto.subscribe(monoProdutoCheck -> {
			System.out.println("monoProduto Finalizado!");
		});
		
		monoPreco.subscribe(monoPrecoCheck -> {
			System.out.println("monoPreco Finalizado!");
		});
		
		System.out.println("Finalizou de mentira!");
		
		// O metodo .block() é um metodo que espera o retono da requisiçao de obterPorCodigoParalelo 
		// para constinuar a executar os codigos, e o mesmo vale para o monoPreco.block();
		// Além de retornar a resposta do objeto em si no formato JSON(como a gente configurou)
		ProdutoComPreco produto = monoProduto.block();
		ProdutoComPreco preco = monoPreco.block();
		produto.setPreco(preco.getPreco());

		return produto;
	}
	
	public ProdutoComPreco criar(ProdutoComPreco produtoComPreco) {
		Mono<ProdutoComPreco> monoProduto = this.webClientProdutos
			.post() // Ou .method(HttpMethod.POST)
			.uri("/produtos")
			// Aqui ele esperea receber um qualquer classe ou seja um Generic, então nos passamos
			// um instanci do nosso model com valores preenchidos.
			.body(BodyInserters.fromValue(produtoComPreco))
			.retrieve()
			.bodyToMono(ProdutoComPreco.class);
		
		 ProdutoComPreco produto = monoProduto.block();

		return produto;
	}
}
