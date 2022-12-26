package br.com.alura.ecommerce.service;

import br.com.alura.ecommerce.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.io.IOException;
import java.sql.SQLException;

// Metodos que devem ser implementados para criar um consumer.
public interface ConsumerService<T> {
    public void parse(ConsumerRecord<String, Message<T>> record) throws Exception;
    public String getTopic();
    public String getConsumerGroup();
    public Class<T> getType();
}
