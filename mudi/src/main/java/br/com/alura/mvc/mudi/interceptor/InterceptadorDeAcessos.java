package br.com.alura.mvc.mudi.interceptor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InterceptadorDeAcessos extends HandlerInterceptorAdapter {
	
	public static List<Acesso> listaDeAcessos = new ArrayList<Acesso>();
	
	// Antes do processameto
	@Override
	public boolean preHandle(
		HttpServletRequest request,
		HttpServletResponse response,
		Object handler) 
			throws Exception {
		
			Acesso acesso = new Acesso();
			acesso.path = request.getRequestURI();
			acesso.data = LocalDateTime.now();
			
			request.setAttribute("acesso", acesso);
			
			// return super.preHandle(request, response, handler);
			return true;
			
	}
	
	@Override
	public void afterCompletion(
		HttpServletRequest request,
		HttpServletResponse response,
		Object handler,
		Exception ex)
			throws Exception {
			Acesso acesso = (Acesso) request.getAttribute("acesso");
			acesso.duracao = Duration.between(acesso.data, LocalDateTime.now());
			listaDeAcessos.add(acesso);
			//super.afterCompletion(request, response, handler, ex);
	}
	
	public static class Acesso {
		private String path;
		private LocalDateTime data;
		private Duration duracao;
		
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
		
		public LocalDateTime getData() {
			return data;
		}
		public void setData(LocalDateTime data) {
			this.data = data;
		}
		
		public Duration getDuracao() {
			return duracao;
		}
		public void setDuracao(Duration duracao) {
			this.duracao = duracao;
		}
		
	}
}
