package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Usuario;

// Classe de Login
public class Login implements Acao {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recupera o parametro login e senha enviado da JSP(formLogin.jsp)
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		System.out.println("Logando: " + login);
		
		// Verifica se possui usuario cadastrado.
		Usuario usuario = Banco.existeUsuario(login, senha);
		
		// Se o usuario não estiver vazio executa o 
		if(usuario != null) {
			System.out.println("Usuario Existe!");
			/* Na requisição pega a sessão do usuario, em vez que fazer uma request setando a sessao, nova
			vamos usar o proprio objeto "sessao" que traz pra nos a sessao da requisicao. */
			HttpSession sessao = request.getSession();
			/* Seta o valor do Usuario na sessão, então qualquer jsp consegue capturar estes valores. */
			sessao.setAttribute("usuarioLogado", usuario);
			// Redireciona para ListaEmpresas
			return "redirect:entrada?acao=ListaEmpresas";
		} else {
			// Redireciona para LoginForm, que consequentemente vai me mandar para a JSP loginForm.jsp
			return "redirect:entrada?acao=LoginForm";
		}
}
}
