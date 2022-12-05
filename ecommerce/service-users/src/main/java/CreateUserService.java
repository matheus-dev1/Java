import br.com.alura.ecommerce.KafkaService;
import br.com.alura.ecommerce.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.sql.*;
import java.util.Map;
import java.util.UUID;

// Uso de serviço externo - Neste caso um banco de dados.
public class CreateUserService {
    public static final String ECOMMERCE_NEW_ORDER = "ECOMMERCE_NEW_ORDER";
    public Connection connection;

    public CreateUserService() throws SQLException {
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
    }

    public static void main(String[] args) throws SQLException {
        CreateUserService createUserService = new CreateUserService();
        try(KafkaService<Order> userKafkaService = new KafkaService<Order>(
                ECOMMERCE_NEW_ORDER,
                createUserService::parse,
                CreateUserService.class.getSimpleName(),
                Order.class,
                Map.of())) {
            userKafkaService.run();
        }
    }

    private void parse(ConsumerRecord<String, Message<Order>> record) throws SQLException {
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
            String userId = UUID.randomUUID().toString();
            insertNewUser(order.getUserEmail(), userId);
        } else {
            System.out.println("User already exists!");
        }
    }

    private void insertNewUser(String userEmail, String userId) throws SQLException {
        PreparedStatement insertPreparedStatement = this.connection.prepareStatement("insert into Users (uuid, email) values (?, ?)");
        insertPreparedStatement.setString(1, userId);
        insertPreparedStatement.setString(2, userEmail);
        insertPreparedStatement.execute();
        System.out.println("User [" + userId + " and " + userEmail + "] added!");
    }

    private boolean isNewUser(String userEmail) throws SQLException {
        PreparedStatement existsPreparedStatement = this.connection.prepareStatement("select uuid from Users where email = ? limit 1");
        existsPreparedStatement.setString(1, userEmail);
        ResultSet results = existsPreparedStatement.executeQuery();
        // Se tem proxima linha então existe, ou seja, me retorna true.
        return !results.next();
    }
}
