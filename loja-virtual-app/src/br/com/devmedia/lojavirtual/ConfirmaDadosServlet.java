package br.com.devmedia.lojavirtual;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfirmaDadosServlet extends HttpServlet {
	private static final long serialVersionUID = -7799830223132576594L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//recupera os dados de compra

		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String cartao = req.getParameter("cartao");
		//cria o objeto usuario
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEndereco(endereco);
		usuario.setCartao(cartao);
		//calcula o total
		List<CD> cdsSelecionados = (List<CD>) req.getSession().getAttribute("cdsSelecionados");
		double total = 0;
		for (CD cd : cdsSelecionados) {
			total += cd.getPreco();
		}
		req.setAttribute("usuario", usuario);
		req.setAttribute("total", total);
		req.getRequestDispatcher("confirmaDados.jsp").forward(req, resp);
  }
}