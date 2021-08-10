// Compilador: Ele apenas acusa erros de sintaxe.

// Todo programa Java segue uma pilha/stack do que precisa ser executado.
// <terminated> significa que o programa foi encerado.
public class Fluxo {
	// Podemos executar o nosso codigo como Debug Run e verificar passo
	// a passe a execucao do nosso projeto.
	
	// Step Over ele pula a linha, entao ele executa a linha, entao se por exemplo
	// for um metodo ele ja vai executar tudo do metodo de uma vez.
	// Se voce quiser entrar no metodo e executar o seu bloco de comandos 
	// de forma unitaria, pode usar o step into para entrar e step over para
	// ir passando de linha a linha.
	public static void main(String[] args) {
		System.out.println("Inicio do main...");
		// Eu posso colocar a classe em que ele foi definido como static.
		// Mas isso e implicito nao eh necessario.
		Fluxo.metodo1();
		System.out.println("Fim do main...");
	}
	
	// Métodos estáticos não requerem uma instância da classe nem podem acessar implicitamente
	// os dados (this.) de tal instância.
	public static void metodo1() {
		System.out.println("Inicio do metodo1");
		Fluxo.metodo2();
		System.out.println("Fim do metodo1");
	}
	
	public static void metodo2() {
		System.out.println("Inicio do metodo2");
		for(int index = 1; index <= 3; index++) {
			System.out.println(index);
			// Se a Excecao nao for tratada o programa ENCERRA!
			// Uma excecao pode ter um rastro da excecao, eh por onde a excecao passou.
			
			// Neste exemplo a baixo nos vemos que primeiro rastro/Stacktrace da excecao se iniciou na linha 36
			// dentro do metodo "metodo2", como o metodo2 nao resolveu o problema, ele encerrou este metodo
			// e foi para o "metodo1" e o ele tambem nao resolveu e encerrou o metodo1, entao ele foi para main
			// e tambem o metodo "main" nao resolveu o problema encerando o programa, exibindo a excecao 
			// que ocorrou e o rastro em que ela passou.
			
			// Exception in thread "main" java.lang.ArithmeticException: / by zero
			// at Fluxo.metodo2(Fluxo.java:36)
			// at Fluxo.metodo1(Fluxo.java:26)
			// at Fluxo.main(Fluxo.java:18)
			
			//int a = 1 / 0;
			
			// Semelhante a um if, o try{} ele tenta executar se ocorrer seu bloco de comandos.
			// Se ocorrer um excecao dentro deste bloco ele vai para a instrucao if, que captura a possivel
			// excecao e armazena em uma variavel, e executa o bloco de comandos do catch(){}
			try {
				int a = 1 / 0;
			} catch(ArithmeticException e) {
				System.out.println(e);
			}
		}
		System.out.println("Fim do metodo2");
	}
}
