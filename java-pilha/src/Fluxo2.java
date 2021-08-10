public class Fluxo2 {

	public static void main(String[] args) throws MinhaExcecaoApenasException {
		System.out.println("Inicio do main...");
		Fluxo2.metodo1();
		System.out.println("Fim do main...");
	}
	
	public static void metodo1() throws MinhaExcecaoApenasException {
		System.out.println("Inicio do metodo1");
		// Tenta executar o metodo, porem como o metodo2 causa uma excecao e essa excecao nao foi tratada,
		// ele encera o metodo2 e volta para o catch() do metodo1, e entao ele trata a excecao.
		try {
			Fluxo2.metodo2();
			// Aqui temos uma excecao do tipo ArithmeticException.
			// ArithmeticException eh uma classe, ou seja, pode ser instanciada.
			// E "ArithmeticException excecao" eh um objeto de referencia a classe ArithmeticException.
		} catch(ArithmeticException excecao) {
			System.out.println("Classe: " + excecao.getClass());
			System.out.println("Mensagem da Excexao: " + excecao.getMessage());
			System.out.print("Rastro da Exception: ");
			excecao.printStackTrace();
			System.out.println("Objeto de Referencia: " + excecao);
			// Podemos ter diversos catch()
			// Podemostambem colocar mais de uma excecao em um catch assim:
			// catch(NullPointerException | ArithmeticException excecao) Multi-Catch
		} catch(NullPointerException excecao) {
			System.out.println("Classe: " + excecao.getClass());
			System.out.println("Mensagem da Excexao: " + excecao.getMessage());
			System.out.print("Rastro da Exception: ");
			excecao.printStackTrace();
			System.out.println("Objeto de Referencia: " + excecao);
		}		
		
		System.out.println("Fim do metodo1");
	}
	
	public static void metodo2() throws MinhaExcecaoApenasException {
		System.out.println("Inicio do metodo2");
		for(int index = 1; index <= 3; index++) {
			System.out.println(index);
			// int a = 1 / 0;
			Conta conta = null;
			conta.dep();
		}
		System.out.println("Fim do metodo2");
	}
}
