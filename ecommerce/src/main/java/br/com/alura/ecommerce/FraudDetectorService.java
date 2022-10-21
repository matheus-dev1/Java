package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.record.Record;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.*;

public class FraudDetectorService {
    public static void main(String[] args) {
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
        }
    }

    private static Properties properties() {
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
        return properties;
    }
}
