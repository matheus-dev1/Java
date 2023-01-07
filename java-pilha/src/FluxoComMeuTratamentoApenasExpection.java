public class FluxoComMeuTratamentoApenasExpection {
	public static void main(String[] args) {
		System.out.println("Inicio do main...");
		try {
			FluxoComMeuTratamentoApenasExpection.metodo1();
		} catch(ArithmeticException | NullPointerException | MinhaExcecaoApenasException excecao) {
			System.out.println("Classe: " + excecao.getClass());
			System.out.println("Mensagem da Excexao: " + excecao.getMessage());
			System.out.print("Rastro da Exception: ");
			excecao.printStackTrace();
			System.out.println("Objeto de Referencia: " + excecao);
		}
		System.out.println("Fim do main...");
	}
	
	public static void metodo1() throws MinhaExcecaoApenasException  {
		System.out.println("Inicio do metodo1");
		FluxoComMeuTratamentoApenasExpection.metodo2();
		System.out.println("Fim do metodo1");
	}
	
	/* Quando a nossa exceção herda apenas de Exception, ele solicita que a exceção seja tratada, na assinatura do
	   metodo voce deve colocar a palavra chave throws, depois do nome do metodo mais o nome da exceção ou um try/catch.
	   Obs: Voce pode definir mais de uma excecao na assinatura de throws. 
	   Exemplo: throws MinhaExcecaoApenasException, MinhaExcecao */
	public static void metodo2() throws MinhaExcecaoApenasException {
		System.out.println("Inicio do metodo2");
		// Throwable possui duas vertentes, uma para erros relacionado a maquina virtual, e que normalmente
		// apenas interresam para os desenvolvedores internos e outro para exceções, que sim nos interresa.
		// Hierarquia: StackOverFlowError -> VirtualMachineError -> Error - Throwable
		throw new MinhaExcecaoApenasException("Essa é a minha excecao!");
	}
}
