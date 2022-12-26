package br.com.alura.ecommerce.database;

import java.sql.*;

// Classe responsavel por criar a conexão no banco de dados e de utilizar de metodos comuns para a aplicação.
public class LocalDataBase {

    public Connection connection;

    // Inicia uma conexão.
    public LocalDataBase(String name) throws SQLException {
        String urlDatabase = "jdbc:sqlite:" + name + ".db";
        this.connection = DriverManager.getConnection(urlDatabase);
    }

    // Verifica se um banco já foi criado.
    public void createIfNotExists(String sqlScript){
        try {
            Statement statement = this.connection.createStatement();
            statement.execute(sqlScript);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    // Prepara o statement para execução.
    private PreparedStatement getPreparedStatement(String statement, String[] params) throws SQLException {
        PreparedStatement insertPreparedStatement = this.connection.prepareStatement(statement);
        for(int index = 0; index < params.length; index++){
            insertPreparedStatement.setString(index + 1, params[index]);
        }
        return insertPreparedStatement;
    }

    // Essa sintaxe é como se eu recebesse um array de string, só que ele não tem quantiade definida e pode receber o quanto
    // a gente colocar de parametro
    public void update(String statement, String ... params) throws SQLException {
        PreparedStatement insertPreparedStatement = getPreparedStatement(statement, params);
        insertPreparedStatement.execute();
    }

    // Executa um query livre
    public ResultSet query(String query, String ... params) throws SQLException {
        PreparedStatement existsPreparedStatement = getPreparedStatement(query, params);
        return existsPreparedStatement.executeQuery();
    }

    // Fecha a conexão.
    public void close() throws SQLException {
        this.connection.close();
    }
}
