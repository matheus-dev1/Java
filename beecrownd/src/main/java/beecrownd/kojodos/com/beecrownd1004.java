package beecrownd.kojodos.com;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class beecrownd1004 {
    public static void main(String[] args) {
        // System.in vai receber o valor do input
        // Scanner vai receber o InputStream e tranformar em caracteres usando o default charset (utf-8)
        Scanner scanner = new Scanner(System.in);
        System.out.print("1.: ");
        // Pega a "proximo" conteudo existente e retorna
        int valor1 = scanner.nextInt();
        System.out.print("2.: ");
        int valor2 = scanner.nextInt();

        int PROD = valor1 * valor2;

        System.out.println("PROD = " + PROD);
    }
}