package br.com.alura.ecommerce;

import java.math.BigDecimal;

// Order EmailNewOrderService
public class Order {
    private String orderId;
    private BigDecimal amount;
    private String userEmail;

    public Order(String orderId, BigDecimal amount, String userEmail) {
        this.orderId = orderId;
        this.amount = amount;
        this.userEmail = userEmail;
    }

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
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
