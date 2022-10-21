package br.com.alura.estoque;

import java.util.List;
import java.util.Scanner;

import br.com.alura.alurator.Alurator;
import br.com.alura.estoque.dao.ProdutoDao;
import br.com.alura.estoque.dao.ProdutoDaoMock;

public class EstoqueApiApplication {
	/*
	 * Simula o navegador e suas requisições.
	 */
	public static void main(String[] args) throws Exception {
		/*
		 * "Requisições" possiveis:
		 * /controlador/metodo
		 * /controlador/metodo?param1=valor1&param2=valor2
		 * 
		 * /produto/filtra?nome=produto
		 * 
		 * /produto/filtra?nome=produto&marca=marca1
		 * /produto/filtra?nome=produto&marca=marca1&modelo=marca2
		 * /produto/filtra?nome=marca1&nome=produto
		 */
		
		// Tentar ler uma string do console
		try (Scanner s = new Scanner(System.in)) {
			System.out.print("Digite uma url: ");
			// armazema a string digitada no console na variavel "url"
			String url = s.nextLine();
			// Instancia a classe Alurator, que é como se fosse um "lib"
			
			//Alurator alurator = new Alurator(StringUtils.convertUrlToPacote("br.com.alura.estoque.controle." , url, "Controller"));
			Alurator alurator = new Alurator("br.com.alura.estoque.controle.");
			// Interfaces também tem .class
			// Necessariamente pra isso dar certo, ProdutoDaoMock tem que implementar ProdutoDao
			alurator.registra(ProdutoDao.class, ProdutoDaoMock.class);
			// Vai falhar porque estes caras não são tipos compativeis.
			//alurator.registra(List.class, String.class);
			
			// Verifica se o valor da variavel "url" não é "exit"
			while (!url.equals("exit")) {
				Object response = alurator.executa(url);
				System.out.println("Response: " + response);
				url = s.nextLine();
			}
		}
	}

}
