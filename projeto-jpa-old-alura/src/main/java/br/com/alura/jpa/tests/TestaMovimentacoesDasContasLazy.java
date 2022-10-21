package br.com.alura.jpa.tests;

import br.com.alura.jpa.model.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TestaMovimentacoesDasContasLazy {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
        EntityManager entityManger = entityManagerFactory.createEntityManager();

        /* LEFT JOIN FETCH - No caso de um select, ele vai trazer tudo do lado esquerdo do join
        mesmo que não tenha relacionado com o lado direito, ou seja, neste caso da conta ele
        vai trazer todas as contas independentes se há movimentações relacionadas a elas. */
        /* Ao usar distinct dizemos ao banco que queremos apenas os resultados diferentes. */
        String jpqlQuery = "SELECT DISTINCT conta FROM Conta AS conta LEFT JOIN FETCH conta.movimentacoes";

        TypedQuery<Conta> contaResult = entityManger.createQuery(jpqlQuery, Conta.class);

        List<Conta> listaDeContas = contaResult.getResultList();

        listaDeContas.forEach(conta -> {
            System.out.println(conta.getTitular());
            System.out.println(conta.getAgencia());
            System.out.println(conta.getSaldo());
            System.out.println(conta.getNumero());
            System.out.println(conta.getMovimentacoes());
            System.out.println("--------------------------------");
        });
    }
}
