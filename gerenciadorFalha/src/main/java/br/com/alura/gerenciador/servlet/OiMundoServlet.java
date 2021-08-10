//Este servlet tem que ta na pasta src/main/java
package br.com.alura.gerenciador.servlet;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;

// Herda de HttpServlet
// Para configuracoes, podemos usar XML ou Anotacoes(uma anotacao eh uma configuracao para o compilador)
// Chamado de mapeamento.
@WebServlet(urlPatterns = "/oi")
public class OiMundoServlet extends HttpServlet {

	// Sobre escrevendo o metodo.
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			// request - solicitacao | response - resposta
			// O getWriter eh um metodo do response(parametro HttpServletResponse) que retorna no fluxo
			// de reposta ao navegador (response), ou seja, caracteres que eu vou enviar para o navegador
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("Voce eh o amor da minha vida :)");
			out.println("</body>");
			out.println("</html>");
			
			System.out.println("Servidor rodando...");
		}
}
