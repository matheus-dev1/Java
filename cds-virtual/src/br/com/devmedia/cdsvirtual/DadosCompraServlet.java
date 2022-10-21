package br.com.devmedia.cdsvirtual;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DadosCompraServlet extends HttpServlet {
	private static final long serialVersionUID = 4943448055257588507L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		// Recupera a lista de codigos dos codigos selecionados em formato de String.
		// O metodo getPrameterValues, recupera uma lista de String.
		String[] codigosCds = request.getParameterValues("chkCodigosCds");
		// Recupera os dados do atributo "catalogoCds" que foi setado no contexto da aplicação.
		HashMap<Long, CD> mapCds = (HashMap<Long, CD>) getServletContext().getAttribute("catalogoCds");
		// Lista com os cds selecionandos. Ainda vazia
		List<CD> cdsSelecionados = new ArrayList<CD>();
		// Vou fazer um for para pegar cada codigo capturado no atributo "chkCodigosCds" e vou fazer um get do objeto completo
		// a partir disso atraves do atributo setado na aplicação(catalogoCds), e atribuir no novo objeto "cdsSelecionados".
		for (String codigo : codigosCds) {
			CD cd = mapCds.get(new Long(codigo));
			cdsSelecionados.add(cd);
		}
		// Nova instancia da Sessão
		HttpSession session = request.getSession();
		// Setando o atributo "cdsSelecionados" na sessão.
		session.setAttribute("cdsSelecionados", cdsSelecionados);
		// E depois, chama a pagina "dadosCompra.jsp", para preencher os dados do usuario.
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/dadosCompra.jsp");
		requestDispatcher.forward(request, response);
	}
}