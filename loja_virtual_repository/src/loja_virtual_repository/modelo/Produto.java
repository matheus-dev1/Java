package loja_virtual_repository.modelo;

public class Produto {
	
	public Produto(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public Produto(Integer id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	private Integer id;
	private String nome;
	private String descricao;
	
	public String getNome() {
		return this.nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return String.format("O produto eh: %d, %s, %s", this.id, this.nome, this.descricao);
	}
}
