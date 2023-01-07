// Compilador: Ele apenas acusa erros de sintaxe.

// Todo programa Java segue uma pilha/stack do que precisa ser executado.

// No console: <terminated> significa que o programa foi encerado.
public class Fluxo {
	// Podemos executar o nosso codigo como "Debug Run" e verificar passo a passe a execução do nosso projeto.
	// Step Over e Step Into
	// "Step Over" ele pula a linha, entao ele executa a linha, entao se por exemplo for um metodo ele ja vai executar tudo do metodo de uma vez.
	// Se voce quiser entrar no metodo e executar o seu bloco de comandos de forma 
	// unitaria, pode usar o "Step Into" para entrar e step over para ir passando de linha a linha.
	public static void main(String[] args) {
		System.out.println("Inicio do main...");
		Fluxo.metodo1();
		System.out.println("Fim do main...");
	}
	
	// Métodos estáticos não requerem uma instância da classe nem podem acessar implicitamente os dados (this.) de tal instância.
	public static void metodo1() {
		System.out.println("Inicio do metodo1");
		Fluxo.metodo2();
		System.out.println("Fim do metodo1");
	}
	
	public static void metodo2() {
		System.out.println("Inicio do metodo2");
		for(int index = 1; index <= 3; index++) {
			System.out.print(index + " ");
			// Se uma exceção estourar e não forar tratada ela vai encerar o programa.
			// Uma exceção pode ter um rastro da exceção, é por onde a exceção passou até ser encerrada.
			
			// Neste exemplo a baixo nos vemos que primeiro rastro/Stacktrace da exceção se iniciou na linha 36
			// dentro do metodo "metodo2", como o "metodo2" não resolveu o problema, ele encerrou este metodo
			// e foi para o "metodo1" (que chamou o metodo2) e o ele tambem não resolveu e encerrou o "metodo1", então ele foi para main (que chamou o "metodo1")
			// e também o método "main" nao resolveu o problema encerando o programa, exibindo a excecao que ocorrou e o rastro em que ela passou.
			
			// Exception in thread "main" java.lang.ArithmeticException: / by zero
			// at Fluxo.metodo2(Fluxo.java:36)
			// at Fluxo.metodo1(Fluxo.java:26)
			// at Fluxo.main(Fluxo.java:18)
			
			// A exceção estourou porque não pode se dividir nenhum numero por zero.
			//int a = 1 / 0;
			
			// Semelhante a um if, o try{} ele tenta executar se ocorrer seu bloco de comandos.
			// Se ocorrer um exceção dentro deste bloco ele vai para a instrução if, que captura a possivel
			// exceção e armazena em uma variavel, e executa o bloco de comandos do catch(){}
			try {
				int a = 1 / 0;
			} catch(ArithmeticException e) {
				System.out.println(e);
			}
		}
		System.out.println("Fim do metodo2");
	}
}
