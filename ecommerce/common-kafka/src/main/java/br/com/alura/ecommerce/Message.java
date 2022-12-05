package br.com.alura.ecommerce;

// Isso aqui é um objeto de mensagem generico, que pode ser adicionado novas parametro sem afetar a regra de negocio
// que é o conteudo(payload)
public class Message<T> {

    private CorrelationId correlationId;
    private T payload;

    Message(CorrelationId correlationId, T payload) {
        this.correlationId = correlationId;
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Message{" +
                "correlationId='" + correlationId + '\'' +
                ", payload=" + payload +
                '}';
    }

    public CorrelationId getCorrelationId() {
        return correlationId;
    }
    public void setCorrelationId(CorrelationId correlationId) {
        this.correlationId = correlationId;
    }

    public T getPayload() {
        return payload;
    }
    public void setPayload(T payload) {
        this.payload = payload;
    }
}
