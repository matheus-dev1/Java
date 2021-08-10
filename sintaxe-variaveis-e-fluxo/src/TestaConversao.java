
public class TestaConversao
{
	public static void main(String[] args) {
		double salario = 1270.59;
		// No ponto flutuante nos precisamos colocar o F no final.
		float potnoFlutuante = 3.14F;
		// Type Casting - Convertendo o tipo do valor de uma variavel, neste caso eu estou 
		// convertendo uma variavel do tipo flutuante para o tipo inteiro, porem temos que
		// lembrar que tipos inteiros nao possuiem ponto flutuante entao o valor
		//1270.59 vai ficar 1270
		int valor = (int) salario;
		System.out.println(valor);
		
		// No long nos precisamos colocar o L no final.
		long numeroGrande = 434323232;
		short valorPequeno = 21313;
		byte valorMinusculo = 127;
	}
}
