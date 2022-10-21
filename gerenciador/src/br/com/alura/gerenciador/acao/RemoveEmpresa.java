package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

// Classe responsavel pela remoção da empresa
public class RemoveEmpresa implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Pega o id da empresa.
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		System.out.println(id);
			
		Banco banco = new Banco();
		banco.removeEmpresa(id);
			
		// Redireciona para a listagem de empresas.
		return "redirect:entrada?acao=ListaEmpresas";
	}
}
