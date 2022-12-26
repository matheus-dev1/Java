package br.com.alura.ecommerce;

import java.math.BigDecimal;

// Classe que representa os dados de uma ordem
public class Order {
    // A serialização e desserialização apenas usam os campos.
    // private String userId;
    private String orderId;
    private BigDecimal amount;
    private String userEmail;

    public Order(String orderId, BigDecimal amount, String userEmail) {
        // String userId,
        // this.userId = userId;
        this.orderId = orderId;
        this.amount = amount;
        this.userEmail = userEmail;
    }

    /*public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }*/

    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "br.com.alura.ecommerce.Order{" +
                "orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
