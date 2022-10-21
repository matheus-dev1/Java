package br.com.alura.job;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;

import br.com.alura.entidade.AgendamentoEmail;
import br.com.alura.servico.AgendamentoEmailServico;

// Em programação, um JOB, normalmente é caracterizado pela execução periodica que alguma coisa, como por exemplo o envio de emails.
@Singleton
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AgendamentoEmailJob {
	
	/* Singleton
	private static AgendamentoEmailJob agendamentoEmailJobUniqueInstance;

	private AgendamentoEmailJob() { }

	public static synchronized AgendamentoEmailJob getInstance() {
		if (agendamentoEmailJobUniqueInstance == null)
			agendamentoEmailJobUniqueInstance = new AgendamentoEmailJob();

		return agendamentoEmailJobUniqueInstance;
	}*/
	
	@Inject
	private AgendamentoEmailServico agendamentoEmailServico;
	
	// Criando uma fabrica de JMS
	@Inject
	@JMSConnectionFactory("java:jboss/DefaultJMSConnectionFactory")
	private JMSContext jmsContext;
	
	// Este campo é para definir um JNDI
	@Resource(mappedName = "java:/jms/queue/EmailQueue")
	private Queue queue;
	
	public AgendamentoEmailJob() { }
	
	/*A anotação Schedule, vai executar este metodo de tempos em tempos,
	 * em quando o servidor estiver ligado, no nosso caso,
	 * ele vai executar a cada 10 segundos. */
	@Schedule(hour = "*", minute = "*", second = "*/10")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void enviarEmailAgendado() {
		List<AgendamentoEmail> listAgendamentoEmail = this.agendamentoEmailServico.listarPorEmailNaoAgendado();
		listAgendamentoEmail.forEach(emailNaoAgendado -> {
			// Criando um producer
			JMSProducer jmsProducer = jmsContext.createProducer();
			// Temos que enviar um objeto do tipo Destination, e como Queue herda de destination, nos vamos usar ele
			// No segundo parametro temos que enviar um body que é o nosso DTO, porém, ele tem que implementar a interface Serializable.
			jmsProducer.send(queue, emailNaoAgendado);
			//agendamentoEmailServico.enviarEmail(emailNaoAgendado);
			// Alterar para status agendado
			agendamentoEmailServico.alterarEmailAgendadoTrue(emailNaoAgendado);
		});
	}

}
