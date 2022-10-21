package br.com.alura.jpa.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.model.Conta;

public class Estados {

	public static void main(String[] args) {
		/* O estado Transient para designar este tipo de objeto desvinculado. Sua característica é uma conta
		 * que existe na memória, possui informações e não tem Id nenhum, mas pode se tornar Managed futuramente.
		 */
		Conta conta = new Conta(1234, 4, "Joaquim Barbosa", 8.000);
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		// Trasient -> Managed
		entityManager.persist(conta);
		
		// Managed -> Removed
		entityManager.remove(conta);
		
		entityManager.getTransaction().commit();
		
		System.out.println("id: " + conta.getId());
	}

}
