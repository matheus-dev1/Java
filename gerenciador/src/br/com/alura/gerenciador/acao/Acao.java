package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Todas as classes que implementam a interface ação, vão retornar ou um forward ou redirect para uma Jsp ou para um classe Java.
public interface Acao {
	// Interface usada para implementar o método executa com o request e response de todas as ações(requisições).
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
