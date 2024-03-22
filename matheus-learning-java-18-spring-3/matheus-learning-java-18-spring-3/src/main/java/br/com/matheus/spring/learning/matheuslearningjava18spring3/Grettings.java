package br.com.matheus.spring.learning.matheuslearningjava18spring3;

public class Grettings {

    private final long id;
    private final String content;

    public Grettings(long id, String content) {
        this.id = id;
        this.content = content;

    }

    public long getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }
}
