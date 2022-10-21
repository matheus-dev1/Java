package br.com.alura.gerenciador.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Capturando o tempo inicio da requisi��o.
		long antes = System.currentTimeMillis();
		
		// Pegando o parametro "acao".
		String acao = request.getParameter("acao");

		/* Cada requisi��o e resposta de � passado por este filtro, seguindo a arquitetura do programa 
		 * (Isso porque o @webFilter tambem tem o /entrada) vai pasar pelo doFilter, recebendo tanto,
		 * as a��es como exemplo Lista Empresas, Altera Empresa e etc... */
        chain.doFilter(request, response);

        // Tempo final da requisi��o.
        long depois = System.currentTimeMillis();

        // Exibindo o tempo da requisi��o e em qual requisi��o.
        System.out.println("Tempo de execu��o " + (depois - antes) + " - A��o: " + acao);	
	}
}
