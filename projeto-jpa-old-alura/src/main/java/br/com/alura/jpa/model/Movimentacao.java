package br.com.alura.jpa.model;

import br.com.alura.jpa.enums.TipoMovimentacao;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NamedQuery(
		name = "mediaMovimentacaoComDiasMes",
		query = "SELECT new br.com.alura.jpa.model.MediaMovimentacaoComDiaMes(AVG(movimentacao.valor), DAY(movimentacao.data), MONTH(movimentacao.data)) FROM Movimentacao AS movimentacao GROUP BY DAY(movimentacao.data), MONTH(movimentacao.data), YEAR(movimentacao.data)"
	)
public class Movimentacao extends Object {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipoMovimentacao = TipoMovimentacao.TIPO_ENTRADA;
	private LocalDateTime data;
	private String descricao;
	private BigDecimal valor;
	@ManyToOne
	private Conta conta;
	// Posso ter uma lista de categorias em uma movimentação/transação.
	// O hibernate vai criar uma tabela de relacionamento com o id da movimentação e o
	// id da categorias, sendo que minha movimentação pode ter varias categorias.
	@ManyToMany
	private List<Categoria> categorias;

	public Movimentacao() {
		super();
	}

	public Movimentacao(
			BigDecimal valor,
			TipoMovimentacao tipoMovimentacao,
			LocalDateTime data,
			String descricao,
			Conta conta,
			List<Categoria> categorias
		) {
			this.valor = valor;
			this.tipoMovimentacao = tipoMovimentacao;
			this.data = data;
			this.descricao = descricao;
			this.conta = conta;
			this.categorias = categorias;
	}

	public Movimentacao(
			BigDecimal valor,
			TipoMovimentacao tipoMovimentacao,
			LocalDateTime data,
			String descricao,
			Conta conta
	) {
		this.valor = valor;
		this.tipoMovimentacao = tipoMovimentacao;
		this.data = data;
		this.descricao = descricao;
		this.conta = conta;
	}

	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}
	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public String toString() {
		return "Movimentacao{" +
				"Id=" + Id +
				", tipoMovimentacao=" + tipoMovimentacao +
				", data=" + data +
				", descricao='" + descricao + '\'' +
				", valor=" + valor +
				", conta=" + conta +
				", categorias=" + categorias +
				'}';
	}
}
