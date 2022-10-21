package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class NovaEmpresa implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		// Pega os parametros nome e data do frontend
		String nomeEmpresa = request.getParameter("nome");
		String paramDataEmpresa = request.getParameter("data");
				
		Date dataAbertura = null;
		try {
			SimpleDateFormat simpleDataFormatDiaMesAno = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = simpleDataFormatDiaMesAno.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		// Criando uma nova empresa
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		// Adiciona no nosso "Banco de Dados" ficticio.
		Banco banco = new Banco();
		banco.adiciona(empresa);
				
		// Setando o nome da empresa no atributo da requisição.
		request.setAttribute("empresa", empresa.getNome());
		
		// Redireciona para a pagina de listagem de empresas.
		return "redirect:entrada?acao=ListaEmpresas";
	}
}
