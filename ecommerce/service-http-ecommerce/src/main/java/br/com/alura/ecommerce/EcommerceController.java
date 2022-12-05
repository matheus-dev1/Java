package br.com.alura.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Controller
public class EcommerceController {
    public static final String ECOMMERCE_NEW_ORDER = "ECOMMERCE_NEW_ORDER";
    public static final String ECOMMERCE_NEW_EMAIL = "ECOMMERCE_NEW_EMAIL";
    private static final String ECOMMERCE_USER_GENERATE_READING_REPORT = "ECOMMERCE_USER_GENERATE_READING_REPORT";

    private final KafkaDispatcher<Order> orderKafkaDispatcher = new KafkaDispatcher<>(EcommerceController.class.getSimpleName() + "Order");
    private final KafkaDispatcher<Email> emailKafkaDispatcher = new KafkaDispatcher<>(EcommerceController.class.getSimpleName() + "Email");
    private final KafkaDispatcher<String> batchKafkaDispatcher = new KafkaDispatcher<>(EcommerceController.class.getSimpleName() + "BatchGenerateReports");

    // http://localhost:8080/new-order?email=kojodosbr@yahoo.com&amount=5000
    @GetMapping("new-order")
    public ResponseEntity<String> newOrder(@RequestParam("email") String email_value, @RequestParam("amount") String amount_value) throws ExecutionException, InterruptedException {
        String orderId = UUID.randomUUID().toString();
        String userEmail = email_value;
        BigDecimal amount = new BigDecimal(amount_value);
        Order order = new Order(orderId, amount, userEmail);

        String subject = "Title: " + UUID.randomUUID().toString();
        String body = "Random Text: " + UUID.randomUUID().toString();
        Email email = new Email(subject, body);

        orderKafkaDispatcher.send(ECOMMERCE_NEW_ORDER, userEmail, order, new CorrelationId(EcommerceController.class.getSimpleName() + "Order"));
        emailKafkaDispatcher.send(ECOMMERCE_NEW_EMAIL, userEmail, email, new CorrelationId(EcommerceController.class.getSimpleName() + "Email"));

        System.out.println("New order send successfully.");

        return ResponseEntity.ok("[ " + ECOMMERCE_NEW_ORDER + " OK ]" + "  ---   [ " + ECOMMERCE_NEW_EMAIL + " OK ]");
    }

    // http://localhost:8080/admin/generate-reports
    @GetMapping("/admin/generate-reports")
    public ResponseEntity<String> generateAllReports() throws ExecutionException, InterruptedException {
        /* Aqui eu vou enviar uma mensagem para o topico "SEND_MESSAGE_TO_ALL_USERS", no sentido de notificacao/notificar
        Até porque a chave(key) e valor(value) são sempre iguias.
        
        Essa técnica é chamada de Fast Delegate, que consiste em enviar um valor padrãoa para um topico com o intuito de notifica-lo
        Ai ele toma uma serie de decições, isso feito para não perder a mensagem, por tem um grande processamento depois de
        enviar o primeiro topico que no caso é o SEND_MESSAGE_TO_ALL_USERS */
        batchKafkaDispatcher.send(
                "ECOMMERCE_SEND_MESSAGE_TO_ALL_USERS",
                ECOMMERCE_USER_GENERATE_READING_REPORT,
                ECOMMERCE_USER_GENERATE_READING_REPORT,
                /* Pegando o exemplo desta classe(EcommerceController) que vai fazer um send, para o topico
                 ECOMMERCE_SEND_MESSAGE_TO_ALL_USERS, que está na classe BatchSendMessageUsers, que por sua vez, ao topico
                 que ele monitora receber algo, faz outro send. Ai a gente faz um track, deste Correlation id da classe EcommerceController
                 com o CorrelationId do BatchSendMessageUsers.
                 */
                new CorrelationId(EcommerceController.class.getSimpleName() + "BatchGenerateReports")
        );
        return ResponseEntity.ok("OK");
    }
}