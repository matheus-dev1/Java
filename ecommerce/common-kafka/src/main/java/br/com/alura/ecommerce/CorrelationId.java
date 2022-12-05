package br.com.alura.ecommerce;

import java.util.UUID;

public class CorrelationId {

    private String correlationId;
    private String title;

    public CorrelationId(String name) {
        // "Track" da requisição dessa instancia.
        this.correlationId = name + "(" + UUID.randomUUID().toString() + ")";
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public CorrelationId continueCorrelationWith(String title) {
        // Eu vou instanciar um novo CorellationId, pegando o valor do corelationId da insancia anterior e concatenando com um novo
        // Message{correlationId='CorrelationId{correlationId='EcommerceControllerBatchGenerateReports(ae11f01a-d9d7-4e98-bde8-3f91ba2fcf73)-BatchSendMessageUsers(440392fb-04c5-4f19-8cdf-313821b6c58f)'}'
        return new CorrelationId(this.correlationId + "-" + title);
    }

    @Override
    public String toString() {
        return "CorrelationId{" +
                "correlationId='" + correlationId + '\'' +
                '}';
    }
}
