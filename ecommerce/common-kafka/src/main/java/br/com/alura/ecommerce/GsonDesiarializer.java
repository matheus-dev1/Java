package br.com.alura.ecommerce;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

// Essa classe apenas deserializa objetos do tipo Message
public class GsonDesiarializer implements Deserializer<Message> {
    // EXPLICAR!!!
    // public static final String TYPE_CONFIG = "br.com.alura.ecommerce.type_config";
    // private Class<T> type;

    private Gson gson = new GsonBuilder().registerTypeAdapter(Message.class, new MessageAdapter()).create();

    // Esse metodo serve para configurar o tipo da minha mensagem, entao por exemplo, se eu recebo um Order, então
    // ele vai setar a minha variavel type, como Class<Order>
    // Obs: isso aqui também é um sobreecrita de um metodo que é executado pelo Kafka referente a config ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG
    /*@Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        String type = String.valueOf(configs.get(TYPE_CONFIG));
        try {
            this.type = (Class<T>) Class.forName(type);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Classe não existente", e);
        }
    }*/

    // Metodo do Kafka que estamos sobre escrevendo para deserialiar uma mensagem de bytes em T, que pode ser qualquer coisa.
    @Override
    public Message deserialize(String string, byte[] bytes) {
        // Aqui eu pegava os bytes serializados e transformo em String e vai mandar tranformar em json do tipo que esta
        // na variavel type, que poderia ser um Order, Email
        // return gson.fromJson(new String(bytes), this.type);

        return gson.fromJson(new String(bytes), Message.class);
    }
}
