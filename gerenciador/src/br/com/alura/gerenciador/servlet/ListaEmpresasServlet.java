package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

//Essa classe faz a mesma coisa que "ListaEmpresas.Java", por�m ela n�o estra em nenhum fluxo. DESATIVADA.
//@WebServlet("/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Empresa> lista = Banco.getEmpresas();
		
		request.setAttribute("empresas", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		rd.forward(request, response);	
	}
}
