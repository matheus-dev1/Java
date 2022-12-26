package br.com.alura.ecommerce.json;

import br.com.alura.ecommerce.Message;
import br.com.alura.ecommerce.MessageAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.common.serialization.Serializer;

// Serializar o seu objeto generico em Json
// Então no caso do Order ele retornaria isso no "value":
// {"userId":"f58531bc-f2ed-4697-ad30-76ec13e5ebef","orderId":"7d9b41ba-858c-46f1-9d4c-5940a87a9057","amount":788.78086557968026681919582188129425048828125}
public class GsonSerializer<T> implements Serializer<T> {
    // Basicamente ele gera uma instancia de GSON, que nos podemos entender como uma chave vazia {}.
    // private Gson gson = new GsonBuilder().create();

    // Aqui eu posso criar um Adaptador para a minha classe Message, que esse adapter é uma
    // outra classe implementando essa adaptação.
    private Gson gson = new GsonBuilder().registerTypeAdapter(Message.class, new MessageAdapter()).create();

    // Esse metodo é do proprio Kafka, eu to sobreescrevendo este metodo.
    @Override
    public byte[] serialize(String string, T object) {
        // Retornando em Bytes que é como o Kafka consegue receber.

        // Exemplo SEM o objeto Message
        // Se o meu objeto fosse por exemplo um Order do FraudDetectorService
        // ele retornaria tipo:
        // {
        //   orderId: 76381ea4-05b4-4172-bc2f-a901135dffdf,
        //   amount: 5000.0,
        //   userEmail: user@user.com
        // }
        // return gson.toJson(object).getBytes();

        return gson.toJson(object).getBytes();
    }
}
