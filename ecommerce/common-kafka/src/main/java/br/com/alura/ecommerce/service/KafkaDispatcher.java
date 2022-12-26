package br.com.alura.ecommerce.service;

import br.com.alura.ecommerce.CorrelationId;
import br.com.alura.ecommerce.Message;
import br.com.alura.ecommerce.json.GsonSerializer;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.Closeable;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

// Configuração do servidor do Kafka e execução dos metodo send, tanto sincrono como assincrono que recebem os payload
// e fazer o envio para um terminado topico.
public class KafkaDispatcher<T> implements Closeable {
    private final KafkaProducer<String, Message<T>> kafkaProducer;
    private String className;

    public KafkaDispatcher(String className){
        this.className = className;
        this.kafkaProducer = new KafkaProducer<String, Message<T>>(properties());
    }

    public KafkaDispatcher(){
        this.kafkaProducer = new KafkaProducer<String, Message<T>>(properties());
    }

    public static Properties properties(){
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // Neste caso eu só preciso passar o GsonSerializer porque ele implementa o Serializer(do Kafka) que me obriga
        // a implementar um metodo Serializer que o Kafka executa por baixo dos panos.
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, GsonSerializer.class.getName());
        // Isso significa que o líder aguardará o conjunto completo de réplicas sincronizadas para confirmar o registro.
        // Isso garante que o registro não será perdido, desde que haja pelo menos uma réplica sincronizada permanece ativo.
        // Esta é a garantia mais forte disponível
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

    /* O processamento síncrono é aquele que acontece em sequência e ordenado, seguindo uma fila, e o outro
        processamento assíncrono só começa após o atual ser concluído
    * */
    // Assincrono
    public Future<RecordMetadata> sendAsync(String topic, String key, T payload, CorrelationId correlationId) throws ExecutionException, InterruptedException {
        // Aqui que ele gera o correlation id(id da sua requisição)
        // que vai criar um rastro de tudo o que a partir dessa requisição foi feito.
        Message<T> value = new Message<T>(correlationId.continueCorrelationWith("_" + topic), payload);
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
        Future<RecordMetadata> futureSend = kafkaProducer.send(producerRecord, callback);
        return futureSend;
    }

    // Sincrono
    public void send(String topic, String key, T payload, CorrelationId correlationId) throws ExecutionException, InterruptedException {
        Future<RecordMetadata> futureSend = sendAsync(topic, key, payload, correlationId);
        futureSend.get();
    }

    @Override
    public void close() {
        // Fechar o meu KafkaProducer
        kafkaProducer.close();
    }
}
