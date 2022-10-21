package br.com.alura.jpa.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.model.Conta;

public class AlteraContaSaldoContaUm {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		// Ele fica no estádo Managed, ou seja, as nossas entidades tem sincronização automática com o banco de dados.
		Conta contaFind = entityManager.find(Conta.class, 2L);
		
		entityManager.getTransaction().begin();
		
		contaFind.setSaldo(100.0);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}

}
