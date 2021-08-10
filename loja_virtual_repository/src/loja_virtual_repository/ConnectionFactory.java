package loja_virtual_repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

// DesignPatterns = Factory Methods - O padr�o Factory Method �:
// �Um padr�o que define uma interface para criar um objeto, mas permite �s 
// classes decidirem qual classe instanciar. O Factory Method permite a uma
// classe deferir a instancia��o para subclasses� 
public class ConnectionFactory {
	
	public DataSource dataSource;
	
	// Ent�o vai vir uma requisi��o, ele vai pedir uma conex�o, e essa conex�o, ela vai estar dispon�vel
	// naquele Pool de conex�es, eu n�o vou precisar abrir uma conex�o direta com o nosso banco de dados.
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
