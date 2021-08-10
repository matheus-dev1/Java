package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
			List<Empresa> empresas = new Banco().getEmpresas();
			
			String valor = request.getHeader("Accept");
			
			System.out.println(valor);
			
			if(valor.contains("/xml")) {
				XStream xstream = new XStream();
				// Em vez do FQN(Full Qualified Name) ele vai exibir o primeiro parametro.
				xstream.alias("empresa", Empresa.class);
				String xml = xstream.toXML(empresas);
				
				response.setContentType("application/xml");
				response.getWriter().print(xml);
			} else if(valor.contains("/json")) {
				// Instanciando a lib GSON. 
				Gson gson = new Gson();
				
				// Em empresas colocar o objeto e a variavel json do tipo String vai nos retornar o Json 
				// do objeto propriamente dito.
				String json = gson.toJson(empresas);
				
				// Tenho que setar em qual formato estou enviado a resposta ao navegador, neste caso no formato
				// json.
				response.setContentType("application/json");
				// O response vai retornar algo para o navegador/consuidor, o metodo getWriter escreve o binario
				// e o print retorna em formato HTTP.
				response.getWriter().print(json);
			} else {
				response.setContentType("application/json");
				response.getWriter().print("{'message': 'no content'}");
			}
		}
}
