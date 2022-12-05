package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;

// KafkaService, tem como responsabilidade ser um serviço de uso geral para as minhas clsses do tipo ServiceKafka
public class KafkaService<T> implements Closeable {
    private final ConsumerFunction<T> parse;
    // Chave em String e value em um objeto que atende sua regra de negocio.
    private final KafkaConsumer<String, Message<T>> kafkaConsumer;

    private KafkaService(ConsumerFunction<T> parse, String groupId, Class<T> type, Map<String, String> propertiesExtras){
        this.parse = parse;
        this.kafkaConsumer = new KafkaConsumer<String, Message<T>>(properties(groupId, type, propertiesExtras));
    }

    // Primeiro parametro recebe o topico, e como segundo parametro recebe a implementação dessa interface.
    // Essa interface é assim porque cada Service tem uma implementação diferente dessa interface.
    public KafkaService(String topic, ConsumerFunction<T> parse, String groupId, Class<T> type, Map<String, String> propertiesExtras){
        this(parse, groupId, type, propertiesExtras);
        // Uma lista de um valor só, que é o nosso topico.
        kafkaConsumer.subscribe(Collections.singleton(topic));
    }

    public KafkaService(Pattern topicRegex, ConsumerFunction<T> parse, String groupId, Class<T> type, Map<String, String> propertiesExtras) {
        this(parse, groupId, type, propertiesExtras);
        kafkaConsumer.subscribe(topicRegex);
    }

    public void run(){
        while (true) {
            ConsumerRecords<String, Message<T>> consumerRecords = kafkaConsumer.poll(Duration.ofMinutes(1));
            if (!consumerRecords.isEmpty()) {
                System.out.println("Records " + consumerRecords.count() + " founded!");
                consumerRecords.forEach(record -> {
                    try {
                        parse.consume(record);
                    } catch (ExecutionException | InterruptedException | SQLException | IOException e) {
                        e.printStackTrace();
                        throw new RuntimeException("Erro no parse");
                    }
                });
            }
        }
    }

    private Properties properties(String groupId, Class<T> type, Map<String, String> propertiesExtras) {
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        // Neste caso eu só preciso passar o GsonDesiarializer porque ele implementa o Deserializer(do Kafka) que me obriga a implementar
        // um metodo serialize que o Kafka executa por baixo dos panos
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, GsonDesiarializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.setProperty(ConsumerConfig.CLIENT_ID_CONFIG, groupId + "-" + UUID.randomUUID().toString());
        // Recebe e commita uma mensagem(record) por vez.
        properties.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "1");
        // Aqui eu estou configurando no Properties o nome da String, que é o tipo que eu quero deserializar
        // properties.setProperty(GsonDesiarializer.TYPE_CONFIG, type.getName());
        // Sobreescreve propriedade que você quiser
        properties.putAll(propertiesExtras);
        return properties;
    }

    @Override
    public void close() {
        kafkaConsumer.close();
    }
}
