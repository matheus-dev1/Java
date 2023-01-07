/* Checked
   As classes que herdam de "Exception", é do tipo "Checked", então elas solicitam que a exceção seja tratada de alguma 
   forma, colocando o throws na assinatura do metodo ou usando um try/catch */
public class MinhaExcecaoApenasException extends Exception {
	private static final long serialVersionUID = 310024485027041169L;

	public MinhaExcecaoApenasException(String mensagem){
		/* O super é um metodo reservador que representa o contrutor da classe herdada, neste caso, como eu vou herdar de
		 RuntimeException que herda de uma serie de classes até chegar na Throwable em que realmente armazena este 
		 valor, e nos disponibiliza para usar na super(). */
		super(mensagem);
		System.out.println("Algo a mais em MinhaExcecaoApenasException");
	}
}
