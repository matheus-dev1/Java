
public class TesteFatorial {
	public static void main(String[] args) {
		int total = 1;
		for(int contador = 1; contador <= 6; contador++) {
			total = total * (contador + 1);
			System.out.println(total);
		}
	}
}
