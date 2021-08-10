// Na categoria que herdam de Exception, basicamente eles solicitam que todo metodo que usamos o um throw
// nos temos que colocar na assinatura do metodo qual eh o throw e se este metodo for invocado por outro
// o que invocou tambem deve ter a assinatura do throw ou vove pode fazer um try no metodo que invocou o 
// outro metodo.

// Exemplo: public static void metodo () throws MinhaExcecaoApenasException

// Obs: Na hora de rodar/executar nao tem diferenca!
public class MinhaExcecaoApenasException extends Exception {
	public MinhaExcecaoApenasException(String mensagem){
		// super(), vai invocar o construor da classe herdada, neste caso eu vou herdar de varias classes
		// ate chegar na throwable que armazena este valor, e nos disponibilizar para usar em outro metodo.
		super(mensagem);
	}
}
