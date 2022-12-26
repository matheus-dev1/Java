package br.com.alura.ecommerce.service;

import br.com.alura.ecommerce.Message;
import br.com.alura.ecommerce.json.GsonDesiarializer;
import br.com.alura.ecommerce.json.GsonSerializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.io.Closeable;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;

// KafkaService, tem como responsabilidade ser um serviço de uso geral para as minhas clsses do tipo ServiceKafka.
// Uma das utilizadade é o setUp do topico no serviço, para inicializa-lo começa por esta classe.
public class KafkaService<T> implements Closeable {
    private final ConsumerFunction<T> parse;
    // Chave em String e value em um objeto que atende sua regra de negocio.
    private final KafkaConsumer<String, Message<T>> kafkaConsumer;
    private static final String ECOMMERCE_DEADLETTER = "ECOMMERCE_DEADLETTER";

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

    // O metodo run é um metodo que por padrao nunca termina o que faz a ideia do "listen" dos topicos
    public void run() throws ExecutionException, InterruptedException {
        try(KafkaDispatcher<Object> kafkaDispatcherDeadLetter = new KafkaDispatcher<Object>()) {
            while (true) {
                // O método poll(), do cliente consumer Kafka, retorna uma lista de eventos e cada evento contém o
                // metadado (o tópico, partição, timestamp, etc) e a informação em si (chave e valor da mensagem).
                // E também nele definimos o tempo em minutos pra pegar tudo.
                ConsumerRecords<String, Message<T>> consumerRecords = kafkaConsumer.poll(Duration.ofMinutes(1));
                if (!consumerRecords.isEmpty()) {
                    System.out.println("Records " + consumerRecords.count() + " founded!");
                    for (ConsumerRecord<String, Message<T>> record : consumerRecords) {
                        try {
                            parse.consume(record);
                        } catch (Exception e) {
                            e.printStackTrace();
                            // O Dead Letter é um topico de "cartas mortas", que vieram com falhas, mas podem ser usadas
                            // de alguma outra forma depois, como por exemplo retentando enviar esta mensagem, ou
                            // como analitycs para ver quantas mensagens deram erro.
                            kafkaDispatcherDeadLetter.send(
                                    ECOMMERCE_DEADLETTER,
                                    record.value().getCorrelationId().toString(),
                                    new GsonSerializer<Object>().serialize("", record.value()),
                                    record.value().getCorrelationId().continueCorrelationWith("DeadLetter")
                            );
                        }
                    }
                }
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
        // O que fazer quando não há deslocamento(offset) inicial no Kafka ou se o deslocamento(offset) atual não existe mais
        // no servidor (por exemplo, porque esses dados foram excluídos)
        // Neste caso laste ele vai considerar o offset como o ultimo.
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
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
