package br.com.devmedia.cdsvirtual;

import javax.servlet.jsp.tagext.*;

import java.io.IOException;

import javax.servlet.jsp.*; 

// Para a criação de taglib, é necessario importar o SimpleTagSupport que é a implementação do SimpleTag
public class PrimeiraTag extends SimpleTagSupport {
	private Boolean hello;
	
	public void doTag() throws JspException, IOException {
		if(hello.equals(true)) {
			/* O método getJspContext() é usado para recuperar o contexto da página. 
			Um objeto JspContext, novo no JSP 2.0, que define métodos para manipular atributos,
			tratar tags aninhados e recuperar o objeto implícito. */
			PageContext pageContext = (PageContext) getJspContext();
			// O valor atual do objeto out (um JspWriter).
			JspWriter out = pageContext.getOut();
			try {
				// Encerre a linha atual escrevendo a string separadora de linha.
				out.println("Olá, mundo!");
			}
			catch(Exception e){
				out.println(e);
	       }
		}
    }
	
	// Metodo que nos criamos para receber um parametro.
	public void setTeste(String teste) throws IOException {
		PageContext pageContext = (PageContext) getJspContext();
		JspWriter out = pageContext.getOut();
		try {
			out.println(teste);
		}
		catch(Exception e){
			out.println(e);
       }
	}
	
	public void setHello(String hello) {
		this.hello = Boolean.parseBoolean(hello);
	}
}