package br.com.alura.ecommerce;

import br.com.alura.ecommerce.service.KafkaDispatcher;
import br.com.alura.ecommerce.service.KafkaService;
import br.com.alura.ecommerce.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

// Batch responsavel para fazer o Fast Delegate de mensagem para todos os usuarios
public class BatchSendMessageUsers {
    private static final String ECOMMERCE_SEND_MESSAGE_TO_ALL_USERS = "ECOMMERCE_SEND_MESSAGE_TO_ALL_USERS";

    private final KafkaDispatcher<User> userKafkaDispatcher = new KafkaDispatcher<>(BatchSendMessageUsers.class.getSimpleName());

    public Connection connection;

    public BatchSendMessageUsers() throws SQLException {
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

    public static void main(String[] args) throws SQLException, ExecutionException, InterruptedException {
        BatchSendMessageUsers batchSendMessageUsers = new BatchSendMessageUsers();
        try(KafkaService<String> userKafkaService = new KafkaService<String>(
                ECOMMERCE_SEND_MESSAGE_TO_ALL_USERS,
                batchSendMessageUsers::parse,
                BatchSendMessageUsers.class.getSimpleName(),
                String.class,
                Map.of())) {
            userKafkaService.run();
        }
    }

    private void parse(ConsumerRecord<String, Message<String>> recordMessage) throws SQLException, ExecutionException, InterruptedException {
        System.out.println("--------------BATCH SEND MENSSAGE USERS----------------");
        System.out.println("Processing new batch");
        System.out.println("Key: " + recordMessage.key());
        System.out.println("Value: " + recordMessage.value());
        System.out.println("Topic: " + recordMessage.topic());
        System.out.println("TimeStamp: " + recordMessage.timestamp());
        System.out.println("Partition: " + recordMessage.partition());
        System.out.println("Offset: " + recordMessage.offset());
        List<User> users = getAllUsers();
        for (User user : users) {
            // Aqui eu vou pegar o topico no value() para enviar uma nova mensagem para o topico "USER_GENERATE_READING_REPORT"
            // Com o Async, eu envio as mensagens para as partições do Broken, sem a garantia que elas foram enviadas
            // E também sem uma ordem especifica de commit
            userKafkaDispatcher.sendAsync(
                    // Como é um Fast Delegate o payload enviado é apeans o proprio nome do topico.
                    recordMessage.value().getPayload(),
                    user.getUuid(), user,
                    /* Neste caso como este send esta sendo executado por conta de outro send, no caso do EcommerceControler
                       nos devemos concatenar o Correlation id gerado lá, com um correlationId gerado aqui(BatchSendMessageUsers)
                     */
                    recordMessage.value().getCorrelationId().continueCorrelationWith(BatchSendMessageUsers.class.getSimpleName())
                    );
        }

    }

    // Recupera todos os usuarios do banco de dados.
    private List<User> getAllUsers() throws SQLException {
        PreparedStatement existsPreparedStatement = this.connection.prepareStatement("select uuid from Users");
        ResultSet results = existsPreparedStatement.executeQuery();
        List<User> usersList = new ArrayList<User>();
        while (results.next()){
            usersList.add(new User(results.getString(1)));
        }
        return usersList;
    }
}
