public class FluxoComTratamento {
	public static void main(String[] args) {
		long tempoInicial = System.currentTimeMillis();

		System.out.println("Inicio do main...");
		FluxoComTratamento.metodo1();
		System.out.println("Fim do main...");
		
		long tempoFinal = System.currentTimeMillis();

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
		// Aqui eu estou instanciando a classe ArithmeticException e armazenando em uma referencia do mesmo tipo.
		// --- ArithmeticException excecao = new ArithmeticException();
		
		// NullPointerException possui dois contrutores, um sem parametro e outro com uma string, que seria atribuida a metodo .getMensage();
		NullPointerException excecao2 = new NullPointerException("Referencia vazia...");
		
		// "throw" manda a exceção ser lançada. 
		// Este método lança uma exceção mas não exige que ela seja tratada por seus chamadores. 
		// Ele usa o que se chama unckecked exception, ou seja, uma exceção é lançada mas nada obriga ela ser tratada. É tratado em tempo de execução.
		
		// Obs: Na linha 23 eu coloquei um try/catch com a referencia desta exceção (ArithmeticException).
		// Quando "thro" é executado ele vai encerrando toda a hierarquia do stacktrace ate encontrar algum catch que trate esta excecao ou encerar a aplicação.
		// --- throw excecao;
		
		// Como eu não coloquei um catch para este throw, ele vai executar NullPointerException, e eu nao tenho
		// um tratamento pra esta exceção, então ele vai executar, ir finalizando todos os metodos da 
		// stacktrace ate encerar o programa. Se por exemplo eu tivesse um tratamento para esta exceção
		// em algum metodo que chamou este metodo, ele iria tratar esta exceção e poderia continuar o programa.
		
		// O "throw" funciona apenas com exceções, ou seja, classes que herdam de Exception, eu não posso tentar jogar uma classe minha.
		
		// Nao pode ter nenhum codigo depois do throw.
		
		System.out.println("Fim do metodo2");
		
		// Normalmente quando queremos lançar uma exceção, nos não guardamos uma referencia, nos instanciamos e ja jogamos.
		// Exemplo: throw new NullPointerException("Referencia vazia...");
		throw excecao2;
	}
}
