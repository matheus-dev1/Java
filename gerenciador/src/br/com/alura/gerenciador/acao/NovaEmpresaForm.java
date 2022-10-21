package br.com.alura.gerenciador.acao;

import java.io.IOException;

/*import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;*/

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;*/

// Classe do formulario da nova empresa.
public class NovaEmpresaForm implements Acao {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Redireciona enviando parametro, se tiver!
		return "forward:formNovaEmpresa.jsp";
	}
}
