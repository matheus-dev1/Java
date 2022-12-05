package br.com.alura.ecommerce;

public class User {

    private String uuid;

    User(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
