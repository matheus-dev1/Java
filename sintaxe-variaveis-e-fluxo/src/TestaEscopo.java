
public class TestaEscopo {
	public static void main(String[] args) {
		// Variaveis Locais/Temporarias | O escopo de uma variavel esta restrita as chaves do seu metodo.
		// Variaveis locals/Temporarias nao possui um valor especifico, mesmo com tipo definido, entao antes
		// de usar voce precisa definir um valor, que represente, o tipo da variavel eh claro.
		int quantidadePessoas = 3;
		boolean acompanhado;
		
		if (quantidadePessoas > 2) {
			acompanhado = true;
		} else {
			acompanhado = false;
		}
		
		System.out.println(acompanhado);
	}
}
