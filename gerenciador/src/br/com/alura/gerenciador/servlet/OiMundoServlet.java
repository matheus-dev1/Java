package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns="/oi")
public class OiMundoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public OiMundoServlet() {
		System.out.println("Criando Oi Mundo Servlet.");
	}
	
	// A gente vai bater nessa service, porque definimos no web.xml este servlet com o path /ola
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// A resposta do servlet, vai nos dar um objeto getWriter(), que nos permite retornar para o cliente(web/browser).
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		// Sem ter as tags html e body, você até consegue receber a mensagem no documento da web, mas com limitações.
		out.println("Oi mundo, parabéns você escreveu o seu primeiro servlet.");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("O servlet OiMundoServlet foi chamado");
	}
}
