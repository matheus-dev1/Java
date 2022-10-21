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

/* Filter é uma classe que vai implementar a classe Filter e vai ser declarada no web.xml ou usar a anotação @WebFilter
 *  com a url que ele vai monitar exemplo "/entrada" ou seja, todas as requisições que passarem por /entrada vão
 *  executar as clsses do tipo "Filter".
 *  
 *  Uma classe do tipo Filter vai filtrar a requisição, por exemplo este filter, ele verifica se na sua requisição, tem uma]
 *  sessão ativa, se tiver você segue sua requisição sem problemas, se não ele te redireciona para a pagina de login.
 */
//@WebFilter("/entrada")
public class AutorizacaoFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void destroy() {}
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		// Classe que representa a requisição, e tudo sobre a requisição.
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		// Classe que representa a resposta, e tudo sobre a resposta.
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		System.out.println("Passando pelo Autorização Filter");
		
		// Resgata o valor do query parametro "acao"
		String paramAcao = request.getParameter("acao");
		
		// Resgata a sessão do usuario.
		HttpSession sessao = request.getSession();
		
		// Se a sessão do usuario for null, retorna true e armazena em "usuarioNaoEstaLogado"
		boolean usuarioNaoEstaLogado = sessao.getAttribute("usuarioLogado") == null;
		// Se o parametro de "acao" for "Login" ou "LoginForm" returne true.
		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
		
		// Se for uma acao protegida e o usuario não estiver logado.
		if(ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
			// Faça um redirect para LoginForm
			response.sendRedirect("entrada?acao=LoginForm"); 
			return;
		}
		
		/* A ideia dos filtros é simplesmente executar alguma tarefa que desejamos repetir antes
		 * ou depois de um grupo de requisições que nossa aplicação recebe (nesse exemplo, nosso
		 * filtro irá pegar todas as requisições). Tudo que estiver antes do 
		 * chain.doFilter(request, response) será executado quando recebemos a requisição e tudo 
		 * que estiver despois do chain.doFilter(request, response) será executado após a execução
		 * das servles e dos JSPs, ou seja, quando a resposta estiver saindo de nossa aplicação e voltando para o usuário.
		 * Caso não executemos o chain.doFilter(request, response) isso implica em bloquearmos a requisição
		 * e ela retornará imediatamente para o usuário! Ou seja, fazendo chain.doFilter(request, response)
		 * vc está informando ao seu filtro que ele pode deixar a requisição seguir o caminho dela.
		 * Depois disso, a requisição pode ir para um outro filtro ou ir direto para a servlet que irá
		 * processar ela com a sua lógica de negócio.
		 * 
		 * Com os filtros podemos fazer:
		 * 
		 * Medir o tempo de execução de uma servlet, uma vez que os filtros são executados ao receber uma
		 * requisição (antes do chain.doFilter(request, response)) e depois que a resposta já está pronta
		 * (após o chain.doFilter(request, response)).
		 * 
		 * Autorização de acesso, verificando se o usuário tem permissão para acessar o recurso
		 * pelo qual ele está requisitando.
		 * 
		 * Verificar se a requisição está sendo feita por um usuário autenticado.
		 * 
		 * Log do sistema.*/
		filterChain.doFilter(request, response);
	}
}
