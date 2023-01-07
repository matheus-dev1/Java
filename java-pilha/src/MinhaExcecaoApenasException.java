/* Checked
   As classes que herdam de "Exception", � do tipo "Checked", ent�o elas solicitam que a exce��o seja tratada de alguma 
   forma, colocando o throws na assinatura do metodo ou usando um try/catch */
public class MinhaExcecaoApenasException extends Exception {
	private static final long serialVersionUID = 310024485027041169L;

	public MinhaExcecaoApenasException(String mensagem){
		/* O super � um metodo reservador que representa o contrutor da classe herdada, neste caso, como eu vou herdar de
		 RuntimeException que herda de uma serie de classes at� chegar na Throwable em que realmente armazena este 
		 valor, e nos disponibiliza para usar na super(). */
		super(mensagem);
		System.out.println("Algo a mais em MinhaExcecaoApenasException");
	}
}
