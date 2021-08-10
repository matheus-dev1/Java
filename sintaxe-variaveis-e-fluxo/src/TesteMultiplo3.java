
public class TesteMultiplo3 {
	public static void main(String[] args) {
		for(int contador = 0; contador <= 100; contador++) {
			// Se o valor atual do contador dividido ter resto da divisao igual a zero execute o bloco de comandos.
			if (contador % 3 == 0) {
				System.out.println(contador);
			}
		}
	}
}
