package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.*;
import java.util.regex.Pattern;

public class LogService {
    public static void main(String[] args) {
        LogService logService = new LogService();
        try(KafkaService<String> kafkaService = new KafkaService<String>(
                // Se você gerar novos topicos enquanto esta rodando o logService ele não vai pegar estes novos topicos
                // porque você esta usando o Pattern, você precisa reiniciar o serviço.
                Pattern.compile("ECOMMERCE.*"),
                logService::parse,
                LogService.class.getSimpleName(),
                String.class,
                Map.of(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName()))
        ) {
            kafkaService.run();
        }
    }

    private void parse(ConsumerRecord<String, Message<String>> record) {
        System.out.println("----------------LOG SERVICE------------------");
        System.out.println("LOG: " + record.topic());
        System.out.println("Key: " + record.key());
        System.out.println("Value: " + record.value());
        System.out.println("TimeStamp: " + new Date(record.timestamp()));
        System.out.println("Partition: " + record.partition());
        System.out.println("Offset: " + record.offset());
        System.out.println("leaderEpoch: " + record.leaderEpoch());
    }
}

        /*KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(properties());
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
        }*/

    /*private static Properties properties(){
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, LogService.class.getSimpleName());
        return properties;
    }*/