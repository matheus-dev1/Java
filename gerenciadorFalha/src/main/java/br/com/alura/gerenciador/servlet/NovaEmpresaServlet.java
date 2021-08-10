package br.com.alura.gerenciador.servlet;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NovaEmpresaServlet() {
    	
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			System.out.println("Cadastrando nova empresa.");
			
			// A ideia do metodo GET e solicitar determinada coisa em especifico pela 
			// URL para o servidor(servlet)
			String nome = request.getParameter("nome");
			
			Empresa empresa = new Empresa();
	    	empresa.setNome(nome);
	    	
	    	Bd bd = new Bd();
	    	bd.add(empresa);
			
			// Devolve caracteres para o navegador.
			// PrintWriter out = response.getWriter();
			// out.println("<html>");
			// out.println("<body>");
			// out.println("<h1>Nome da Empresa: " + bd.getEmpresas() + "</h1>");
			// out.println("</body>");
			// out.println("</html>");
	    	
	    	// Chamar JSP - Devemos enviar esta requisicao para uma rota, no caso, novaEmpresaCriada.jsp
	    	// Eu vou carregar este arquivo na rota desta classe.
	    	RequestDispatcher requestDispatcherNovaEmpresaCriada = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
	    	// Este metodo vai setar um atributo na requisicao, dando a ele um apelido e qual eh o atributo.
	    	request.setAttribute("empresa", empresa.getNome());
	    	// Aqui nos enviamos genuinamente o Dispatcher para frente.
	    	requestDispatcherNovaEmpresaCriada.forward(request, response);
		}

}
