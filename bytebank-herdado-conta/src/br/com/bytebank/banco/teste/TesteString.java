package br.com.bytebank.banco.teste;

// O unico pacote no java que nao precisa ser importado eh o java.lang.

public class TesteString {

	public static void main(String[] args) {
		// A variavel "nome" possui uma referencia do objeto String, e observe que ele nao precisa da palavra 
		// reservada "new" para instaciar um objeto do tipo String.
		String nome = "Matheus"; // Object Literal | Como isso eh uma referencia de uma classe ela eh imutavel.
		// Mas podemos instanciar da forma normal.
		String outroNome = new String("Ricardo");
		
		// Eu sempre preciso SOBREESCREVER o valor da referencia do tipo String.
		nome = nome.replace(nome, "Matheus de Olivira Silva");
		System.out.println(nome);
		System.out.println(nome.length());
		System.out.println(nome.isEmpty());
		
		// A classe String recebem uma variável do tipo CharSequence. O tipo CharSequence é uma 
		// interface que a própria classe String implementa (pois uma String é uma sequência de caracteres!)
		CharSequence charSeq = new StringBuilder("AAA");
		System.out.println(charSeq);
		
		// O StringBuilder é uma classe comum. Repare que usamos o new para a criação do objeto.
		// Além disso, como o objeto é mutável, utilizamos a mesma referência, sem novas atribuições.
		StringBuilder builder = new StringBuilder("Socorram");
		builder.append("-");
		builder.append("me");
		builder.append(", ");
		builder.append("subi ");
		builder.append("no ");
		builder.append("ônibus ");
		builder.append("em ");
		builder.append("Marrocos");
		String texto = builder.toString();
		System.out.println(texto);
	}

}
