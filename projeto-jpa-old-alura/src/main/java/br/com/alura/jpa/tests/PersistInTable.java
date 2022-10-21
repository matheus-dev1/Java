package br.com.alura.jpa.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.model.Conta;

public class PersistInTable {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Conta conta = new Conta(1234, 4, "Renato Yuzo", 8.000);
		
		entityManager.getTransaction().begin();
		/* A transa��o � um mecanismo para manter a consist�ncia das altera��es de estado no banco, visto que todas 
		 * as opera��es precisam ser executadas com sucesso, para que a transa��o seja confirmada. */
		entityManager.persist(conta);
		
		conta.setSaldo(1.00000);
		
		entityManager.getTransaction().commit();
		
		// Depois que voc� da um close, a sua entidade fica no estado Detached, ou seja, sua entidade n�o 
		// tem mais sincroniza��o automatica com o banco de dados.
		entityManager.close();
		
		// Em JPA, nos temos que pensar muito em transi��o de ESTADOS
		EntityManager entityManager2 = entityManagerFactory.createEntityManager();
		
		conta.setSaldo(1000.00);
		
		entityManager2.getTransaction().begin();
		
		// Alterado o estado para managed
		entityManager2.merge(conta);
		
		entityManager2.getTransaction().commit();
	}

}
