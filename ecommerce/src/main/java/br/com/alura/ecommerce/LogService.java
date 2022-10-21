package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

public class LogService {
    public static void main(String[] args) {
        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(properties());
        List<String> listTopics = new ArrayList<String>();
        // Aqui eu estou usando uma expressão regular para ele buscar qualquer topico que tenha como inicio "ECOMMERCE"
        listTopics.add("ECOMMERCE.*");
        kafkaConsumer.subscribe(Pattern.compile(listTopics.get(0)));
        while(true) {
            ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofMinutes(1));
            if(!consumerRecords.isEmpty()){
                consumerRecords.forEach(record -> {
                    System.out.println("-----------------------------------------------");
                    System.out.println("LOG: " + record.topic());
                    System.out.println("Key: " + record.key());
                    System.out.println("Value: " + record.value());
                    System.out.println("TimeStamp: " + record.timestamp());
                    System.out.println("Partition: " + record.partition());
                    System.out.println("Offset: " + record.offset());
                });
            }
        }
    }

    private static Properties properties(){
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, LogService.class.getSimpleName());
        return properties;
    }
}
