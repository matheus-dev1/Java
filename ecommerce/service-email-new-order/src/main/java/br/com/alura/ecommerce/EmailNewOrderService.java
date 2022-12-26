package br.com.alura.ecommerce;

import br.com.alura.ecommerce.service.KafkaDispatcher;
import br.com.alura.ecommerce.service.KafkaService;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

// Serviço responsavel por escutar uma nova order e enviar um email.
public class EmailNewOrderService {
    public static final String ECOMMERCE_NEW_ORDER = "ECOMMERCE_NEW_ORDER";
    public static final String ECOMMERCE_NEW_EMAIL = "ECOMMERCE_NEW_EMAIL";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        EmailNewOrderService emailNewOrderService = new EmailNewOrderService();
        try(KafkaService<Order> kafkaService = new KafkaService<Order>(
                ECOMMERCE_NEW_ORDER,
                emailNewOrderService::parse,
                EmailNewOrderService.class.getSimpleName(),
                Order.class,
                Map.of())
        ) {
            kafkaService.run();
        }
    }

    private KafkaDispatcher<Email> emailNewOrderService = new KafkaDispatcher<Email>(EmailNewOrderService.class.getSimpleName());

    private void parse(ConsumerRecord<String, Message<Order>> record) throws ExecutionException, InterruptedException {
        System.out.println("--------------EMAIL NEW ORDER SERVICE------------------");
        System.out.println("Processing a new order, preparing email...");
        System.out.println("Key: " + record.key());
        System.out.println("Value: " + record.value());
        System.out.println("Topic: " + record.topic());
        System.out.println("TimeStamp: " + record.timestamp());
        System.out.println("Partition: " + record.partition());
        System.out.println("Offset: " + record.offset());

        String subject = "title-" + UUID.randomUUID().toString();
        String body = UUID.randomUUID().toString() + "@email.com";
        Email email = new Email(subject, body);
        
        // Aplicando a ideia do fast delegate.
        emailNewOrderService.send(
                ECOMMERCE_NEW_EMAIL,
                record.value().getPayload().getUserEmail(),
                email,
                record.value().getCorrelationId().continueCorrelationWith(EmailNewOrderService.class.getSimpleName())
        );
    }
}
