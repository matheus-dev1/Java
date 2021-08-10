package br.com.alura.gerenciador.servlet;

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
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long antes = System.currentTimeMillis();
		
		String acao = request.getParameter("acao");

		// Cada requisicao e resposta de eh passado por este filtro, seguindo a arquitetura do 
		// programa(isso porque o @webFilter tambem tem o /entrada)
		// vai pasar pelo doFilter, recebendo tanto, as acoes como 
		// exemplo Lista Empresas, Altera Empresa e etc...
        chain.doFilter(request, response);

        long depois = System.currentTimeMillis();

        System.out.println("Tempo de execu��o " + (depois - antes) + " - A��o: " + acao);
		
	}

}
