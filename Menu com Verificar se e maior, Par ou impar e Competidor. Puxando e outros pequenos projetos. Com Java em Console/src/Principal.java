import java.util.Scanner;

public class Principal {
	//Quanto tem a classe main que dizer que todos os arquvio do seu projeto deverao ser rodados apartir dele.
    public static void main(String[] args) {
    	//Declarando a variavel "n"
    	int n;
		//Instanciando a classe Scanner no console e armazenaod em "leia"
		Scanner leia = new Scanner(System.in);

		//Exibo uma mensagem e armazeno o valor do console do tipo inteiro na varaivel declara "n"
		System.out.print("Digite um numero: ");
		n = leia.nextInt();

		//Declarando a variavel menu com o valor 0.
		int menu = 0;
		System.out.println("Escolha a opção"
		    + "\n1 - Verificar o maior"
		    + "\n2 - Verificar par ou impar"
		    + "\n3 - Verificar categoria"
			+ "\n4 - Verificar o maior do arquivo Numero.Java"
		    + "\n5 - Verificar par ou impar arquivo Numero.Java"
		);

		//Colocando o valor do tipo inteiro na variavel menu referente a opcao que ele queira rodar.
		System.out.print("Digite aqui a sua resposta: ");
		menu = leia.nextInt();

		if(menu == 0){
			System.out.print("Aqui nao tem nada...");
			//Aqui eu vou fechar o Scanner.
			leia.close();
		}
		
		//Se o valor da variavel menu for 1 entao executa este bloco de comandos.
		if(menu == 1){
			//Mensagem e recebe um valor do console e armazena em "x" que esta sendo declarada na maesma linha.
		    System.out.print("Digite um novo numero: ");
		    int x = leia.nextInt();
			//Se o valor de "n" que eh o primeiro numero digitado no inicio do programa for maior que "x" que foi o ultimo agora digitado ele executara uma mensagem dependendo se for maior ou nao.
		    if (n > x){
		        System.out.println("Primeiro numero e maior!");
		    } else {
		        System.out.println("Segundo numero e maior");
		    }
		}

		if(menu == 2){
			//Se o valor de "n" dividido por 2 for igual a 0 exiba "par" no console.
		    if (n % 2 == 0) {
		        System.out.print("Par");
		    } else {
		        System.out.print("Impar");
		    }
		}

		if(menu == 3){
			//Aqui eu estou instanciando o a classe competidor.
			// 1. O primeiro "Competidor" se refere a classe propriamente dita.
			// 2. O segundo "CompetidorClass" se refere ao nome em que eu dei para a instancia dessa classe, pode ser qualquer nome eh dada apenas no momento da instancia.
			// 3. O = new eh padrao, qualquer instancia tem que ser feita assim.
			// 4. E o nome do construtor da classe.
		    Competidor CompetidorClass = new Competidor();

		    System.out.print("Digite a Idade: ");
			// CompetidorClass.setIdade() eh um metodo que recebe um valor como parametro.
			// Neste caso e o valor do console.
		    CompetidorClass.setIdade(leia.nextInt());

			// Como eu executei anteriormente CompetidorClass.setIdade() o this.idade ja esta setado com um valor do console, entao ao executar CompetidorClass.verificarCategoria() ele ira passar por uma serie de testes de fluxo que ira executar um bloco dependendo do seu valor.
			// E no final o CompetidorClass.verificarCategoria() me retornar um string que e exibida aqui.
		    System.out.println(CompetidorClass.verificarCategoria());
		}

		if(menu == 4){
			Numero NumeroClass = new Numero();

			System.out.print("Digite um novo numero: ");
			NumeroClass.setNum(n);

			NumeroClass.maior(leia.nextInt());
		}

		if(menu == 5){
			Numero NumeroClass = new Numero();

			System.out.print("Digite um novo numero: ");
			NumeroClass.setNum(n);

			NumeroClass.par_impar();
		}
    }
}
