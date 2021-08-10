package loja_virtual_repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		
		// Exemplo que falha do ususario que quebra o sistema, se nao tiver tratamento destes erros.
		String nome = "mouse'";
		// Exemplo de SQL Injection
		// String descricao = "mouse sem fio); delete from produtos;";
		String descricao = "mouse sem fio); delete from produtos;";

		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.recuperarConexao()) {
			// O commit eh a insercao ao banco de dados.
			// Aqui eu estou declarando que o commit ao banco de dados nao sera 
			// feita automaticamente(que eh padrao por sinal) e sim feita por mim, eu vou controlar o momento
			// do commit da transacao.
			connection.setAutoCommit(false);
			
			// As interrogacoes, significam parametros que estarao em varaiveis.
			String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)";
			
			// Ao preparar um statement, a responsabilidade de gerenciar os atributos passados
			// para a query sql, nao eh mais eu em que tenho que tratar.
						
			// O tipo do objeto de retorno eh do tipo PreparedStatement.
						
			// Obs: Eu configuro para o retorno das chaves geradas na insercao aqui, 
			// e como RETURN_GENERATED_KEYS eh um atributo public, apenas basta importar e usar.
			
			// Ao usar try with resources com a criacao da preparacao do statement(onde colocamos query sql)
			// nos nao precisamos mais usar o metodo close, porque ao finalizar o bloco do try, ele
			// ja implicitamente encera.
			try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				// Pego a clausula e coloco o valor do segundo parametro na primeira posicao da clausila do 
				// preparedStatement.
				adicionarVariavel("SmartTV", "45 polegadas", statement);
				adicionarVariavel("notebook", "44 led", statement);
				
				// Se a execucao dos dois objetos acima foi sucesso, nao dar uma excessao, ele
				// executa o commit basicamente fideliza o armazenamento dos dados.
				connection.commit();
				
				// Fecha o statement e a conexao com o banco de dados.
				// statement.close();
				// Obs: Usando try with resource com a inicializacao da preparacao do statement, 
				// nao precisamos mais fechar.
				// connection.close();
			} catch (Exception error) {
				error.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				// Ele desfaz todas as transacoes do ultimo commit.
				// Se por exemplo a primeira transacao dar certo e a segunda nao, ele inevitalvelmente 
				// vai cair nesta excecao e vai executar o rollback, desfazendo a primeira transacao.
				connection.rollback();
			}
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement statement) throws SQLException {
		
		statement.setString(1, nome);		
		statement.setString(2, descricao);
		
		/*
		if(nome.equals("notebook")) {
			throw new RuntimeException("Nao foi possivel efetuar o produto");
		}
		*/
		
		// Como a query, ja foi preparada anteriormente e esta armezenada no objeto statement, nao
		// precisamos declarar a query dentro do execute pois ja esta no objeto.
		statement.execute();
		
		// O ResultSet a mesma coisa, na pratica qualquer coisa que voce abra um conexao com ela e
		// necessite fechar depois, pode ser feito assim.
		// Pelo fato dos statements estenderem AutoCloseable
		try (ResultSet resultSetKeys = statement.getGeneratedKeys()) {
		
			System.out.println(resultSetKeys);
		
			while(resultSetKeys.next()) {
				Integer id = resultSetKeys.getInt(1);
				System.out.println("Criado. ID: " + id);
			}
		}
	}

}
