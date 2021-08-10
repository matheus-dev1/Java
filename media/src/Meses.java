package testeprincipal;
import java.util.Scanner;

public class Meses {
	public static void main(String[] args) {
		try(Scanner ler = new Scanner(System.in)){
			System.out.print("Digite o mes correspondente: ");
			int meses = ler.nextInt();

			switch(meses){
				case 1:
					System.out.print("Mes de Janeiro");
					break;
				case 2:
					System.out.print("Mes de Fevereiro");
					break;
				case 3:
					System.out.print("Mes de Marco");
					break;
				case 4:
					System.out.print("Mes de Abril");
					break;
				case 5:
					System.out.print("Mes de Maio");
					break;
				case 6:
					System.out.print("Mes de Junho");
					break;
				case 7:
					System.out.print("Mes de Julho");
					break;
				case 8:
					System.out.print("Mes de Agosto");
					break;
				case 9:
					System.out.print("Mes de Setembro");
					break;
				case 10:
					System.out.print("Mes de Outubro");
					break;
				case 11:
					System.out.print("Mes de Novembro");
					break;
				case 12:
					System.out.print("Mes de Dezembro");
					break;
				default:
					System.out.print("Data invalida");
					break;
			}
		}
	}
}
