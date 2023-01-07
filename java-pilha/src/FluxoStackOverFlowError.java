public class FluxoStackOverFlowError {
	public static void main(String[] args) {
		// Inicia a contagem do tempo de execu��o do programa, que basicamente � o tempo em que durou toda a sua execu��o at� o seu encerramento.
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
		// Vai ficar chamando a mesma classe varias vezes e vai causar uma exception chamada StackOverFlowException.
		// A exce��o StackOverflowException � gerada quando a pilha de execu��o estoura por conter excesso de chamadas de m�todo aninhadas.
		metodo2();
		System.out.println("Fim do metodo2");
	}
}
