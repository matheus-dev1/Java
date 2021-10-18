package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrdenaStrings {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("ccc");
		palavras.add("a");
		palavras.add("bb");
		
		Comparator<String> comparador = new ComparadorPorTamanho();
		
		// Collections.sort(palavras); - Comparador padr�o
		// Collections.sort(palavras, comparador); - Comparador nosso.
		// Metodo da propria lista de ordena��o com o parametro de ordena��o por tamanho da string.
		
		/*
		 * � um default method! Um m�todo de interface que voc� n�o precisa implementar
		 * na sua classe se n�o quiser, pois voc� ter� j� essa implementa��o default.
		 * Default Methods - adicionar m�todos em interfaces e implement�-los ali mesmo! 
		 */
		
		palavras.sort(comparador);
		
		System.out.println("---------------------------------------");
		
		System.out.println(palavras);
		
		for (String p : palavras) {
			System.out.println(p);
		}
		
		Consumer<String> consumidor = new ImprimeNaLinha();
		
		// Classe/interface anonima - Eu n�o preciso declarar uma classe e escrever o seu metodo,
		// eu posso diretamente ja escrever e depois instancia, eu posso j� instanciar implementando
		// o metodo.
		
		// S�o as chamadas classes an�nimas, que usamos com frequ�ncia para implementar 
		// listeners e callbacks que n�o ter�o reaproveitamento.
		
		System.out.println("---------------------------------------");
		
		palavras.forEach(new Consumer<String>() {
			@Override
		    public void accept(String s) {
		        System.out.println(s);
		    }
		});
		
		System.out.println("---------------------------------------");
		
		palavras.forEach(consumidor);
		/* Tendo essas dificuldade e verbosidade da sintaxe das classes an�nimas em vista, o
		 * Java 8 traz uma nova forma de implementar essas interfaces ainda mais sucinta.
		 * � a sintaxe do lambda. Em vez de escrever a classe an�nima, deixamos de escrever
		 * alguns itens que podem ser inferidos.
		 * Como essa interface s� tem um m�todo, n�o precisamos escrever o nome do m�todo. 
		 * Tamb�m n�o daremos new. Apenas declararemos os argumentos e o bloco a ser executado,
		 * separados por "->"
		 */
		
		System.out.println("---------------------------------------");
		
		// O java vai saber que o forEach recebe consumer, ele vai tentar atribuir o valor do parametro
		// dentro de forEach escrito desta maneira para dentro do consumer
		// Obs: Esse codigo: "s -> System.out.println(s)" � equivalentea toda a classe "ImprimeNaLinha"
		palavras.forEach(s -> System.out.println(s));
		
		System.out.println("---------------------------------------");
		
		// O lambda funciona sempre que voc� tem apenas um metodo abstrato, ou seja,
		// uma interface funcional
		
		palavras.sort((s1, s2) -> {
			if(s1.length() < s2.length()) {
				return -1;
			}
			if(s1.length() > s2.length()) {
				return 1;
			}
			return 0;
		});
		
		// Faz a mesma coisa que o metodo compare de cima e da classe ComparadorPorTamanho
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		System.out.println(palavras);
		
		System.out.println("---------------------------------------");
		
		palavras.sort((s1, s2) -> (s1.length() < s2.length()) ? -1 : ((s1.length() == s2.length() ? 0 : 1)));
	
		System.out.println(palavras);
		
		System.out.println("---------------------------------------");
		
		// voc� pode ter um m�todo default que � est�tico. Esse � o caso do Comparator.comparing,
		// que � uma f�brica, uma factory, de Comparator. Passamos o lambda para dizer qual
		// ser� o crit�rio de compara��o desse Comparator
		
		/// Ent�o neste caso, a cada intera��o deste ordenaento a palavra em cada indice vai ser
		// tranformado em uma inteiro com base em quantos caracteres tem a string do la�o atual.
		// E o criteiro de compara��o � o padr�o.
		palavras.sort(Comparator.comparing(s -> s.length()));
		// this::length - Sendo this a string do la�o
		// Fazemos uma refer�ncia ao m�todo (method reference)
		palavras.sort(Comparator.comparing(String::length));
		Comparator<String> comparadorDeStrings = Comparator.comparing(s -> s.length());
		palavras.sort(comparadorDeStrings);
		
		// Dado uma string ele vai devolver uma integer.
		Function<String, Integer> funcao = s -> s.length();
		Comparator<String> comparadorDeStrings2 = Comparator.comparing(funcao);
		
		Function<String, Integer> semLambda = new Function<String, Integer>() {

			@Override
			public Integer apply(String s) {
				return s.length();
			}
		};
	}

}

// Com a Interface Comparator nos podemos criar um nova class que implementa um metodo em que nos 
// podemos alterar o crit�rio de compara��o
class ComparadorPorTamanho implements Comparator<String> {

	// O contrato da interface Comparator diz que devemos devolver um n�mero negativo se o primeiro
	// objeto for menor que o segundo, um n�mero positivo caso contr�rio e zero se forem equivalentes.
	// Exemplo, se a lista em que eu passo tem 3 items e os items s�o a, ccc e bb, nesta ordem mesmo
	// e eu quero testar pelo length da string, ele vai testar a primeira string com a segunda 
	// depois a primera com a terceira, depos a segunda com a terceira e me retornar uma ordena��o
	// com base no length de cada string.
	@Override
	public int compare(String s1, String s2) {
		if(s1.length() < s2.length()) {
			return -1;
		}
		if(s1.length() > s2.length()) {
			return 1;
		}
		return 0;
	}
	
}

class ImprimeNaLinha implements Consumer<String> {

	// Toda a vez em que eu vou consumir uma string ele deve fazer alguma coisa... No caso sysout :)
	@Override
	public void accept(String s) {
		System.out.println(s);
	}
	
}