package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

// Redireciona para a pagina de alteração de empresa com os dados disponiveis para serem alterados.
public class MostraEmpresa implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Pega o id da empresa
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		Empresa empresa = Banco.buscaEmpresaPelaId(id);
		System.out.println(empresa.getNome());

		// Seta os valores da empresa como atributo na requsição e manda para a pagina formAlteraEmpresa.jsp
		request.setAttribute("empresa", empresa);
		return "forward:formAlteraEmpresa.jsp";
	}
}
