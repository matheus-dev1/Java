package br.com.alura.jpa.tests;

import br.com.alura.jpa.model.Movimentacao;
import br.com.alura.jpa.utils.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;

/* CriteriaQuery é uma api do JPA, para criar querys dinamicas orientadas a objetos. */
public class TesteCriteriaQuery {
    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerUtil.gerenciadorDeEntidade();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BigDecimal> criteriaQuery = criteriaBuilder.createQuery(BigDecimal.class);
        /* Essa é a raiz da nossa consulta, então essa é a base da nossa consulta e nos vamos colocando
        parametros para compor a nossa consulta. */
        Root<Movimentacao> movimentacaoRootFrom = criteriaQuery.from(Movimentacao.class);
        /* sum(movimentacao.valor) */
        Expression<BigDecimal> bigDecimalExpressionSum = criteriaBuilder.sum(movimentacaoRootFrom.<BigDecimal>get("valor"));
        criteriaQuery.select(bigDecimalExpressionSum);
        TypedQuery<BigDecimal> bigDecimalTypedQuery = entityManager.createQuery(criteriaQuery);
        BigDecimal mediaMovimentacao =  bigDecimalTypedQuery.getSingleResult();
        System.out.println("Soma das movimentações: " + mediaMovimentacao);
    }
}
