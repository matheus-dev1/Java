package br.com.alura.jpa.tests;

import br.com.alura.jpa.model.MediaMovimentacaoComDiaMes;
import br.com.alura.jpa.model.Movimentacao;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TesteMovimentacoes {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String jpqlQuery = "SELECT SUM(movimentacao.valor) FROM Movimentacao AS movimentacao";
        String jpqlQueryAvg = "SELECT AVG(movimentacao.valor) FROM Movimentacao AS movimentacao";
        String jpqlQueryGroupBy = "SELECT AVG(movimentacao.valor) FROM Movimentacao AS movimentacao GROUP BY DAY(movimentacao.data), MONTH(movimentacao.data), YEAR(movimentacao.data)";
        String jpqlQueryTresResultados = "SELECT AVG(movimentacao.valor), DAY(movimentacao.data), MONTH(movimentacao.data) FROM Movimentacao AS movimentacao GROUP BY DAY(movimentacao.data), MONTH(movimentacao.data), YEAR(movimentacao.data)";
        String jpqlComClasse = "SELECT new br.com.alura.jpa.model.MediaMovimentacaoComDiaMes(AVG(movimentacao.valor), DAY(movimentacao.data), MONTH(movimentacao.data)) FROM Movimentacao AS movimentacao GROUP BY DAY(movimentacao.data), MONTH(movimentacao.data), YEAR(movimentacao.data)";
        String jpqlNativeQuery = "SELECT * FROM Movimentacao AS movimentacao";

        TypedQuery<BigDecimal> movimentacoes = entityManager.createQuery(jpqlQuery, BigDecimal.class);
        TypedQuery<Double> movimentacoesAvg = entityManager.createQuery(jpqlQueryAvg, Double.class);
        TypedQuery<Double> movimentacoesGroupBy = entityManager.createQuery(jpqlQueryGroupBy, Double.class);
        Query movimentacoesComData = entityManager.createQuery(jpqlQueryTresResultados);
        TypedQuery<MediaMovimentacaoComDiaMes> mediaMovimentacaoComDiaMes = entityManager.createQuery(jpqlComClasse, MediaMovimentacaoComDiaMes.class);
        Query nativeQuery = entityManager.createNativeQuery(jpqlNativeQuery, Movimentacao.class);

        BigDecimal somaTotalMovimentacoes = movimentacoes.getSingleResult();
        Double mediaMovimentacoes = movimentacoesAvg.getSingleResult();
        List<Double> grupoMediaMovimentacoes = movimentacoesGroupBy.getResultList();
        List<Object[]> movimentacoesComDatas = movimentacoesComData.getResultList();
        List<MediaMovimentacaoComDiaMes> mediaMovimentacaoComDiaMesResultado = mediaMovimentacaoComDiaMes.getResultList();
        List<Movimentacao> movimentacoesResultado = nativeQuery.getResultList();

        System.out.println("Soma: " + somaTotalMovimentacoes);
        System.out.println("Média: " + mediaMovimentacoes);
        grupoMediaMovimentacoes.forEach(movimentacao -> {
            System.out.println("Media do dia 'xx/xx/xxxx': " + movimentacao);
        });
        movimentacoesComDatas.forEach(movimentacao -> {
            System.out.println("  ---------------------------------------  ");
            System.out.println("Dia: " + movimentacao[1]);
            System.out.println("Mes: " + movimentacao[2]);
            System.out.println("Média da movimentacao: " + movimentacao[0]);
        });
        mediaMovimentacaoComDiaMesResultado.forEach(movimentacao -> {
            System.out.println("  --------------BY MODEL-------------  ");
            System.out.println("Data: " + movimentacao.getDia() + "/" + movimentacao.getMes() + " - R$" + movimentacao.getValor());
        });
        movimentacoesResultado.forEach(movimentacao -> {
            System.out.println(movimentacao);
        });
    }
}
