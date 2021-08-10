package br.com.alura.lolja.dao;

import javax.persistence.EntityManager;

import br.com.alura.lolja.modelo.Categoria;

public class CategoriaDAO {
	private EntityManager entityManager;
	
	public CategoriaDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public void cadastrar(Categoria categoria) {
		this.entityManager.persist(categoria);
	}
	
	public void atualizar(Categoria categoria) {
		this.entityManager.merge(categoria);
	}
	
	public void remover(Categoria categoria) {
		categoria = this.entityManager.merge(categoria);
		this.entityManager.remove(categoria);
	}
}
