package br.com.alura.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.entidade.AgendamentoEmail;

// Essa é uma forma de usar JPA, sem EJB, ou seja, tudo que é relacionado a infra da minha aplicação, é minha responsabilidade como pode ver.
public class AgendamentoEmailDAOSemEJB {
	
	private EntityManager entityManager;

	public AgendamentoEmailDAOSemEJB() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("agendamento-email-ds");
		this.entityManager = entityManagerFactory.createEntityManager();
	}
	
	public List<AgendamentoEmail> listarEmails() {
		entityManager.getTransaction().begin();
		List<AgendamentoEmail> resultado = this.entityManager.createQuery(
				"SELECT agendamento_email FROM AgendamentoEmail AS agendamento_email",
				AgendamentoEmail.class
				).getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return resultado;
	}
}
