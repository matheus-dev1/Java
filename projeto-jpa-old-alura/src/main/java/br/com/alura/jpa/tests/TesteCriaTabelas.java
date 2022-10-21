package br.com.alura.jpa.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteCriaTabelas {
	
	public static void main(String[] args) {
		// Criando uma fabrica de EntityManagers, o "conta" � do nosso arquivo persistence <persistence-unit />
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		// Cria��o do entityManager
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		// Fechamento da fabrica.
		entityManager.close();
	}

}
