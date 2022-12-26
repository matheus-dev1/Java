package br.com.alura.ecommerce;

import br.com.alura.ecommerce.database.LocalDataBase;

import java.io.Closeable;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

// Serviço responsavel por criar e gerenciar processos de bancos de dados das novas ordens.
public class OrdersDatabase implements Closeable {
    public final LocalDataBase localDataBase;

    // Cria um banco de dados.
    public OrdersDatabase() throws SQLException {
        this.localDataBase = new LocalDataBase("orders_database");
        this.localDataBase.createIfNotExists("create table Orders (" +
                "uuid varchar(200) primary key)");
    }

    // Salva uma nova order no banco de dados.
    public boolean saveNewOrder(Order order) throws SQLException {
        if(wasProcessed(order)){
            return false;
        }
        this.localDataBase.update("insert into Orders (uuid) values (?)", order.getOrderId());
        return true;
    }

    // Verificar se a ordem já foi processada, baseada no uuid da ordem.
    private boolean wasProcessed(Order order) throws SQLException {
        ResultSet result = this.localDataBase.query("select uuid from Orders where uuid = ? limit 1", order.getOrderId());
        return result.next();
    }

    // Fecha a conexão com o banco de dados.
    @Override
    public void close() throws IOException {
        try {
            this.localDataBase.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
