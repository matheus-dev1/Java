
public class TestaCaracteres {
	public static void main(String[] args) {
		// Guarda apenas uma letra. 
		// char tem que ser definida com aspas simples.
		// No fundo ele um numero, porem ele converte quando eu uso o system.out
		char letra = 'a';
		System.out.println(letra);
		
		// O char sempre vai exibir apenas um caractere e ele segue a table ASCII como referencia
		// entao por exemplo na table ascii o valor decimal 65 eh um 'a'.
		char valor = 245;
		System.out.println(valor);
		
		// Quando voce esta fazendo uma operacao com dois tipos diferentes, o java me da o 
		// resultado no maior dos tipos.
		// Isso da errado por um inteiro(que seria o retorno desta operacao) nao cabe em 
		// valor porque valor posseui apenas 1 byte enquanto um inteiro possui 4 bytes.
		
		// Para resolver isso nos podemos usar o type casting.
		// Primeiro nos temos que pegar o valor da variavel "valor" somar com mais 1 dentro de 
		// um parenteses porque assim eu vou emcapsular o meu retorno apenas para inteiro.
		// Porem depois deste emcapsulamento eu consigo usar o type casting do tipo char
		// para converter este valor inteiro em um caractere conforme a tabela ASCII.
		valor = (char) (valor + 1);
		System.out.println(valor);
		
		// String na realidade eh um objeto que possui diversos metodos.
		String palavra = "aaa";
		System.out.println(palavra);
	}
}
