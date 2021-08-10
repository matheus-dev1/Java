package testeprincipal;
import java.util.Scanner;

public class Macas {
	public static void main(String[] args) {
		double totalMacas, custoTotal;

		System.out.print("Desconto se comprar mais de 6 macas: ");
		Scanner leia = new Scanner(System.in);

		System.out.print("Digite a quantidade de macas: ");
		totalMacas = leia.nextInt();

		if(totalMacas < 6){
			custoTotal = (totalMacas*1.30);
			System.out.print("Custo total: " + custoTotal);
		} else {
			custoTotal = (totalMacas*1);
			System.out.print("Custo total: " + custoTotal);
		}
		leia.close();
	}
}
