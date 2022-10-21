package br.com.alura.gerenciador.filter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

//@WebFilter("/entrada")
/* Classe responsavel por controlar o fluxo da aplica��o, ou seja, ele que controla para onde eu vou fazer um forward ou redirect */
public class ControladorFilter implements Filter {
	/* Para usar o Jetty ou qualquer outro servidor Java ele obriga que a gente implemente estes metodos, 
	 * mesmo que a gente n�o os sobreescreva da interface Filter. 
	 * Al�m de garantir que ele rode em versoes mais antigas do Tomcat. */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void destroy() {}
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		System.out.println("Passando pelo Controlador Filter");
		// Pegando o valor do parametro "acao"
		String paramAcao = request.getParameter("acao");
		// Concatena o nome do full qualified name do arquivo. Exemplo: br.com.alura.gerenciador.acao.ListaEmpresas
		String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;
		String nome;
			
		try {
			// Obtendo o "Full Qualified Name" da classe em que eu estou fazendo a requisi��o.
			Class<?> classe = Class.forName(nomeDaClasse);
			// Exibindo o FQN da classe.
			System.out.println(classe);
			// Fazendo uma nova instancia da classe "Acao" e fazendo um cast para a classe "Acao".
			Acao acao = (Acao) classe.getDeclaredConstructor().newInstance();
			/* Identifica a classe que est� implementando a Interface "Acao" e retorna a implementa��o deste metodo para "nome" */
			nome = acao.executa(request, response);
			// Qual o nome da pagina vai enviar e se � um forward ou redirect.
			System.out.println(nome);
		} catch (ClassNotFoundException |
				 InstantiationException | 
				 IllegalAccessException | 
				 IllegalArgumentException | 
				 InvocationTargetException | 
				 NoSuchMethodException | 
				 SecurityException e) {
			throw new ServletException(e);
		}
		
		// Vou separar a String pelos ":"
		String[] tipoEndereco = nome.split(":");
		
		// Se o endee�o for do tipo "forward".
		if(tipoEndereco[0].equals("forward")){
			/* A diferen�a est� entre redirecionar o cliente para uma p�gina (sendRedirect)
			 * e encaminhar uma requisi��o para ser atendida por outro recurso (forward).
			 * 
			 * No primeiro caso (sendRedirect), o cliente receber� uma resposta http em cujo
			 * header haver� a informa��o de que ele deve requisitar outra p�gina, e o browser
			 * far� esta requisi��o. Ou seja, o redirecionamento ocorre no lado no cliente.
			 * 
			 * No segundo caso (forward)/(request.getRequestDispatcher), no lado do server a requisi��o do usu�rio 
			 * ser� encaminhada para ser atendida por outro recurso (outro servlet). Este outro servlet eventualmente
			 * devolver� outra p�gina para o usu�rio.
			 */
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
			requestDispatcher.forward(request, response);
		} else {
			response.sendRedirect(tipoEndereco[1]);
		}
	}
}
