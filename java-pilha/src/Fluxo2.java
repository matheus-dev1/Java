public class Fluxo2 {

	// Minha main tem um throws de uma exceção minha personalizada.
	public static void main(String[] args) throws MinhaExcecaoApenasException  {
		System.out.println("Inicio do main...");
		// Como o metodo1 chama o metodo2 e o metodo2 chamada o dep da classe de conta e ele pode causar uma
		// exceção(MinhaExcecaoApenasException), então ele me obriga a implementar um try catch ou um throws.
		Fluxo2.metodo1();
		System.out.println("Fim do main...");
	}
	
	public static void metodo1() {
		System.out.println("Inicio do metodo1");
		// Tenta executar o método, porem como o metodo2 causa uma exceção e essa exceção nao foi tratada,
		// ele encera o metodo2 e volta para o catch() do metodo1, e entao ele trata a exceção.
		try {
			Fluxo2.metodo2();
			// Aqui temos uma excecao do tipo ArithmeticException.
			// ArithmeticException é uma classe, ou seja, pode ser instanciada.
			// E "ArithmeticException exceção" é um objeto de referencia a classe ArithmeticException.
			
			// Podemos ter diversos catch()
			// Podemos tambem colocar mais de uma exceção em um catch assim:
			// catch(NullPointerException | ArithmeticException excecao) Multi-Catch
			// E observe que diferente do metodo1, eu não coloquei o throws na no contrato do metodo e sim no catch.
		} catch(MinhaExcecaoApenasException | NullPointerException | ArithmeticException excecao) {
			System.out.println("Classe: " + excecao.getClass());
			System.out.println("Mensagem da Excexao: " + excecao.getMessage());
			System.out.print("Rastro da Exception: ");
			excecao.printStackTrace();
			System.out.println("Objeto de Referencia: " + excecao);
		}		
		
		System.out.println("Fim do metodo1");
	}
	
	// Método2 que realmente lança a exceção.
	public static void metodo2() throws MinhaExcecaoApenasException {
		System.out.println("Inicio do metodo2");
		for(int index = 1; index <= 3; index++) {
			System.out.print(index + " ");
			// Vai me dar um erro de NullPointerException, isso porque eu estou tentando usar metodo de uma classe que nem foi instanciada.
			Conta conta = null;
			// Estoura a exceção aqui
			conta.dep();
			// Ou aqui
			// int a = 1 / 0;
		}
		System.out.println("Fim do metodo2");
	}
}
