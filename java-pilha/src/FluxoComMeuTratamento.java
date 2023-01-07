public class FluxoComMeuTratamento {
	public static void main(String[] args) {
		System.out.println("Inicio do main...");
		try {
			FluxoComMeuTratamento.metodo1();
			// Catch Polimorfico | Ao passar a classe Exception ele pode capturar toda e qualquer exceção que pode acontecer.
		} catch(Exception excecao) {
			System.out.println("Classe: " + excecao.getClass());
			System.out.println("Mensagem da Excexao: " + excecao.getMessage());
			System.out.print("Rastro da Exception: ");
			excecao.printStackTrace();
			System.out.println("Objeto de Referencia: " + excecao);
		}
		System.out.println("Fim do main...");
	}
	
	public static void metodo1() {
		System.out.println("Inicio do metodo1");
		FluxoComMeuTratamento.metodo2();
		System.out.println("Fim do metodo1");
	}
	
	public static void metodo2() {
		System.out.println("Inicio do metodo2");
		throw new MinhaExcecao("Essa é a minha excecao!");
	}
}
