package testeprincipal;
import java.util.Scanner;

public class Laco {
	public static void main(String[] args) {
		int numero = 1;
		
		Scanner leia = new Scanner(System.in);
		
		//Entao o numero for diferente de 0 ele ira pedir pra voce digitar um numero!
		for(numero = 1; numero != 0;){
			System.out.print("Digite um numero(numero 0 para parar tudo): ");
			numero = leia.nextInt();
		}
		
		leia.close();
	}
}
