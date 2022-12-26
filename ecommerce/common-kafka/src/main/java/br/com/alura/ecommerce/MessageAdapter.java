package br.com.alura.ecommerce;

import com.google.gson.*;

import java.lang.reflect.Type;

// Classe responsavel por implementar como sera feito a searialização e desereialização de objetos do tipo Message
// que é o pai de qualquer objeto deste projeto que tem relação com a regra de negocio.
public class MessageAdapter implements JsonSerializer<Message>, JsonDeserializer<Message> {
    // Aqui eu estou adaptando como o meu JSON referente a classe Message
    @Override
    public JsonElement serialize(Message message, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", message.getPayload().getClass().getName());
        jsonObject.add("payload", jsonSerializationContext.serialize(message.getPayload()));
        jsonObject.add("correlationId", jsonSerializationContext.serialize(message.getCorrelationId()));
        return jsonObject;
    }
    // Aqui estou pegando o um objeto do tipo message para ser deserializado.
    @Override
    public Message deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        // Instanciando um JSon como objeto
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        // Quando receber o objeto ele vai procurar pelas propriedades ("type", "payload" e "correlationId")
        // Aqui eu vou pegar o FQN do tipo da classe
        String payloadType = jsonObject.get("type").getAsString();
        // Aqui eu vou trazer o objeto jenuinamente
        CorrelationId correlationIdObject = (CorrelationId) jsonDeserializationContext.deserialize(jsonObject.get("correlationId"), CorrelationId.class);
        try {
            // Definindo o payload baseado no FQN.
            Object payload = jsonDeserializationContext.deserialize(jsonObject.get("payload"), Class.forName(payloadType));
            // E retorna uma nova instancia de Message.
            return new Message(correlationIdObject, payload);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new JsonParseException(e);
        }
    }
}
