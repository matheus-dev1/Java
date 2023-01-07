public class FluxoComCatchPolimorfico {
	public static void main(String[] args) {
		System.out.println("Inicio do main...");
		try {
			FluxoComCatchPolimorfico.metodo1();
		} catch(ArithmeticException | NullPointerException | MinhaExcecao excecao) {
			System.out.println("Classe: " + excecao.getClass());
			System.out.println("Mensagem da Excexao: " + excecao.getMessage());
			System.out.print("Rastro da Exception: ");
			excecao.printStackTrace();
			System.out.println("Objeto de Referencia: " + excecao);
		}
		System.out.println("Fim do main...");
	}
	
	// metodo1 chamda o metodo2
	public static void metodo1() {
		System.out.println("Inicio do metodo1");
		FluxoComCatchPolimorfico.metodo2();
		System.out.println("Fim do metodo1");
	}
	
	public static void metodo2() {
		System.out.println("Inicio do metodo2");
		// HEAP, onde os objetos do Java s�o criados/armazenados (Memoria de Objetos)
		// N�o somo obrigados a implementar um throws ou try/catch porque a exce��o MinhaExcecao � do tipo unchecked
		throw new MinhaExcecao("Essa � minha exce��o!");
	}
}
