package java8;

public class TestaStringBuilder {
	// A classe StringBuilder faz parte do pacote java.lang. Essa classe permite criar e manipular dados
	// de Strings dinamicamente, ou seja, podem criar variáveis de String modificáveis.
	
	/*
	 * Métodos StringBuilder
	 * Abaixo são apresentados os métodos principais e mais utilizados.
	 * length - Retorna o número de caracteres atualmente em um StringBuilder;
	 * capacity – Retorna o número de caracteres que pode ser armazenado em um StringBuilder sem alocar mais memória;
	 * ensureCapacity – Garante que um StringBuilder tenha pelo menos a capacidade especificada;
	 * setLength – Aumenta ou diminui o comprimento de uma StringBuilder;
	 * charAt – Aceita um argumento inteiro que representa o índice e retorna o caractere nessa posição no StringBuilder;
	 * setCharAt – Copia caracteres de um StringBuilder no array de caracteres passado como um argumento, tendo aceitação de até 4 argumentos;
	 * o índice inicial a partir do qual os caractere(s) devem ser copiados do StringBuilder;
	 * o índice um a mais do último caractere que será copiado a partir do StringBuilder;
	 * o array de caracteres para onde os caracteres serão copiados;
	 * localização inicial no array de caracteres em que o primeiro caractere deve ser colocado;
	 * 
	 * getChars – Retorna o caractere especificado;
	 * reverse – Retorna os caracteres invertidos;
	 * */
	
	public static void main(String[] args) {
		StringBuilder stringBuilderXmlProduto = new StringBuilder();
		stringBuilderXmlProduto.append("<produto>");
			stringBuilderXmlProduto.append("<nome>");
				stringBuilderXmlProduto.append("Produto1");
			stringBuilderXmlProduto.append("</nome>");
			
			stringBuilderXmlProduto.append("<valor>");
				stringBuilderXmlProduto.append("20.0");
			stringBuilderXmlProduto.append("</valor>");
			
			stringBuilderXmlProduto.append("<marca>");
				stringBuilderXmlProduto.append("Marca1");
			stringBuilderXmlProduto.append("</marca>");
		stringBuilderXmlProduto.append("</produto>");
		
		System.out.println(stringBuilderXmlProduto.toString());
		
		System.out.println("Quantidade de caracteres no StringBuilder: " + stringBuilderXmlProduto.length());
		
		System.out.println("Capacity do StringBuilder: " + stringBuilderXmlProduto.capacity());
		
		stringBuilderXmlProduto.ensureCapacity(150);
		// printf - Print com parametros.
	    System.out.printf("Nova Capacidade de caracteres = %d\n\n", stringBuilderXmlProduto.capacity());
	    
	    // Redefine o tamanho do StringBuilder, podendo aumentar ou diminuir o que tinha dentro.
	    stringBuilderXmlProduto.setLength(10);
	    System.out.printf("Novo tamanho = %d\n buffer = %s\n", stringBuilderXmlProduto.length(), stringBuilderXmlProduto.toString());
	    
	    System.out.printf("Caracteres nessa posição no StringBuilder: %s/produto%s", stringBuilderXmlProduto.charAt(0), stringBuilderXmlProduto.charAt(8));
	}
}
