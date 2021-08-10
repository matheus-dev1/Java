package br.com.alura.gerenciador.servlet;

import java.io.IOException;

// import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listaEmpresasServlet")
public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListaEmpresasServlet() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
			Bd bd = new Bd();
			// A gente registra as empresas no form novaEmpresa.html e fica em cache as empre-
			// sas registradas.
			List<Empresa> listaEmpresas = bd.getEmpresas();
			
	    	RequestDispatcher requestDispatcherListaEmpresas = request.getRequestDispatcher("/listar.jsp");
	    	// Este metodo vai setar um atributo na requisicao, dando a ele um apelido e qual eh o atributo.
	    	request.setAttribute("empresas", listaEmpresas);
	    	// Aqui nos enviamos genuinamente o Dispatcher para frente
	    	requestDispatcherListaEmpresas.forward(request, response);
			
			// PrintWriter out = response.getWriter();
			// out.println("<html>");
			// out.println("<body>");
			// Pego cada item da lista individualmente.
			// for (Empresa empresa : listaEmpresas) {
			// 	out.println("<li>" + empresa.getNome() + "</li>");
			// }
			// out.println("</body>");
			// out.println("</html>");
	}

}
