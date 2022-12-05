package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.io.IOException;
import java.util.Map;

public class ReportReadingService {
    private static final String ECOMMERCE_USER_GENERATE_READING_REPORT = "ECOMMERCE_USER_GENERATE_READING_REPORT";
    private ReportingUtils reportingUtils = new ReportingUtils();

    public static void main(String[] args) {
        ReportReadingService reportReadingService = new ReportReadingService();
        try(KafkaService<User> userKafkaService = new KafkaService<User>(
                ECOMMERCE_USER_GENERATE_READING_REPORT,
                reportReadingService::parse,
                ReportReadingService.class.getSimpleName(),
                User.class,
                Map.of())) {
            userKafkaService.run();
        }
    }

    private void parse(ConsumerRecord<String, Message<User>> record) throws IOException {
        System.out.println("--------------REPORT READING SERVICE------------------");
        System.out.println("Processing report for " + record.value());
        System.out.println("Key: " + record.key());
        System.out.println("Value: " + record.value());
        System.out.println("Topic: " + record.topic());
        System.out.println("TimeStamp: " + record.timestamp());
        System.out.println("Partition: " + record.partition());
        System.out.println("Offset: " + record.offset());

        // Gerado de HTML que são os relatorios.
        reportingUtils.generateReporting(
                "E:\\Java\\ecommerce\\service-reading-report\\src\\main\\resources\\template.html",
                "E:\\Java\\ecommerce\\service-reading-report\\src\\main\\resources\\",
                "titulo",
                "corpo"
        );
    }
}