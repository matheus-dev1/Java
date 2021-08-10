package br.com.alura.lolja.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.lolja.modelo.Cliente;

public class ClienteDAO {
	private EntityManager entityManager;
	
	public ClienteDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public void cadastrar(Cliente cliente) {
		this.entityManager.persist(cliente);
	}
	
	public Cliente buscarPorId(Long id) {
		// Entidade.class e id
		return entityManager.find(Cliente.class, id);
	}
}
