package br.com.alura.mvc.mudi.dto;

import javax.validation.constraints.NotBlank;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

// Classe serve apenas para tranerencia de dados, tanto para receber do front como para armazenar e visualizar.
public class RequisicaoNovoPedidoDTO {
	// Isso são Validações Bean, ou seja, quando eu instanciar está classe ela será observada e a sua anotação deverá ser
	// atendida, neste caso eu não quero que o valor dese atributo seja em branco.
	@NotBlank
	// Os nomes dos atributos tem que ser os mesmos do enviado pelo frontend
	private String nomeProduto;
	@NotBlank
	private String urlProduto;
	@NotBlank
	private String urlImagem;
	private String descricao;
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	public String getUrlProduto() {
		return urlProduto;
	}
	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	
	public String getDescriao() {
		return descricao;
	}
	public void setDescriao(String descriao) {
		this.descricao = descriao;
	}
	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setNomeDoProduto(nomeProduto);
		pedido.setUrlProduto(urlProduto);
		pedido.setUrlImagem(urlImagem);
		pedido.setDescricao(descricao);
		pedido.setStatusPedido(StatusPedido.AGUARDANDO);
		return pedido;
	}
}
