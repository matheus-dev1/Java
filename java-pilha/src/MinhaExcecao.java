/* Unchecked
   Nas classes(exce��es) que herdam de RuntimeException, elas s�o chamadas de "Unchecked", isso porque elas n�o obrigam que os metodos e
   classes que tentem usar algum metodo ou classe de pode dar essa exce��o tenha que tratar 
   esse erro, seja pela assinatura do metodo ou classe ou por um try catch */
public class MinhaExcecao extends RuntimeException {
	private static final long serialVersionUID = 2042432446655093912L;

	public MinhaExcecao(String mensagem){
		/* O super � um metodo reservador que representa o contrutor da classe herdada, neste caso, como eu vou herdar de
		 RuntimeException que herda de uma serie de classes at� chegar na Throwable em que realmente armazena este 
		 valor, e nos disponibiliza para usar na super(). */
		super(mensagem);
	}
}
