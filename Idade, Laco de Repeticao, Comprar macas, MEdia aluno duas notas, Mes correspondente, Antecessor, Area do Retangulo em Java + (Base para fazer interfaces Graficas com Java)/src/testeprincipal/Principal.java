package testeprincipal;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		int valor;

		Scanner leia = new Scanner(System.in);

		System.out.print("Digite um valor: ");
		valor = leia.nextInt();

		int resultado = (valor -1);

		System.out.println("O numero eh: " + resultado);

		leia.close();
	}
}
