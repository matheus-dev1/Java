package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
				HttpSession sessao = request.getSession();
				
				// Apenas remove o atributo(Cookie) setado, porem o objeto httpSession continua em memoria.
				// sessao.removeAttribute("usuarioLogado");
				
				// Remove o objeto HttpSession e todos os objetos associados e tambem destroi o cookie.
				sessao.invalidate();
			
				return "redirect:entrada?acao=LoginForm";
	}

}
