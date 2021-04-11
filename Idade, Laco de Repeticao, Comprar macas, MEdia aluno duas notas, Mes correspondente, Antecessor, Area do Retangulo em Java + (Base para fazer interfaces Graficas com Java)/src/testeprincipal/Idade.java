// O que são Packages em Java. Um pacote (package) é um namespace usado para organizar um conjunto de interfaces e classes relacionadas. Podemos, por analogia, pensar nos pacotes como pastas que contém classes que trabalham em conjunto. ... Os pacotes são usados para agrupar classes relacionadas.
package testeprincipal;
import java.util.Scanner;

public class Idade {
	public static void main(String[] args) {
		int idade, meses, dias;

		Scanner leia = new Scanner(System.in);

		System.out.print("Digite a sua idade: ");
		idade = leia.nextInt();

		System.out.print("Digite os meses de vida: ");
		meses = leia.nextInt();

		System.out.print("Digite os dias de vida: ");
		dias = leia.nextInt();

		int resultado1 = (idade * 365);
		int resultado2 = (meses * 30);
		int resultado3 = (resultado1 + resultado2 + dias);

		System.out.print(resultado3);

		leia.close();
	}
}
