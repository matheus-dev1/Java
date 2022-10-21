package br.com.alura.alurator.protocolo;

import java.util.HashMap;
import java.util.Map;

public class Request {
	private String pacoteCompleto;
	private String nomeMetodo;
	private Map<String, Object> parametros;
	
	public Request(String url) {
		if(url.contains("?")) {
			pacoteCompleto = StringUtils.urlPrimeiraParte(url).get(0) + "Controller";
			nomeMetodo = StringUtils.urlPrimeiraParte(url).get(1);
			this.parametros = StringUtils.parametrosMap(url);
		} else {
			pacoteCompleto = StringUtils.urlPrimeiraParte(url).get(0) + "Controller";
			nomeMetodo = StringUtils.urlPrimeiraParte(url).get(1);
			this.parametros = new HashMap<String, Object>();
		}
	}
	
	public String getPacoteCompleto() {
		return pacoteCompleto;
	}
	
	public String getNomeMetodo() {
		return nomeMetodo;
	}
	
	public Map<String, Object> getParametros() {
		return parametros;
	}
}
