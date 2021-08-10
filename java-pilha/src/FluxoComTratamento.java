public class FluxoComTratamento {

	public static void main(String[] args) {
		// Inicia a contagem do tempo de execucao do programa, que basicamente eh o tempo em que durou
		// toda a sua execucao ate o seu encerramento.
		long tempoInicial = System.currentTimeMillis();

		System.out.println("Inicio do main...");
		FluxoComTratamento.metodo1();
		System.out.println("Fim do main...");
		
		// Armanena na variavel o tempo em que ele terminou a execucao.
		long tempoFinal = System.currentTimeMillis();

		// Exibe o tempo.
		System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
	}
	
	public static void metodo1() {
		System.out.println("Inicio do metodo1");
		
		try {
			FluxoComTratamento.metodo2();
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

		// Aqui eu estou instanciando a classe ArithmeticException e armazenando em uma referencia do mesmo
		// tipo.
		// ------------------ ArithmeticException excecao = new ArithmeticException();
		
		// NullPointerException possui dois contrutores, um sem parametro e outro com uma string, que seria
		// atribuida a metodo .getMensage();
		NullPointerException excecao2 = new NullPointerException("Referencia vazia...");
		
		// throw manda a exceção ser lançada. 
		// Este método lança uma exceção mas não exige que ela seja tratada por seus chamadores. 
		// Ele usa o que se chama unckecked exception, ou seja, uma exceção é lançada mas nada obriga
		// ela ser tratada. É tratado em tempo de execução.
		
		// Obs: Na linha 23 eu difini um try catch com a referencia desta excecao(ArithmeticException).
		// Quando throw eh executado ele vai encerrando toda a hierarquia do stacktrace ate possivelmente 
		// encontrar algum catch que trate esta excecao.
		// ------------------ throw excecao;
		
		// Como eu nao defini um catch para este throw, ele vai executar NullPointerException, e eu nao tenho
		// um tratamento pra esta excecao, entao ele vai executar, ir finalizando todos os metodos da 
		// stacktrace ate encerar o programa. Se por rxemplo eu tivesse um tratamento para esta excecao
		// em algum metodo que chamou este metodo, ele iria tratar esta excecao.
		
		// O throw funciona apenas com excecoes, eu nao posso tentar jogar uma classe minha.
		
		// Nao pode ter nenhum codigo depois do throw.
		
		// Normalmente quando queremos "jogar" uma excecao, nos nao guardamos uma referencia, nos instanciamos
		// e ja jogamos. Exemplo: throw new NullPointerException("Referencia vazia...");
		throw excecao2;
		
		// System.out.println("Fim do metodo2");
	}
}
