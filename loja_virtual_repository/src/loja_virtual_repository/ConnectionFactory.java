package loja_virtual_repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

// DesignPatterns = Factory Methods - O padrão Factory Method é:
// “Um padrão que define uma interface para criar um objeto, mas permite às 
// classes decidirem qual classe instanciar. O Factory Method permite a uma
// classe deferir a instanciação para subclasses” 
public class ConnectionFactory {
	
	public DataSource dataSource;
	
	// Então vai vir uma requisição, ele vai pedir uma conexão, e essa conexão, ela vai estar disponível
	// naquele Pool de conexões, eu não vou precisar abrir uma conexão direta com o nosso banco de dados.
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("root");
		
		comboPooledDataSource.setMaxPoolSize(15);
		
		this.dataSource = comboPooledDataSource;
	}
	
	public Connection recuperarConexao() throws SQLException {
		// return DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "root");
		return this.dataSource.getConnection();
	}
}
