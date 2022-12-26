package br.com.alura.ecommerce;

import br.com.alura.ecommerce.service.ConsumerService;
import br.com.alura.ecommerce.service.KafkaService;
import br.com.alura.ecommerce.service.ServiceRunner;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

// Serviço responsavel por escutar o topico ECOMMERCE_USER_GENERATE_READING_REPORT e gerar reports
public class ReportReadingService implements ConsumerService<User>  {
    private static final String ECOMMERCE_USER_GENERATE_READING_REPORT = "ECOMMERCE_USER_GENERATE_READING_REPORT";
    private ReportingUtils reportingUtils = new ReportingUtils();

    /*public static void main(String[] args) throws ExecutionException, InterruptedException {
        ReportReadingService reportReadingService = new ReportReadingService();
        try(KafkaService<User> userKafkaService = new KafkaService<User>(
                ECOMMERCE_USER_GENERATE_READING_REPORT,
                reportReadingService::parse,
                ReportReadingService.class.getSimpleName(),
                User.class,
                Map.of())) {
            userKafkaService.run();
        }
    }*/

    public static void main(String[] args) {
        new ServiceRunner(ReportReadingService::new, User.class).start(5);
    }

    @Override
    public void parse(ConsumerRecord<String, Message<User>> record) throws IOException {
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
                record.topic(),
                record.value().getPayload().toString()
        );
    }

    @Override
    public String getTopic() {
        return ECOMMERCE_USER_GENERATE_READING_REPORT;
    }

    @Override
    public String getConsumerGroup() {
        return ReportReadingService.class.getSimpleName();
    }

    @Override
    public Class<User> getType() {
        return User.class;
    }
}