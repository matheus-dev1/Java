package br.com.alura.io.teste;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TesteUnicodeEnconding {

	public static void main(String[] args) throws IOException {
		String string = "çãoa";
		// Code point o numero associado a esta string na tabela unicode.
		// Ele analisa apenas 1 caractere, entao temos que definir a posicao do caractere.
		System.out.println(string.codePointAt(0));
		
		// Nao precisa instanciar...
		// No windows ele usar o enconding windows-1252
		System.out.println(Charset.defaultCharset());
		
		// Me retorna quando bytes tem minha string no enconding windows-1252
		byte[] bytes = string.getBytes();
		System.out.println(bytes.length + " - windows-1252");
		// No construtor da classe String nos conseguimos converter uma valor em bytes para String.
		// Basta instanciar uma classe String e passar os bytes e posso colocar no segundo argumento
		// o enconding desejado tambem, se voce nao colocar ele vai usar o padrao do SO.
		System.out.println(new String(bytes, "windows-1252"));
		
		// Alterando o enconding.
		bytes = string.getBytes("UTF-8");
		System.out.println(bytes.length + " - UTF-8");
		System.out.println(new String(bytes, "UTF-8"));
		
		bytes = string.getBytes("UTF-16");
		System.out.println(bytes.length + " - UTF-16");
		System.out.println(new String(bytes, "UTF-16"));
		
		// Unicode Table -> Enconding(windows-1252, UTF-8, UTF-16, ASCII)
		bytes = string.getBytes(StandardCharsets.US_ASCII); // Ou "ASCII"
		System.out.println(bytes.length + " - ASCII");
		System.out.println(new String(bytes, "ASCII"));
		
		// Serializacao eh tranformar o nosso objeto instanciado que esta na memoria/JVM
		// e tranformar em fluxo de bites e bytes, mas tambem pode ser o contrario.
	}

}
