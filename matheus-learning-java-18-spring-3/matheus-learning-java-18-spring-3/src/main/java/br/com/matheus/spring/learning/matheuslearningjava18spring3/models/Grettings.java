package br.com.matheus.spring.learning.matheuslearningjava18spring3.models;

// Record sao classes imutaveis usadas principalmente para tranportar dados (data carriers)
// Classe "Pura", sem a necessidade de escrever métodos como equals(), hashCode(), toString() e o construtor padrao
public record Grettings(
        long id,
        String content
) { }