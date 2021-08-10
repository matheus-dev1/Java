
public class TestaPontoFlutuante {
	public static void main(String[] args) {
		double salario = 5000.60;
		System.out.println("Meu salario eh: " + salario);
		
		double idade = 44;
		System.out.println(idade);
		
		double divisao = 3.14 / 2;
		System.out.println("divisao: " + divisao);
		
		// Ele vai me atribuir um valor inteiro porque o tipo da variavel eh inteiro.
		// E nao pode colocar valor flutuante em uma atribuicao do tipo inteiro.
		int outraDivisao = 5 / 2;
		System.out.println("outra: " + outraDivisao);
		
		// Nesta divisao eu preciso pelo menos um dos numero ter um numero flutuante para que 
		// atribuicao seja do tipo flutuante
		double novaTentativa = 5.0 / 2;
		System.out.println("nova: " + novaTentativa);
	}
}
