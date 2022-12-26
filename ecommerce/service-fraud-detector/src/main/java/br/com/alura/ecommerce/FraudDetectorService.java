package br.com.alura.ecommerce;

import br.com.alura.ecommerce.database.LocalDataBase;
import br.com.alura.ecommerce.service.ConsumerService;
import br.com.alura.ecommerce.service.KafkaDispatcher;
import br.com.alura.ecommerce.service.KafkaService;
import br.com.alura.ecommerce.service.ServiceRunner;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

// Produtor e consumidor
// Serviço responsavel por escutar um novo pedido de compra e valiar se é uma fraude ou não.
public class FraudDetectorService implements ConsumerService<Order> {
    public static final String ECOMMERCE_NEW_ORDER = "ECOMMERCE_NEW_ORDER";
    public static final String ECOMMERCE_ORDER_REJECTED = "ECOMMERCE_ORDER_REJECTED";
    public static final String ECOMMERCE_ORDER_SUCCESS = "ECOMMERCE_ORDER_SUCCESS";
    public final LocalDataBase localDataBase;
    private KafkaDispatcher<Order> orderKafkaDispatcher = new KafkaDispatcher<Order>(FraudDetectorService.class.getSimpleName());

    /*public static void main(String[] args) throws ExecutionException, InterruptedException {
        FraudDetectorService fraudDetectorService = new FraudDetectorService();
        try(KafkaService<Order> kafkaService = new KafkaService<Order>(
                ECOMMERCE_NEW_ORDER,
                fraudDetectorService::parse,
                FraudDetectorService.class.getSimpleName(),
                Order.class,
                Map.of())) {
            kafkaService.run();
        }
    }*/

    public static void main(String[] args) {
        new ServiceRunner(FraudDetectorService::new, Order.class).start(1);
    }

    public FraudDetectorService() throws SQLException {
        this.localDataBase = new LocalDataBase("frauds_database");
        this.localDataBase.createIfNotExists("create table Orders (" +
                "uuid varchar(200) primary key," +
                "is_fraud boolean)");
    }

    @Override
    public String getTopic() {
        return ECOMMERCE_NEW_ORDER;
    }

    @Override
    public String getConsumerGroup() {
        return FraudDetectorService.class.getSimpleName();
    }

    @Override
    public Class<Order> getType() {
        return Order.class ;
    }

    @Override
    public void parse(ConsumerRecord<String, Message<Order>> record) throws ExecutionException, InterruptedException, SQLException {
        System.out.println("--------------FRAUD DETECTOR SERVICE------------------");
        System.out.println("Processing a new order and checking fraud....");
        System.out.println("Key: " + record.key());
        System.out.println("Value: " + record.value());
        System.out.println("Topic: " + record.topic());
        System.out.println("TimeStamp: " + record.timestamp());
        System.out.println("Partition: " + record.partition());
        System.out.println("Offset: " + record.offset());

        // Retornar o valor de um record
        Order order = record.value().getPayload();

        if(wasProcessed(order)) {
            System.out.println("Order " + order.getOrderId() + " already was processed!");
            return;
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(isFraud(order)) {
            System.out.println("*********************");
            System.out.println("Order is a fraud!!!");
            System.out.println(order.toString());
            this.localDataBase.update("insert into Orders (uuid, is_fraud) values (? , true)", order.getOrderId());
            orderKafkaDispatcher.send(
                    ECOMMERCE_ORDER_REJECTED,
                    order.getUserEmail(),
                    order,
                    record.value().getCorrelationId().continueCorrelationWith(FraudDetectorService.class.getSimpleName()));
        } else {
            System.out.println("*********************");
            System.out.println("Order approved!!!");
            System.out.println("Order Amount " + order.getAmount());
            // System.out.println("Order UserId: " + order.getUserId());
            System.out.println("Order OrderId: " + order.getOrderId());
            this.localDataBase.update("insert into Orders (uuid, is_fraud) values (? , false)", order.getOrderId());
            orderKafkaDispatcher.send(
                    ECOMMERCE_ORDER_SUCCESS,
                    order.getUserEmail(),
                    order,
                    record.value().getCorrelationId().continueCorrelationWith(FraudDetectorService.class.getSimpleName()));
        }

        System.out.println("Order Processed!");
    }

    private boolean wasProcessed(Order order) throws SQLException {
        ResultSet result = this.localDataBase.query("select uuid from Orders where uuid = ? limit 1", order.getOrderId());
        return result.next();
    }

    private static Boolean isFraud(Order order) {
        // 0 : se o valor deste BigDecimal for igual ao do objeto BigDecimal passado como parâmetro.
        // 1 : se o valor deste BigDecimal for maior que o do objeto BigDecimal passado como parâmetro.
        // -1 : se o valor deste BigDecimal for menor que o do objeto BigDecimal passado como parâmetro.
        // Ou seja aqui eu estou verificando se o meu BigDecimal é igual ou maior que 4500.
        BigDecimal valorComparativo = new BigDecimal("4500");
        return order.getAmount().compareTo(valorComparativo) >= 0;
    }

        /*
        // Para consumir mensagens ao Kafka, nos usamos a classe KafkaConsumer que recebe dois generics, o primeiro o tipo da chave e o segundo o tipo da mensagem
        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(properties());
        List<String> listTopics = new ArrayList<String>();
        listTopics.add("ECOMMERCE_NEW_ORDER");
        // Aqui ele ta escutando algum topico.
        // Posso escutar mais de um topico, mas isso é raro.
        kafkaConsumer.subscribe(listTopics);
        while (true) {
            // Pergunto se tem mensagem dentro deste topico, dentro de um determinado tempo.
            // CosumerRecords, são os registros que o meu consumer pegou.
            ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofMinutes(1));
            // Se tiver registros entre no if.
            if (!consumerRecords.isEmpty()) {
                System.out.println("Records " + consumerRecords.count() + " founded!");
                consumerRecords.forEach(record -> {
                    System.out.println("-----------------------------------------------");
                    System.out.println("Processing a new order and checking fraud....");
                    System.out.println("Key: " + record.key());
                    System.out.println("Value: " + record.value());
                    System.out.println("Topic: " + record.topic());
                    System.out.println("TimeStamp: " + record.timestamp());
                    System.out.println("Partition: " + record.partition());
                    System.out.println("Offset: " + record.offset());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Order Processed!");
                });
            }
        }*/

    /*private static Properties properties() {
        Properties properties = new Properties();
        // ConsumerConfig - Classe que mantem enums para configurações de "Consumers"
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        // Agora diferente do Producer, nos vamos deserializar para String os Bytes das chaves(key) e valores(values)
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        // Um grupo é como se fosse uma caixa especificada sobre qual topico ela vai receber, mas pode ter mais de um caixa dessa olhando o mesmo topico.
        // Pegando apenas o nome da classe.
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, FraudDetectorService.class.getSimpleName());
        // Setar um nome para o consumer Id
        properties.setProperty(ConsumerConfig.CLIENT_ID_CONFIG, FraudDetectorService.class.getSimpleName() + "-" + UUID.randomUUID().toString());
        // Com essa confguração, meu consumidor recebe uma mensagem e já copia a após ela, ou seja vai pegando e commitando de um em um.
        properties.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "1");
        return properties;
    }*/
}
