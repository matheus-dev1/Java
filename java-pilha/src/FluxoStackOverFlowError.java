public class FluxoStackOverFlowError {

	public static void main(String[] args) {
		// Inicia a contagem do tempo de execucao do programa, que basicamente eh o tempo em que durou
		// toda a sua execucao ate o seu encerramento.
		long tempoInicial = System.currentTimeMillis();

		System.out.println("Inicio do main...");
		FluxoStackOverFlowError.metodo1();
		System.out.println("Fim do main...");
		
		// Armanena na variavel o tempo em que ele terminou a execucao.
		long tempoFinal = System.currentTimeMillis();

		// Exibe o tempo.
		System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
	}
	
	public static void metodo1() {
		System.out.println("Inicio do metodo1");
		
		try {
			FluxoStackOverFlowError.metodo2();
		} catch(ArithmeticException excecao) {
			System.out.println("Classe: " + excecao.getClass());
			System.out.println("Mensagem da Excexao: " + excecao.getMessage());
			System.out.print("Rastro da Exception: ");
			excecao.printStackTrace();
			System.out.println("Objeto de Referencia: " + excecao);
		}		
		
		System.out.println("Fim do metodo1");
	}
	
	public static void metodo2() {
		System.out.println("Inicio do metodo2");
		// java.lang.StackOverflowError | Vai ocorrer este erro.
		metodo2();
		System.out.println("Fim do metodo2");
	}
}
