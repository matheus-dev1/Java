package br.com.alura.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import br.com.alura.entidade.AgendamentoEmail;

@Stateless
//O controle das transações(begin, commit e close por exemplo) são responsabilidades do desenvolvedor
//@TransactionManagement(TransactionManagementType.BEAN)
public class AgendamentoEmailDAO {

	// Expressa uma dependência em um EntityManager gerenciado por contêiner e seu contexto de persistência associado.
	// Isso tira toda a responsabilidade de criar um EntityManagerFactory, iniciar, commitar e fechar uma transação.
	@PersistenceContext
	private EntityManager entityManager;
	
	/*@Inject
	private UserTransaction userTransaction;*/
	
	public List<AgendamentoEmail> listarEmails() { 
		return this.entityManager.createQuery(
				"SELECT agendamento_email FROM AgendamentoEmail AS agendamento_email",
				AgendamentoEmail.class
				).getResultList();
	}
	
	public void inserirEmail(AgendamentoEmail agendamentoEmail) {
		this.entityManager.persist(agendamentoEmail);
	}
	
	public List<AgendamentoEmail> listarPorEmailNaoAgendado() {
		return this.entityManager.createQuery(
				"SELECT agendamento_email FROM AgendamentoEmail AS agendamento_email WHERE agendamento_email.agendado = false",
				AgendamentoEmail.class).getResultList();
	}
	
	public void alterarEmailAgendadoTrue(AgendamentoEmail agendamentoEmail) {
		this.entityManager.merge(agendamentoEmail);
	}
	
	/*public void alterarEmailAgendadoTrueBean(AgendamentoEmail agendamentoEmail) {
		try {
			userTransaction.begin();
			this.entityManager.merge(agendamentoEmail);
			userTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
}
