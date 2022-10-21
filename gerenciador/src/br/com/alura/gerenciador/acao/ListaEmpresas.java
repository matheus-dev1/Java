package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

// Classe de listagem de empresas
public class ListaEmpresas implements Acao {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recupera lista de empresas
		List<Empresa> lista = Banco.getEmpresas();
		/* Aqui eu estou setando uma variavel do tipo List<Empresa> na requisição, e como eu estou fazendo um forward
		na linha abaixo eu estou enviando este dados para essa pagina, essa é a função do forward. 
		Obs: Aqui foi usado o nome empresas, então, na JSP o nome tem que ser usado empresas também.*/
		request.setAttribute("empresas", lista);
		// Retorna a JSP listaEmpresas.jsp
		return "forward:listaEmpresas.jsp";
	}
}
