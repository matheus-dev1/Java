package br.com.alura.jpa.tests;

import br.com.alura.jpa.enums.TipoMovimentacao;
import br.com.alura.jpa.model.Categoria;
import br.com.alura.jpa.model.Conta;
import br.com.alura.jpa.model.Movimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
/* Já quando trabalhamos com JPA, há uma linguagem chamada Java Persistence Query Language ou
* JPQL, a qual é uma query de mais alto nível que nos permitirá escrevê-la usando o nome
* de nossos objetos, classes e atributos, e não mais por meio dos nomes de tabelas e colunas.
* */
public class TestaRelacionamentoMuitosParaMuitosMovimentacaoCategoria {
    public static void main(String[] args) {
        Categoria categoriaUm = new Categoria("Compras");
        Categoria categoriaDois = new Categoria("Lazer");
        List<Categoria> categorias = Arrays.asList(categoriaUm, categoriaDois);

        Conta conta = new Conta(
                9734, 001, "Rubens", 10.000
        );

        Movimentacao movimentacaoUm = new Movimentacao(
                new BigDecimal(1.000),
                TipoMovimentacao.TIPO_SAIDA,
                LocalDateTime.now(),
                "Compras de livros geek",
                conta,
                categorias
        );

        Movimentacao movimentacaoDois = new Movimentacao(
                new BigDecimal(5.000),
                TipoMovimentacao.TIPO_SAIDA,
                LocalDateTime.now(),
                "Compra um sofá",
                conta,
                categorias
        );

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(conta);

        entityManager.persist(categoriaUm);
        entityManager.persist(categoriaDois);

        entityManager.persist(movimentacaoUm);
        entityManager.persist(movimentacaoDois);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
