package br.com.alura.ecommerce;

import com.google.gson.Gson;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.Closeable;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class KafkaDispatcher<T> implements Closeable {
    private final KafkaProducer<String, Message<T>> kafkaProducer;
    private final String className;

    public KafkaDispatcher(String className){
        this.className = className;
        this.kafkaProducer = new KafkaProducer<String, Message<T>>(properties());
    }

    public static Properties properties(){
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // Neste caso eu só preciso passar o GsonSerializer porque ele implementa o Serializer(do Kafka) que me obriga
        // a implementar um metodo Serializer que o Kafka executa por baixo dos panos.
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, GsonSerializer.class.getName());
        properties.setProperty(ProducerConfig.ACKS_CONFIG, "all");
        return properties;
    }

    /*public void send(String topic, String key, String value) throws ExecutionException, InterruptedException {
        Callback callback = (data, exception) -> {
            if (exception != null) {
                exception.printStackTrace();
                return;
            } else {
                // Quando terminar a execução do send, avisando mandando um print no console.
                System.out.println("Sucesso enviando neste topico: " + data.topic() + "::: partition " + data.partition() + "/ offset " + data.offset() + "/ timeStamp " + data.timestamp());
            }
        };

        ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(topic, key, value);
        Future futureSend = kafkaProducer.send(producerRecord, callback);
        futureSend.get();
    }*/

    // Novo send
    public void send(String topic, String key, T payload, CorrelationId correlationId) throws ExecutionException, InterruptedException {
        // Aqui que ele gera o correlation id(id da sua requisição)
        // que vai criar um rastro de tudo o que a partir dessa requisição foi feito.
        Message<T> value = new Message<T>(correlationId, payload);
        Callback callback = (data, exception) -> {
            if (exception != null) {
                exception.printStackTrace();
                return;
            } else {
                // Quando terminar a execução do send, avisando mandando um print no console.
                System.out.println("Sucesso enviando neste topico: " + data.topic() + "::: partition " + data.partition() + "/ offset " + data.offset() + "/ timeStamp " + data.timestamp());
            }
        };

        ProducerRecord<String, Message<T>> producerRecord = new ProducerRecord<String, Message<T>>(topic, key, value);
        Future futureSend = kafkaProducer.send(producerRecord, callback);
        futureSend.get();
    }

    @Override
    public void close() {
        // Fechar o meu KafkaProducer
        kafkaProducer.close();
    }
}
