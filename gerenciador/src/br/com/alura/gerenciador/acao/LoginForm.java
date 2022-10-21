package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Classe que envia a requisição com os parametros(se tiver), para a JSP.
public class LoginForm implements Acao {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Forward: Se traduzir o nome para o português significa encaminhar.
		Ou seja, ele vai reenviar a última requisição feita quando você pedir para atualizar a página. */
		return "forward:formLogin.jsp";
	}
}
