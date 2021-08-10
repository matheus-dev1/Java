package loja_virtual_repository;

import java.sql.SQLException;

public class TestaPoolConexoes {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		for(int i = 0; i < 20; i ++) {
			// Eu defini no maximo 15 conexoes, e aqui eu estou solicitando 20, o que vai acontecer eh que
			// por exemplo a pessoa que tentar criar um 16a conexao, nao vai criar, por que precisa
			// esperar uma das 15 conexoes criadas terminar o seu processamento para atribuir
			// a conexao criada para um novo usuario.
			// Obs: Voce pode perceber que este programa nunca termina, porque eu nunca vou finalizar
			// a criacao das 15 conexoes, o que consequentemente me prente aqui pra sempre, porque
			// eu nao posso criar mais e as conexoes ficam presas por nao terminarem.
			// Obs: show processlist; para ver a lista de processos de conexoes.
			connectionFactory.recuperarConexao();
			System.out.println("Conexao: " + i);
		}
	}

}
