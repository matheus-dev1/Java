package testeprincipal;
import java.util.Scanner;

public class Retangulo {
	public static void main(String[] args) {
		int base, altura, area;

		Scanner leia = new Scanner(System.in);

		System.out.print("Digite a base: ");
		base = leia.nextInt();

		System.out.print("Digite a altura: ");
		altura = leia.nextInt();

		area = base * altura;

		System.out.println("O resultado eh: " + area);

		leia.close();
	}
}
