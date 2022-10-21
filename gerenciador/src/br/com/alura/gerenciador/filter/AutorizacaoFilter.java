package br.com.alura.gerenciador.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/* Filter � uma classe que vai implementar a classe Filter e vai ser declarada no web.xml ou usar a anota��o @WebFilter
 *  com a url que ele vai monitar exemplo "/entrada" ou seja, todas as requisi��es que passarem por /entrada v�o
 *  executar as clsses do tipo "Filter".
 *  
 *  Uma classe do tipo Filter vai filtrar a requisi��o, por exemplo este filter, ele verifica se na sua requisi��o, tem uma]
 *  sess�o ativa, se tiver voc� segue sua requisi��o sem problemas, se n�o ele te redireciona para a pagina de login.
 */
//@WebFilter("/entrada")
public class AutorizacaoFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void destroy() {}
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		// Classe que representa a requisi��o, e tudo sobre a requisi��o.
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		// Classe que representa a resposta, e tudo sobre a resposta.
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		System.out.println("Passando pelo Autoriza��o Filter");
		
		// Resgata o valor do query parametro "acao"
		String paramAcao = request.getParameter("acao");
		
		// Resgata a sess�o do usuario.
		HttpSession sessao = request.getSession();
		
		// Se a sess�o do usuario for null, retorna true e armazena em "usuarioNaoEstaLogado"
		boolean usuarioNaoEstaLogado = sessao.getAttribute("usuarioLogado") == null;
		// Se o parametro de "acao" for "Login" ou "LoginForm" returne true.
		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
		
		// Se for uma acao protegida e o usuario n�o estiver logado.
		if(ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
			// Fa�a um redirect para LoginForm
			response.sendRedirect("entrada?acao=LoginForm"); 
			return;
		}
		
		/* A ideia dos filtros � simplesmente executar alguma tarefa que desejamos repetir antes
		 * ou depois de um grupo de requisi��es que nossa aplica��o recebe (nesse exemplo, nosso
		 * filtro ir� pegar todas as requisi��es). Tudo que estiver antes do 
		 * chain.doFilter(request, response) ser� executado quando recebemos a requisi��o e tudo 
		 * que estiver despois do chain.doFilter(request, response) ser� executado ap�s a execu��o
		 * das servles e dos JSPs, ou seja, quando a resposta estiver saindo de nossa aplica��o e voltando para o usu�rio.
		 * Caso n�o executemos o chain.doFilter(request, response) isso implica em bloquearmos a requisi��o
		 * e ela retornar� imediatamente para o usu�rio! Ou seja, fazendo chain.doFilter(request, response)
		 * vc est� informando ao seu filtro que ele pode deixar a requisi��o seguir o caminho dela.
		 * Depois disso, a requisi��o pode ir para um outro filtro ou ir direto para a servlet que ir�
		 * processar ela com a sua l�gica de neg�cio.
		 * 
		 * Com os filtros podemos fazer:
		 * 
		 * Medir o tempo de execu��o de uma servlet, uma vez que os filtros s�o executados ao receber uma
		 * requisi��o (antes do chain.doFilter(request, response)) e depois que a resposta j� est� pronta
		 * (ap�s o chain.doFilter(request, response)).
		 * 
		 * Autoriza��o de acesso, verificando se o usu�rio tem permiss�o para acessar o recurso
		 * pelo qual ele est� requisitando.
		 * 
		 * Verificar se a requisi��o est� sendo feita por um usu�rio autenticado.
		 * 
		 * Log do sistema.*/
		filterChain.doFilter(request, response);
	}
}
