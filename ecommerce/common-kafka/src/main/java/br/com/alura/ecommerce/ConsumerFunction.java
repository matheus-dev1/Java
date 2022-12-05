package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public interface ConsumerFunction<T> {
    // Interface implementada via Method Reference, ou seja, esse metodo "Consume" que não faz nada recebe uma referencia de um que faz.
    void consume(ConsumerRecord<String, Message<T>> consumerRecord) throws ExecutionException, InterruptedException, SQLException, IOException;
}
