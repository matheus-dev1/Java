package br.com.alura.ecommerce;

import br.com.alura.ecommerce.service.ConsumerService;
import br.com.alura.ecommerce.service.ServiceRunner;
import org.apache.kafka.clients.consumer.ConsumerRecord;

// Serviço responsavel escutar o topico de Email(ECOMMERCE_NEW_EMAIL)
public class EmailService implements ConsumerService<Email> {
    public static final String ECOMMERCE_NEW_EMAIL = "ECOMMERCE_NEW_EMAIL";

    /*public static void main(String[] args) throws ExecutionException, InterruptedException {
        EmailService emailService = new EmailService();
        // 1. Primeiro parametro o topico que está escutando.
        // 2.Metodo que eu executo para cada mensagem de que recebo
        try(KafkaService<Email> kafkaService = new KafkaService<Email>(
                ECOMMERCE_NEW_EMAIL,
                emailService::parse,
                EmailService.class.getSimpleName(),
                Email.class,
                Map.of())
            ){
            // Executa toda a logica do EmailService
            kafkaService.run();
        }
    }*/

    public static void main(String[] args) throws Exception {
        // new EmailService() vai ser o T de ConsumerService, podendo executar seus metodos.
        // new ServiceProvider().run(EmailService::new, Email.class);
        // new ServiceProvider(EmailService::new, Email.class).call();
        new ServiceRunner(EmailService::new, Email.class).start(5);
    }

    @Override
    public String getTopic() {
        return ECOMMERCE_NEW_EMAIL;
    }

    @Override
    public String getConsumerGroup() {
        return EmailService.class.getSimpleName();
    }

    @Override
    public Class<Email> getType() {
        return Email.class;
    }

    // Recebe como parametro um UNICO record
    // A ideia do "parse" é consumir alguma coisa
    @Override
    public void parse(ConsumerRecord<String, Message<Email>> consumerRecord) {
        System.out.println("--------------EMAIL SERVICE------------------");
        System.out.println("Sending a new e-mail...");
        System.out.println("Key: " + consumerRecord.key());
        System.out.println("Value: " + consumerRecord.value());
        System.out.println("Topic: " + consumerRecord.topic());
        System.out.println("TimeStamp: " + consumerRecord.timestamp());
        System.out.println("Partition: " + consumerRecord.partition());
        System.out.println("Offset: " + consumerRecord.offset());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("E-mail Processed!");
    }

    /*
    KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(properties());
    List<String> listTopics = new ArrayList<String>();
    listTopics.add(ECOMMERCE_NEW_EMAIL);
    kafkaConsumer.subscribe(listTopics);
        while (true) {
            ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofMinutes(1));
            if (!consumerRecords.isEmpty()) {
                System.out.println("Records " + consumerRecords.count() + " founded!");
                consumerRecords.forEach(record -> {
                    System.out.println("-----------------------------------------------");
                    System.out.println("Sending a new e-mail...");
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
                    System.out.println("E-mail Processed!");
                });
            }
        }
        */

    /*private static Properties properties(){
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, EmailService.class.getSimpleName());
        return properties;
    }*/
}
