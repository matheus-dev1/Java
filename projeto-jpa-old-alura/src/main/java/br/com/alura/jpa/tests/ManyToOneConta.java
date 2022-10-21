package br.com.alura.jpa.tests;

import br.com.alura.jpa.enums.TipoMovimentacao;
import br.com.alura.jpa.model.Conta;
import br.com.alura.jpa.model.Movimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ManyToOneConta {
    public static void main(String[] args) {
        Conta conta = new Conta(8249, 33, "Beneditis", 20.000);
        Movimentacao movimentacao = new Movimentacao(
                new BigDecimal(1000),
                TipoMovimentacao.TIPO_SAIDA,
                LocalDateTime.now(),
                "churrascaria bom bife",
                conta
        );

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(conta);
        entityManager.persist(movimentacao);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
