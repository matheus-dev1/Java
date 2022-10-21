package br.com.devmedia.cdsvirtual;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ConsoleBody extends SimpleTagSupport {
	public void doTag() throws JspException, IOException {
		// Um fluxo de caracteres que coleta sua saída em um buffer de string, que pode ser usado para construir uma string.
		StringWriter stringWriter = new StringWriter();
		
		// Retorna o corpo passado pelo container via setJspBody.
		JspFragment jspFragment = getJspBody();
		// Executa o fragmento e direciona toda a saída para o Writer fornecido ou o JspWriter retornado
		// pelo método getOut() do JspContext associado ao fragmento se out for nulo.
		jspFragment.invoke(stringWriter);
		
		// Retorna o contexto da página passado pelo contêiner via setJspContext.
		JspContext jspContext = getJspContext();
		// O valor atual do objeto out (um JspWriter).
		JspWriter jspWriter = jspContext.getOut();
		// Encerre a linha atual escrevendo a string separadora de linha.
		jspWriter.println(stringWriter.toString());
	}
}