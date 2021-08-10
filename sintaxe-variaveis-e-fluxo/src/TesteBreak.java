
public class TesteBreak {
	public static void main(String[] args) {
		int contador = 0;
		while(contador <= 10) {
			System.out.println(contador);
			if (contador == 5) {
				System.out.println("Acabou por aqui!!!");
				// Interrompe o laco dentro dele.
				break;
			}
			contador++;
		}
	}
}
