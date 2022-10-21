package br.com.devmedia.cdsvirtual;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfirmaDadosServlet extends HttpServlet {
	private static final long serialVersionUID = -7799830223132576594L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
			// Resgatando os parametro nome, endereco e cartao da requisição feita pela dadosCompra.jsp
			String nome = request.getParameter("nome");
			String endereco = request.getParameter("endereco");
			String cartao = request.getParameter("cartao");
			Usuario usuario = new Usuario(nome, endereco, cartao);
			// Vou pegar os cds selecionados pelo usuario atraves do sessão.
			List<CD> cdsSelecionados = (List<CD>) request.getSession().getAttribute("cdsSelecionados");
			double total = 0;
			for (CD cd : cdsSelecionados) {
				total += cd.getPreco();
			}
			request.setAttribute("usuario", usuario);
			request.setAttribute("total", total);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/confirmaDados.jsp");
			requestDispatcher.forward(request, response);
	}
}