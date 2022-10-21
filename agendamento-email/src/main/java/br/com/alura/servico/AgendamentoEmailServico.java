package br.com.alura.servico;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.joda.time.DateTime;
import org.joda.time.Days;

import br.com.alura.dao.AgendamentoEmailDAO;
import br.com.alura.entidade.AgendamentoEmail;

/*
 * Essa anotação define que esta classe é um EJB do tipo Stateless, ou seja, ele não possui estado, então toda requisição ele é instanciado novamente. 
 * Atraves do arquivo standalone-full.xml, do nosso servidor de aplicação nos podemos criar um pool de instâncias de EJB Stateless.
 * <strict-max-pool name="slsb-strict-max-pool" max-pool-size="20" instance-acquisition-timeout="5" instance-acquisition-timeout-unit="MINUTES"/>
 * Com esse parametro max-pool-size="20", quer dizer que quando eu iniciar meu servidor wildfly, ele vai criar um pool de instanciar com 20 instancias dos meus 
 * EJBs Stateless, então quando o usuario fazer uma requisição para a nossa aplicação, ele vai buscar uma instancia neste pool, vai fazer processar a requisição
 * devolver para o cliente e depois a instacia volta para o pool de instancias.
 * Obs: Se por exemplo todas as 20 instancia estiverem sendo "usadas", então a proxima requisição tem que aguardar o processamento da instancia para poder alocar 
 * essa outra requisição. */
@Stateless
public class AgendamentoEmailServico {
	
	private static final Logger LOGGER = Logger.getLogger(AgendamentoEmailServico.class.getName());
	
	// @EJB ou @Inject fazem a mesma coisa. Só que apenas funciona com classes EJB, ou seja, classes que tenham por exemplo @Statelass.
	@EJB
	private AgendamentoEmailDAO agendamentoEmailDAO;

	public AgendamentoEmailServico() {}
	
	public List<String> listarEmails() {
		ArrayList<String> listaDeEmails = new ArrayList<>();
		listaDeEmails.add("kojodosbr@yahoo.com");
		listaDeEmails.add("matheusdeoliveiraferrero@hotmail.com");
		return listaDeEmails;
	}
	
	public Integer diasEntreDatas(String data) throws ParseException {
		Integer diferencaEmDias = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dataCadastro = simpleDateFormat.parse(data);
			String dataEmString = simpleDateFormat.format(new Date());
			Date dataAtual = simpleDateFormat.parse(dataEmString);
			
		    DateTime dataAlteracaoDateTime = new DateTime(dataCadastro);              
		    DateTime dataAtualDateTime = new DateTime(dataAtual);   
		    
		    diferencaEmDias = Days.daysBetween(dataAlteracaoDateTime, dataAtualDateTime).getDays();
		    
		} catch (ParseException e) {
            e.printStackTrace();
        }
		
		return diferencaEmDias;
	}
	
	public String testLombok() {
		AgendamentoEmail agendamentoEmail = new AgendamentoEmail();
		agendamentoEmail.setMensagem("Lombok");
		System.out.println(agendamentoEmail.getMensagem());
		return agendamentoEmail.getMensagem();
	}
	
	public List<AgendamentoEmail> listarEmailsBd() {
		return agendamentoEmailDAO.listarEmails();
	}
	
	public void inserirEmail(AgendamentoEmail agendamentoEmail) {
		agendamentoEmail.setAgendado(Boolean.FALSE);
		agendamentoEmailDAO.inserirEmail(agendamentoEmail);
	}
	
	public List<AgendamentoEmail> listarPorEmailNaoAgendado() {
		return agendamentoEmailDAO.listarPorEmailNaoAgendado();
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void alterarEmailAgendadoTrue(AgendamentoEmail agendamentoEmail) {
		if(agendamentoEmail.getEmail().equals("teste1234@gmail.com")) {
			throw new RuntimeException("Não foi possivel enviar o email");
		}
		
		LOGGER.info("O Email do usuario " + agendamentoEmail.getEmail() + " foi agendado");
		agendamentoEmail.setAgendado(Boolean.TRUE);
		agendamentoEmailDAO.alterarEmailAgendadoTrue(agendamentoEmail);
	}
	
	public void enviarEmail(AgendamentoEmail agendamentoEmail) {
		try {
			Thread.sleep(5000);
			LOGGER.info("O Email do usuario " + agendamentoEmail.getEmail() + " foi enviado");
		} catch(Exception e) {
			LOGGER.info(e.getMessage());
		}
	}
}
