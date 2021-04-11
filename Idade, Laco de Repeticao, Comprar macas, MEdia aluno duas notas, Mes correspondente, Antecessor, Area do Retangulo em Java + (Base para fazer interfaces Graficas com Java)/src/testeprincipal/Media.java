package testeprincipal;
import java.util.Scanner;

public class Media {
	public static void main(String[] args) {
		float nota1, nota2, media;

		Scanner leia = new Scanner(System.in);
		System.out.print("Digite a nota 1 : ");
		nota1 = leia.nextInt();

		System.out.print("Digite a nota 2: ");
		nota2 = leia.nextInt();

		media = (nota1 + nota2) / 2;
		System.out.println("A media ser�: "+media);

		if(media >= 6){
			System.out.println("ALUNO APROVADO!!!");
		} else {
			System.out.println("ALUNO REPROVADO!!!");
		}
		leia.close();
	}
}
