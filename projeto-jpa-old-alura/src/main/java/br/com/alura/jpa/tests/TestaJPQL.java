package br.com.alura.jpa.tests;

import br.com.alura.jpa.model.Movimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class TestaJPQL {
    public static void main(String[] args) {
        // Trazer todas as movimentações de uma conta especifica.
        // Pegando a classe "Movimentacao" e colocando em uma variavel chamada "movimentacao" minuscula.
        String jpql = "SELECT movimentacao FROM Movimentacao AS movimentacao WHERE movimentacao.conta.id = 3";

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query queryJPQL = entityManager.createQuery(jpql);

        List<Movimentacao> listaDeMovimentacoes = queryJPQL.getResultList();

        listaDeMovimentacoes.forEach(movimentacao -> {
            System.out.println("=========JPQL========");
            System.out.println("Descrição: " + movimentacao.getDescricao());
            System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
            System.out.println("Valor: " + movimentacao.getValor());
        });
    }
}
