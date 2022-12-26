package br.com.alura.ecommerce;

import br.com.alura.ecommerce.database.LocalDataBase;
import br.com.alura.ecommerce.service.ConsumerService;
import br.com.alura.ecommerce.service.ServiceRunner;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.sql.*;
import java.util.UUID;

// Uso de serviço externo - Neste caso um banco de dados.
// Serviço responsavel por criação de novos usuarios e armazenamento do mesmo no banco de dados.
public class CreateUserService implements ConsumerService<Order> {
    public static final String ECOMMERCE_NEW_ORDER = "ECOMMERCE_NEW_ORDER";
    public final LocalDataBase localDataBase;
    /*public final Connection connection;

    public br.com.alura.ecommerce.CreateUserService() throws SQLException {
        String urlDatabase = "jdbc:sqlite:users_database.db";
        this.connection = DriverManager.getConnection(urlDatabase);
        try {
            Statement statement = this.connection.createStatement();
            String sqlScript = "create table Users (" +
                    "uuid varchar(200) primary key," +
                    "email varchar(200))";
            statement.execute(sqlScript);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }*/

    public CreateUserService() throws SQLException {
        this.localDataBase = new LocalDataBase("users_database");
        this.localDataBase.createIfNotExists("create table Users (" +
                "uuid varchar(200) primary key," +
                "email varchar(200))");
    }

    public static void main(String[] args) {
        new ServiceRunner(CreateUserService::new, Order.class).start(1);
    }

    /*public static void main(String[] args) throws SQLException, ExecutionException, InterruptedException {
        br.com.alura.ecommerce.CreateUserService createUserService = new br.com.alura.ecommerce.CreateUserService();
        try(KafkaService<br.com.alura.ecommerce.Order> userKafkaService = new KafkaService<br.com.alura.ecommerce.Order>(
                ECOMMERCE_NEW_ORDER,
                createUserService::parse,
                br.com.alura.ecommerce.CreateUserService.class.getSimpleName(),
                br.com.alura.ecommerce.Order.class,
                Map.of())) {
            userKafkaService.run();
        }
    }*/

    @Override
    public String getTopic() {
        return ECOMMERCE_NEW_ORDER;
    }

    @Override
    public String getConsumerGroup() {
        return CreateUserService.class.getSimpleName();
    }

    @Override
    public Class<Order> getType() {
        return Order.class;
    }

    @Override
    public void parse(ConsumerRecord<String, Message<Order>> record) throws SQLException {
        System.out.println("--------------CREATE USER SERVICE----------------");
        System.out.println("Processing a new order and checking new user....");
        System.out.println("Key: " + record.key());
        System.out.println("Value: " + record.value());
        System.out.println("Topic: " + record.topic());
        System.out.println("TimeStamp: " + record.timestamp());
        System.out.println("Partition: " + record.partition());
        System.out.println("Offset: " + record.offset());
        Order order = record.value().getPayload();
        if(isNewUser(order.getUserEmail())) {
            String uuid = UUID.randomUUID().toString();
            insertNewUser(order.getUserEmail(), uuid);
        } else {
            System.out.println("br.com.alura.ecommerce.User already exists!");
        }
    }

    // Inseri o usuario no banco de dados.
    private void insertNewUser(String userEmail, String uuid) throws SQLException {
        this.localDataBase.update("insert into Users (uuid, email) values (?, ?)", uuid, userEmail);
        /*PreparedStatement insertPreparedStatement = this.connection.prepareStatement("insert into Users (uuid, email) values (?, ?)");
        insertPreparedStatement.setString(1, uuid);
        insertPreparedStatement.setString(2, userEmail);
        insertPreparedStatement.execute();
        System.out.println("br.com.alura.ecommerce.User [" + uuid + " and " + userEmail + "] added!");*/
    }

    // Verifica se é um novo usuario.
    private boolean isNewUser(String userEmail) throws SQLException {
        ResultSet results = this.localDataBase.query("select uuid from Users where email = ? limit 1", userEmail);
        /*PreparedStatement existsPreparedStatement = this.connection.prepareStatement("select uuid from Users where email = ? limit 1");
        existsPreparedStatement.setString(1, userEmail);
        ResultSet results = existsPreparedStatement.executeQuery();*/
        // Se tem proxima linha então existe, ou seja, me retorna true.
        return !results.next();
    }
}
