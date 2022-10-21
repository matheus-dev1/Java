package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// Classe de logout.
public class Logout implements Acao {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Se tiver sessão, ele retorna a sessão do usuario.
		HttpSession sessao = request.getSession();
		
		// Apenas remove o atributo(Cookie) setado, porem o objeto httpSession continua em memoria.
		// sessao.removeAttribute("usuarioLogado");
				
		// Remove o objeto HttpSession e todos os objetos associados e tambem destroi o cookie.
		sessao.invalidate();
		
		/* Redireciona para http://localhost:8080/entrada?acao=LoginForm
		Obs: Sendo que o valor da resposta do query param "acao", LoginForm é a classe LoginForm, ou seja, 
		ele vai executar essa classe e por sua vez LoginForm envia a requisição para a JSP formLogin.jsp */
		return "redirect:entrada?acao=LoginForm";
	}
}
