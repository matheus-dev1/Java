package br.com.alura.utils;

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
}
