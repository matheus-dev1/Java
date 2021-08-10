
public class Programa {
	public static void main(String[] args) {
		// Carro carro = new Carro(2013, "Gol", 35000.0);
		
		// A ideia de usar o this() eh para aproveitas a logica de outro construtor.
		
		// Ocorre o seguinte eu preciso apenas de dois parametros para instancias o objeto e executar o construtor
		// com dois parametros, porem dentro deste construtor, possui outro construtor, e ele eh executado tambem.
		Carro outroCarro = new Carro("Civic", 95000.0);
	}
}
