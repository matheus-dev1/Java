package br.com.alura.jpa.tests;

import br.com.alura.jpa.model.Conta;
import br.com.alura.jpa.model.Movimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaMovimentacaoConta {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Movimentacao movimentacao = entityManager.find(Movimentacao.class, 4L);
        Conta conta = movimentacao.getConta();
        Integer qtdMovimentacoes = conta.getMovimentacoes().size();

        System.out.println("Quantidade de Movimentações: " + qtdMovimentacoes);
        System.out.println(conta.toString());
    }

}
