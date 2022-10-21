package br.com.alura.mvc.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})	
@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeDoProduto;
	private BigDecimal valorNegociado;
	private LocalDate localDaEntrega;
	private String urlProduto;
	private String urlImagem;
	private String descricao;
	@Enumerated(EnumType.STRING)
	private StatusPedido statusPedido;
	@ManyToOne(fetch = FetchType.LAZY)
	// Ignora a seriaização da classe do atributo User que é uma classe.
	@JsonIgnore
	private User user;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Oferta> ofertas;
	
	public Pedido() {
		super();
	}

	public Pedido(String nomeDoProduto, BigDecimal valorNegociado, LocalDate localDaEntrega, String urlProduto,
			String urlImagem, String descricao) {
		super();
		this.nomeDoProduto = nomeDoProduto;
		this.valorNegociado = valorNegociado;
		this.localDaEntrega = localDaEntrega;
		this.urlProduto = urlProduto;
		this.urlImagem = urlImagem;
		this.descricao = descricao;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDoProduto() {
		return nomeDoProduto;
	}
	public void setNomeDoProduto(String nomeDoProduto) {
		this.nomeDoProduto = nomeDoProduto;
	}
	
	public BigDecimal getValorNegociado() {
		return valorNegociado;
	}
	public void setValorNegociado(BigDecimal valorNegociado) {
		this.valorNegociado = valorNegociado;
	}
	
	public LocalDate getLocalDaEntrega() {
		return localDaEntrega;
	}
	public void setLocalDaEntrega(LocalDate localDaEntrega) {
		this.localDaEntrega = localDaEntrega;
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
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}
	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	public List<Oferta> getOfertas() {
		return ofertas;
	}
	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}

	// Tive que tirar estes campos por que se não eles iriam vir ja retorno do verbo get da requisição rest.
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
