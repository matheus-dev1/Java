package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Classe que envia a requisi��o com os parametros(se tiver), para a JSP.
public class LoginForm implements Acao {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Forward: Se traduzir o nome para o portugu�s significa encaminhar.
		Ou seja, ele vai reenviar a �ltima requisi��o feita quando voc� pedir para atualizar a p�gina. */
		return "forward:formLogin.jsp";
	}
}
