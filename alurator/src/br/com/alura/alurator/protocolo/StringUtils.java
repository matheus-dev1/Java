package br.com.alura.alurator.protocolo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class StringUtils {

	public StringUtils() { }

	public static String convertUrlToPacote(String pacoteBase, String string, String pacote) {
		String[] urlDividia = string
				.replaceFirst("/", "")
				.split("/");
		
		// Retorna a primeira letra de uma string.
		String primeiraLetra = urlDividia[0].substring(0, 1);
		// Deixa em maiusculo.
		String maiusculoPrimeiraLetra = primeiraLetra.toUpperCase();
		// Retorna a string sem a primera letra.
		String urlSemPrimeiraLetra = urlDividia[0].substring(1);
		// Concatenando a variavel "maiusculoPrimeiraLetra" com a variavel "urlSemPrimeiraLetra"
		String urlCamada = maiusculoPrimeiraLetra.concat(urlSemPrimeiraLetra);
		System.out.println(urlCamada);
		String url = pacoteBase + urlCamada + pacote;
		System.out.println(url);
		return url;
	}

	public static String[] UrlArraySemParametros(String url) {
		String urlCamadas = url.replaceFirst("/", " ").split("[?]")[0];
		String[] urlCamadasArray = urlCamadas.split("/");
		return urlCamadasArray;
	}

	public static List<String> urlPrimeiraParte(String url) {
		String urlCamadas = url.replaceFirst("/", "").split("[?]")[0];
		String[] urlCamadasArray = urlCamadas.split("/");
		
		String primeiraLetraPrimeiraPalavra = urlCamadasArray[0].substring(0, 1);
		String primeiraLetraSegundaPalavra = urlCamadasArray[1].substring(0, 1);
		
		String maiusculoPrimeiraLetraPrimeiraPalavra = primeiraLetraPrimeiraPalavra.toUpperCase();
		String maiusculoPrimeiraLetraSegundaPalavra = primeiraLetraSegundaPalavra.toLowerCase();
		
		String primeiraPalavraSemPrimeiraLetra = urlCamadasArray[0].substring(1);
		String segundaPalavraSemPrimeiraLetra = urlCamadasArray[1].substring(1);
		
		String urlPrimeiraCamada = maiusculoPrimeiraLetraPrimeiraPalavra.concat(primeiraPalavraSemPrimeiraLetra);
		String urlSegundaCamada = maiusculoPrimeiraLetraSegundaPalavra.concat(segundaPalavraSemPrimeiraLetra);
		
		List<String> urlPrimeiraParte = new ArrayList<>();
		
		urlPrimeiraParte.add(urlPrimeiraCamada);
		urlPrimeiraParte.add(urlSegundaCamada);
		
		return urlPrimeiraParte;
	}
	
	public static Map<String, Object> parametrosMap(String url) {
		String urlParametros = url.replaceFirst("/", "").split("[?]")[1];
		String[] urlSeparada = urlParametros.split("&");
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		for (int i = 0; i < urlSeparada.length; i++) {
			if(urlSeparada[i].contains("=")) {
				String parametrosEValores[] = urlSeparada[i].split("=");
				parametros.put(parametrosEValores[0], parametrosEValores[1]);
			}
		}
		
		Set<Entry<String, Object>> parametrosMap = parametros.entrySet();
		parametrosMap.forEach((number) -> {
			System.out.println("Chave: " + number.getKey() + " | " + "Valor: '" + number.getValue() + "'");
		});
		
		return parametros;
	}
}
