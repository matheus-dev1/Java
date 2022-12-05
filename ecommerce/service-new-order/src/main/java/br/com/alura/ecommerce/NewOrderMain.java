package br.com.alura.ecommerce;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class NewOrderMain {
    public static final String LOJA_NOVO_PEDIDO = "LOJA_NOVO_PEDIDO";
    public static final String ECOMMERCE_NEW_ORDER = "ECOMMERCE_NEW_ORDER";
    public static final String ECOMMERCE_NEW_EMAIL = "ECOMMERCE_NEW_EMAIL";

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        // Para produzir mensagens ao Kafka, nos usamos a classe KafkaProducer que recebe dois generics, o primeiro o tipo da chave e o segundo o tipo da mensagem
        // KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties());


        // Classe generica que eu criei para dividir as responsabilidades de produzir mensagens
        try(KafkaDispatcher<Order> orderKafkaDispatcher = new KafkaDispatcher<Order>(NewOrderMain.class.getSimpleName() + "Order")) {
            try (KafkaDispatcher<Email> emailKafkaDispatcher = new KafkaDispatcher<Email>(NewOrderMain.class.getSimpleName() + "Email")) {
                // Testar pedidos de compra para um usuario especifico.
                String userEmail = UUID.randomUUID().toString() + "@email.com";
                for (int i = 0; i < 10; i++) {
                    // ProducerRecord - È o registro do meu Producer
                    // Primeiro parametro, o nome do topico.
                    // Segundo parametro é a chave.
                    // terceiro parametro é o valor.
                    // A chave(key)
                    // String key = UUID.randomUUID().toString();

                    // String key = "id_order,id_user,value_order";
                    // String value = key + "id_order,id_user,value_order";
                    // String keyEmail = "Thank you for your order! We are processing your order!!! teste@teste.com";
                    // String valueEmail = "Thank you for your order! We are processing your order!!! teste@teste.com";

                    // String userId = UUID.randomUUID().toString();
                    String orderId = UUID.randomUUID().toString();
                    BigDecimal amount = new BigDecimal(Math.random() * 5000 + 1);
                    //String userEmail = UUID.randomUUID().toString() + "@email.com";
                    // Order order = new Order(userId, orderId, amount, userEmail);
                    Order order = new Order(orderId, amount, userEmail);

                    String subject = "title-" + UUID.randomUUID().toString();
                    String body = UUID.randomUUID().toString() + "@email.com";
                    Email email = new Email(subject, body);

                    // Agora o nosso userEmail vai ser o nosso key.
                    orderKafkaDispatcher.send(ECOMMERCE_NEW_ORDER, userEmail, order, new CorrelationId(NewOrderMain.class.getSimpleName() + "Order"));
                    emailKafkaDispatcher.send(ECOMMERCE_NEW_EMAIL, userEmail, email, new CorrelationId(NewOrderMain.class.getSimpleName() + "Email"));

            /*
            // Você pode chamar um callback dessa forma.
            Callback callback = (data, exception) -> {
                if (exception != null) {
                    exception.printStackTrace();
                    return;
                } else {
                    // Quando terminar a execução do send, avisando mandando um print no console.
                    System.out.println("Sucesso enviando neste topico: " + data.topic() + "::: partition " + data.partition() + "/ offset " + data.offset() + "/ timeStamp " + data.timestamp());
                }
            };

            ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(ECOMMERCE_NEW_ORDER, key, value);
            // Enviar a mensagem(o record) em si.
            // o metodo send é asincrono e por padrão, retornar uma classe Future que significa que algo que vai executar daqui a pouco
            // data é do tipo RecordMetadata - Nesta classe, tem varias informações do que você esta enviado
            // exception é do tipo Exception
            Future futureSend = kafkaProducer.send(producerRecord, callback);
            // metodo get(), pode lançar duas exceptions, 1. um erro na execução ou 2. alguma coisa que interrompa.
            futureSend.get();

            ProducerRecord<String, String> producerRecordEmail = new ProducerRecord<String, String>(ECOMMERCE_NEW_EMAIL, key, valueEmail);
            Future futureSendEmail = kafkaProducer.send(producerRecordEmail, callback);
            futureSendEmail.get();
            */
                }
            }
        }
    }

    /*public static Properties properties(){
        // Isso aqui é como se a gente tivesse criando um arquivo "propriedades.properties"
        Properties properties = new Properties();
        // setProperty(1, 2) - Seta uma nova propriedade
        // ProducerConfig - Classe que mantem enums para configurações de "Producers"
        // ProducerConfig.BOOTSTRAP_SERVERS_CONFIG - é o servidor que ta rodando o bootstrap server, junto com a sua porta
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        // Aqui eu estou definindo que eu quero que a minha chave do exemplo do KafkaProducer, seja serializado a minha string em Bytes.
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // Aqui eu estou definindo que eu quero que o valor da minha chave pegando o exemplo do KafkaProducer, seja serializado a minha string em Bytes.
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return properties;
    }*/
}
