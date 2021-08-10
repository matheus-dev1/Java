
public class TesteSomatoria {
	public static void main(String[] args) {
		int contador = 0;
		int total = 0;
		while(contador <= 1000) {
			// total = total + contador;
			total += contador;
			System.out.println(total);
			contador++;
		}
	}
}
