public class Fluxo2 {

	// Minha main tem um throws de uma exce��o minha personalizada.
	public static void main(String[] args) throws MinhaExcecaoApenasException  {
		System.out.println("Inicio do main...");
		// Como o metodo1 chama o metodo2 e o metodo2 chamada o dep da classe de conta e ele pode causar uma
		// exce��o(MinhaExcecaoApenasException), ent�o ele me obriga a implementar um try catch ou um throws.
		Fluxo2.metodo1();
		System.out.println("Fim do main...");
	}
	
	public static void metodo1() {
		System.out.println("Inicio do metodo1");
		// Tenta executar o m�todo, porem como o metodo2 causa uma exce��o e essa exce��o nao foi tratada,
		// ele encera o metodo2 e volta para o catch() do metodo1, e entao ele trata a exce��o.
		try {
			Fluxo2.metodo2();
			// Aqui temos uma excecao do tipo ArithmeticException.
			// ArithmeticException � uma classe, ou seja, pode ser instanciada.
			// E "ArithmeticException exce��o" � um objeto de referencia a classe ArithmeticException.
			
			// Podemos ter diversos catch()
			// Podemos tambem colocar mais de uma exce��o em um catch assim:
			// catch(NullPointerException | ArithmeticException excecao) Multi-Catch
			// E observe que diferente do metodo1, eu n�o coloquei o throws na no contrato do metodo e sim no catch.
		} catch(MinhaExcecaoApenasException | NullPointerException | ArithmeticException excecao) {
			System.out.println("Classe: " + excecao.getClass());
			System.out.println("Mensagem da Excexao: " + excecao.getMessage());
			System.out.print("Rastro da Exception: ");
			excecao.printStackTrace();
			System.out.println("Objeto de Referencia: " + excecao);
		}		
		
		System.out.println("Fim do metodo1");
	}
	
	// M�todo2 que realmente lan�a a exce��o.
	public static void metodo2() throws MinhaExcecaoApenasException {
		System.out.println("Inicio do metodo2");
		for(int index = 1; index <= 3; index++) {
			System.out.print(index + " ");
			// Vai me dar um erro de NullPointerException, isso porque eu estou tentando usar metodo de uma classe que nem foi instanciada.
			Conta conta = null;
			// Estoura a exce��o aqui
			conta.dep();
			// Ou aqui
			// int a = 1 / 0;
		}
		System.out.println("Fim do metodo2");
	}
}
