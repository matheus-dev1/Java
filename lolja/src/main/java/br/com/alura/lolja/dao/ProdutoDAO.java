package br.com.alura.lolja.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.alura.lolja.modelo.Produto;

public class ProdutoDAO {
	private EntityManager entityManager;
	
	public ProdutoDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public void cadastrar(Produto produto) {
		this.entityManager.persist(produto);
	}
	
	public Produto buscarPorId(Long id) {
		// Entidade.class e id
		return entityManager.find(Produto.class, id);
	}
	
	public List<Produto> buscarTodos(){
		// JPQL - Java Persistence Query Language. - Parece um SQL orientado a objetos.
		// Em vez que colocaro * e dizer para retornar tudo, eu retorno TODA a entidade PRODUTO colocando
		// o Alias da entidade e o FROM tem que ser igual ao nome da ENTIDADE, alem de colocar um alias
		// para ela, para conseguir referenciar.
		String jpql = "SELECT produto FROM Produto AS produto";
		// Como segundo parametro eu defino que a lista vai me retonar uma lista de produtos.
		// entityManager.createQuery(jpql) - Apenas monta a query
		// .getResultList(); - dispara no banco de dados.
		return entityManager.createQuery(jpql, Produto.class).getResultList();
	}
	
	public List<Produto> buscarPorNome(String nome){
		// named parameter - No Where eu coloco qu eu quero buscar pelo campo nome e que seja igual
		// ao parametro nome para definir um prametro colocamos :"nome_do_parametro" e tambem no
		// createquery um .setparameter com o nome que foi colocado e o nome do parametro recebido no metodo
		// Eu posso usar tambem ?1, 2?, um parametro posicional.
		String jpql = "SELECT produto FROM Produto AS produto WHERE produto.nome = :nome";
		return entityManager.createQuery(jpql, Produto.class).setParameter("nome", nome).getResultList();
	}
	
	public List<Produto> buscarPorNomeDaCategoria(String nome){
		
		// Como o JPA sabe os relacionamentos existentes na sua aplicacao, ele sabe que se voce colocar
		// produto.categoria.nome eu estou buscando o atributo nome do atributo categoria que na realidade
		// eh uma tabela/entidad e ele sabe disso entao ele vai criar um join.
		// String jpql = "SELECT produto FROM Produto AS produto WHERE produto.categoria.nome = :nome";
		
		// Usando Named Query
		return entityManager.createNamedQuery("Produto.produtosPorCategoria", Produto.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
	public BigDecimal buscarPrecoDoProdutoComNome(String nome){
		// Aqui eu quero retornar em vez de todos os produtos, eu retorno apenas o preco do produto
		// e aqui eu tenho que alterar o tipo da class, e o metodo do tipo do retorno, no caso getSingleResult();
		String jpql = "SELECT produto.preco FROM Produto AS produto WHERE produto.nome = :nome";
		return entityManager.createQuery(jpql, BigDecimal.class)
					.setParameter("nome", nome)
					.getSingleResult();
	}
	
	// Busca por parametro opcionais/dinamicos.
	public List<Produto> nuscarPorParametros(String nome, BigDecimal preco, LocalDate dataCadastro) {
		String jpql = "SELECT produto FROM Produto AS produto WHERE 1 = 1";
		if(nome != null && !nome.trim().isEmpty()) {
			jpql += "AND produto.nome = :nome";
		}
		if(preco != null) {
			jpql += "AND produto.preco = :preco";
		}
		if(dataCadastro != null) {
			jpql += "AND produto.dataCadastro = :dataCadastro";
		}
		
		TypedQuery<Produto> typedQuery = entityManager.createQuery(jpql, Produto.class);
		
		if(nome != null && !nome.trim().isEmpty()) {
			typedQuery.setParameter("nome", nome);
		}
		if(preco != null) {
			typedQuery.setParameter("preco", preco);
		}
		if(dataCadastro != null) {
			typedQuery.setParameter("dataCadastro", dataCadastro);
		}
		
		return typedQuery.getResultList();
	}
	
	public List<Produto> buscarPorParametrosComCriteria(String nome, BigDecimal preco, LocalDate dataCadastro) {
		// Criando o objeto criteria.
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		// Criando Criteria Query.
		CriteriaQuery<Produto> criteriaQuery = criteriaBuilder.createQuery(Produto.class);
		// FROM Produto AS produto
		Root<Produto> RootFrom = criteriaQuery.from(Produto.class);
		// Se o SELECT for igual ao FROM nao precisa passar.
		// criteriaQuery.select(Produto.class);
		
		// AND
		Predicate predicateFiltros = criteriaBuilder.and();
		if (nome != null && !nome.trim().isEmpty()) {
			// Se o nome eh igual ao nome do parametro
			predicateFiltros = criteriaBuilder.and(predicateFiltros, criteriaBuilder.equal(RootFrom.get("nome"), nome));
		}
		if(preco != null) {
			// Se o preco eh iguala ao preco do paraemtro
			predicateFiltros = criteriaBuilder.and(predicateFiltros, criteriaBuilder.equal(RootFrom.get("preco"), preco));
		}
		if(dataCadastro != null) {
			// se a data do cadastro eh igual a data do cadastro
			predicateFiltros = criteriaBuilder.and(predicateFiltros, criteriaBuilder.equal(RootFrom.get("dataCadastro"), dataCadastro));
		}
		
		criteriaQuery.where(predicateFiltros);
		
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
}
