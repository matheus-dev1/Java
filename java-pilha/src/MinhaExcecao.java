// Nas excecoes que herdam de RuntimeException sao chamadas de unchecked, ou seja, elas nao solcitam
// que no metodo em que tem um throws voce especifique na assinatura do metodo este throws.
public class MinhaExcecao extends RuntimeException {
	public MinhaExcecao(String mensagem){
		// super(), vai invocar o construor da classe herdada, neste caso eu vou herdar de varias classes
		// ate chegar na throwable que armazena este valor, e nos disponibilizar para usar em outro metodo.
		super(mensagem);
	}
}
