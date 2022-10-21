package br.com.alura.jpa.tests;

import br.com.alura.jpa.model.Conta;
import br.com.alura.jpa.model.Movimentacao;

import javax.persistence.*;
import java.util.List;

public class TestaJPQLComParametro {
    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.setId(17L);

        String jpql = "SELECT movimentacao FROM Movimentacao AS movimentacao WHERE movimentacao.conta = :pConta order by movimentacao.valor desc";

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Movimentacao> queryJPQL = entityManager.createQuery(jpql, Movimentacao.class);
        queryJPQL.setParameter("pConta", conta);

        List<Movimentacao> listaDeMovimentacoes = queryJPQL.getResultList();

        listaDeMovimentacoes.forEach(movimentacao -> {
            System.out.println("========pContaModel=========");
            System.out.println("Descrição: " + movimentacao.getDescricao());
            System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
            System.out.println("Valor: " + movimentacao.getValor());
        });
    }
}
