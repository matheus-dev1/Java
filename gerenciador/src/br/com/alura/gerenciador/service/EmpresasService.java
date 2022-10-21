package br.com.alura.gerenciador.service;

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

/* Essa anotação é a criação da rota no contexto da aplicação, ou seja, ficaria localhost:8080/gerenciador/empresas,
essa anotação evita que a gente tenha que declarar no web.xml */
@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = -2559353214906241403L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Empresa> empresas = Banco.getEmpresas();
		
		// Vai pegar o valor do header "Accept" que por padrão vem */*
		String valor = request.getHeader("Accept");
		
		// Vai printar o valor do header "Accept".
		System.out.println(valor);
		
		// Se o conteudo da variavel "valor" for "application/xml"
		if(valor.contains("/xml")) {
			/* A biblioteca XStream foi criada visando facilitar a manipulação de XML em Java, através da 
			 * serialização/deserialização de objetos usando representação em XML. */
			XStream xstream = new XStream();
			/* O primeiro parametro é a criação de uma tag pai, para ter como filho a classe empresa. Exemplo: 
			 * <empresa>
			 * 	 <id>1</id>
			 * 	 <nome>Alura</nome>
			 *   <dataAbertura>2022-06-30 23:35:03.272 UTC</dataAbertura>
			 * </empresa>
			 * */
			xstream.alias("empresa", Empresa.class);
			// Retorna formatado como XML
			String xml = xstream.toXML(empresas);
			// Seta em qual formato estou enviado a resposta ao navegador, neste caso no formato XML.
			response.setContentType("application/xml");
			// O response vai retornar algo para o navegador, o metodo getWriter escreve o binario e o print retorna em formato HTTP.
			response.getWriter().print(xml);
		// Se o conteudo da variavel "valor" for "application/json"
		} else if(valor.contains("/json")) {
			// Instanciando a lib GSON. 
			Gson gson = new Gson();
			// Em empresas colocar o objeto e a variavel json do tipo String vai nos retornar o Json do objeto propriamente dito.
			String json = gson.toJson(empresas);
			// Tenho que setar em qual formato estou enviado a resposta ao navegador, neste caso no formato JSON.
			response.setContentType("application/json");
			response.getWriter().print(json);
		// Se o header "Accept", não for preenchido, então deve executar o bloco de comandos abaixo.
		} else {
			// Seta o tipo da resposta que sera retornado. Neste caso do tipo JSON.
			response.setContentType("application/json");
			response.getWriter().print(" { 'mensagem': 'sem conteudo' } ");
		}
	}
}
