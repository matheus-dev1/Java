package loja_virtual_repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		Statement statement = connection.createStatement();
		
		// O execute tambem tem uma variacao do seu metodo em que ele recebe a query e
		// um segundo parametro que e um atributo do statement que faz com que o retorno
		// do execute seja a chave(id) gerada na insercao, neste caso.
		
		// O método devolve true quando o seu resultado é um java.sql.ResultSet e false
		// caso contrário (update, delete, etc)
		statement.execute("INSERT INTO PRODUTO (nome, descricao) VALUES ('Mouse', 'mouse gamer')",
		statement.RETURN_GENERATED_KEYS);
		
		// E como padrao, ele vai setar no atributo o valor gerado, e nos conseguimos resgatar 
		// atraves do metodo 
		ResultSet resultSetKeys = statement.getGeneratedKeys();
		
		// Classe
		System.out.println(resultSetKeys);
		
		while(resultSetKeys.next()) {
			// Obter o valor atraves de um inteiro.
			Integer id = resultSetKeys.getInt(1);
			System.out.println("Criado. ID: " + id);
		}
	}

}
