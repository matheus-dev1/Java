// Compilador: Ele apenas acusa erros de sintaxe.

// Todo programa Java segue uma pilha/stack do que precisa ser executado.

// No console: <terminated> significa que o programa foi encerado.
public class Fluxo {
	// Podemos executar o nosso codigo como "Debug Run" e verificar passo a passe a execu��o do nosso projeto.
	// Step Over e Step Into
	// "Step Over" ele pula a linha, entao ele executa a linha, entao se por exemplo for um metodo ele ja vai executar tudo do metodo de uma vez.
	// Se voce quiser entrar no metodo e executar o seu bloco de comandos de forma 
	// unitaria, pode usar o "Step Into" para entrar e step over para ir passando de linha a linha.
	public static void main(String[] args) {
		System.out.println("Inicio do main...");
		Fluxo.metodo1();
		System.out.println("Fim do main...");
	}
	
	// M�todos est�ticos n�o requerem uma inst�ncia da classe nem podem acessar implicitamente os dados (this.) de tal inst�ncia.
	public static void metodo1() {
		System.out.println("Inicio do metodo1");
		Fluxo.metodo2();
		System.out.println("Fim do metodo1");
	}
	
	public static void metodo2() {
		System.out.println("Inicio do metodo2");
		for(int index = 1; index <= 3; index++) {
			System.out.print(index + " ");
			// Se uma exce��o estourar e n�o forar tratada ela vai encerar o programa.
			// Uma exce��o pode ter um rastro da exce��o, � por onde a exce��o passou at� ser encerrada.
			
			// Neste exemplo a baixo nos vemos que primeiro rastro/Stacktrace da exce��o se iniciou na linha 36
			// dentro do metodo "metodo2", como o "metodo2" n�o resolveu o problema, ele encerrou este metodo
			// e foi para o "metodo1" (que chamou o metodo2) e o ele tambem n�o resolveu e encerrou o "metodo1", ent�o ele foi para main (que chamou o "metodo1")
			// e tamb�m o m�todo "main" nao resolveu o problema encerando o programa, exibindo a excecao que ocorrou e o rastro em que ela passou.
			
			// Exception in thread "main" java.lang.ArithmeticException: / by zero
			// at Fluxo.metodo2(Fluxo.java:36)
			// at Fluxo.metodo1(Fluxo.java:26)
			// at Fluxo.main(Fluxo.java:18)
			
			// A exce��o estourou porque n�o pode se dividir nenhum numero por zero.
			//int a = 1 / 0;
			
			// Semelhante a um if, o try{} ele tenta executar se ocorrer seu bloco de comandos.
			// Se ocorrer um exce��o dentro deste bloco ele vai para a instru��o if, que captura a possivel
			// exce��o e armazena em uma variavel, e executa o bloco de comandos do catch(){}
			try {
				int a = 1 / 0;
			} catch(ArithmeticException e) {
				System.out.println(e);
			}
		}
		System.out.println("Fim do metodo2");
	}
}
