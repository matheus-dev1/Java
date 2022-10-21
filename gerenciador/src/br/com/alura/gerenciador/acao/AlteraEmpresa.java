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

public class AlteraEmpresa implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Alterando empresa");
		/* Parametros resgatados do frontend */
		String nomeEmpresa = request.getParameter("nome");
		String paramDataEmpresa = request.getParameter("data");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		// Inicio data de abertura como nulo para existir fora do escopo do try...catch
		Date dataAbertura = null;
		try {
			// Criando um formato de data padrão com Dia/Mes/Ano
			SimpleDateFormat simpleDateFormatDiaMesAno = new SimpleDateFormat("dd/MM/yyyy");
			// Pegando a data do frontend e "lapidando" para o formato acima.
			dataAbertura = simpleDateFormatDiaMesAno.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}	
			// Qual o id da empresa.
			System.out.println(id);
				
			Banco banco = new Banco();
			Empresa empresa = banco.buscaEmpresaPelaId(id);
			empresa.setNome(nomeEmpresa);
			empresa.setDataAbertura(dataAbertura);
			
			// Redireciona para a JSP de listagem de empresas.
			return "redirect:entrada?acao=ListaEmpresas";
		}
}
