package br.com.alura.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.entidade.AgendamentoEmail;
import br.com.alura.servico.AgendamentoEmailServico;

// Como se fosse no Spring, estou definindo uma rota.
@WebServlet("emails")
public class AgendamentoEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 7570851863235648311L;
	
	// CDI.
	// È como se fosse um @Autowired do Spring, a gente faz a injeção dessa dependencia sem a necessidade de instanciar ela.
	@Inject
	private AgendamentoEmailServico AgendamentoEmailServico;

	public AgendamentoEmailServlet() {}
	
	// Requisição HTTP do tipo GET
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		try {
			// A resposta do servlet, vai nos dar um objeto getWriter(), que nos permite retornar para o cliente(web/browser).
			printWriter.println("Teste");
			printWriter.println(AgendamentoEmailServico.listarEmails().get(0));
			printWriter.println(AgendamentoEmailServico.listarEmails().get(1));
			printWriter.println("LombokReal = " + AgendamentoEmailServico.testLombok());
			System.out.println("Dias:" + String.valueOf(AgendamentoEmailServico.diasEntreDatas("2021-08-14")));
			printWriter.println("Dias: " + String.valueOf(AgendamentoEmailServico.diasEntreDatas("2021-08-14")));
			printWriter.println(AgendamentoEmailServico.listarEmailsBd());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    BufferedReader bufferedReader = request.getReader();
	    String[] agendamentoEmailResposta = bufferedReader.readLine().split(",");
	    AgendamentoEmail agendamentoEmail = new AgendamentoEmail();
	    agendamentoEmail.setEmail(agendamentoEmailResposta[0]);
	    agendamentoEmail.setAssunto(agendamentoEmailResposta[1]);
	    agendamentoEmail.setMensagem(agendamentoEmailResposta[2]);
	    AgendamentoEmailServico.inserirEmail(agendamentoEmail);
	}
	
}
