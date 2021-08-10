package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;
import br.com.alura.gerenciador.acao.AlteraEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresaForm;
import br.com.alura.gerenciador.acao.RemoveEmpresa;

//@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
			String paramAcao = request.getParameter("acao");
		
//			HttpSession sessao = request.getSession();
//			// Para melhor leitura.
//			boolean usuarioNaoEstaLogado = sessao.getAttribute("usuarioLogado") == null;
//			boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
//			
//			if(ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
//				response.sendRedirect("entrada?acao=LoginForm"); 
//				return;
//			}
			
			String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;
			
			String nome;
			
			// O Reflection, em poucas palavras, serve para determinar métodos e atributos que serão
			// utilizados de determinada classe (que você nem conhece) em tempo de execução.
			
			// Botao direito, seleciona tudo, Sorround With -> Multi
			try {
				// Carrega a Classe com o nome Full Qualified Name da variavel paramAcao.
				// Ele carrega apenas uma vez e deixa essas classes em memoria.
				Class classe = Class.forName(nomeDaClasse);
				// Aqui ele instancia propriamente dito a classe(nomeDaClasse).
				// Temos que fazer um cast do tipo Interface para a classe Acao, porque nos vamos executar
				// o metodo implementado da interface Acao da classe(nomeDaClasse).
				Acao acao = (Acao) classe.newInstance();
				// Acao aqui ja vai estar com a referencia da classe intanciada em que implementa Acao.
				// Executando o metodo e armazenando seu retono em "nome".
				nome = acao.executa(request, response);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				throw new ServletException(e);
			}
			
			String[] tipoEndereco = nome.split(":");
			if(tipoEndereco[0].equals("forward")){
				// Exemplo: WEB-INF/view/formAlteraEmpresa.jsp
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
				rd.forward(request, response);
			} else {
				response.sendRedirect(tipoEndereco[1]);
			}
		
	//		String nome = null;
	//		if(paramAcao.equals("listaEmpresas")) {
	//			System.out.println("listaEmpresas");
	//			ListaEmpresas listaEmpresas = new ListaEmpresas();
	//			nome = listaEmpresas.executa(request, response);
	//		} else if(paramAcao.equals("mostraEmpresa")) {
	//			System.out.println("mostraEmpresa");
	//			MostraEmpresa mostraEmpresa = new MostraEmpresa();
	//			nome = (String) mostraEmpresa.executa(request, response);
	//		} else if(paramAcao.equals("removeEmpresa")) {
	//			System.out.println("removeEmpresa");
	//			RemoveEmpresa removeEmpresa = new RemoveEmpresa();
	//			nome = removeEmpresa.executa(request, response);
	//		} else if(paramAcao.equals("alteraEmpresa")) {
	//			System.out.println("alteraEmpresa");
	//			AlteraEmpresa alteraEmpresa = new AlteraEmpresa();
	//			nome = alteraEmpresa.executa(request, response);
	//		} else if(paramAcao.equals("novaEmpresa")) {
	//			System.out.println("novaEmpresa");
	//			NovaEmpresa novaEmpresa = new NovaEmpresa();
	//			nome = novaEmpresa.executa(request, response);
	//		} else if(paramAcao.equals("novaEmpresaForm")) {
	//			System.out.println("novaEmpresaForm");
	//			NovaEmpresaForm novaEmpresaForm = new NovaEmpresaForm();
	//			nome = novaEmpresaForm.executa(request, response);
	//		}		
	}
}
