package br.com.alura.jpa.dao;

import br.com.alura.jpa.model.MediaMovimentacaoComDiaMes;
import br.com.alura.jpa.model.Movimentacao;
import br.com.alura.jpa.utils.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class MovimentacaoDAO {
    // EntityManager entityManager = EntityManagerUtil.gerenciadorDeEntidade();

    private EntityManager entityManager;

    public MovimentacaoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<MediaMovimentacaoComDiaMes> getMediaMovimentacaoComDiasMes() {
        String jpqlComClasse = "SELECT new br.com.alura.jpa.model.MediaMovimentacaoComDiaMes(AVG(movimentacao.valor), DAY(movimentacao.data), MONTH(movimentacao.data)) FROM Movimentacao AS movimentacao GROUP BY DAY(movimentacao.data), MONTH(movimentacao.data), YEAR(movimentacao.data)";
        TypedQuery<MediaMovimentacaoComDiaMes> mediaMovimentacaoComDiaMes = entityManager.createQuery(jpqlComClasse, MediaMovimentacaoComDiaMes.class);
        return mediaMovimentacaoComDiaMes.getResultList();
    }

    public List<MediaMovimentacaoComDiaMes> getMediaMovimentacaoComDiasMesNamedQuery() {
        TypedQuery<MediaMovimentacaoComDiaMes> mediaMovimentacaoComDiaMesNamedQuery = entityManager.createNamedQuery("mediaMovimentacaoComDiasMes", MediaMovimentacaoComDiaMes.class);
        return mediaMovimentacaoComDiaMesNamedQuery.getResultList();
    }

    public List<Movimentacao> getMovimentacoesFiltradasPorDataCriteria(Integer dia, Integer mes, Integer ano) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Movimentacao> criteriaQuery = criteriaBuilder.createQuery(Movimentacao.class);
        Root<Movimentacao> movimentacaoRoot = criteriaQuery.from(Movimentacao.class);
        List<Predicate> predicateList = new ArrayList<>();
        if (dia != null) {
            // Criando uma função no SQL e colocando um atributo
            // Exemplo: SUM(movimentacao.data)
            Expression expressionDay = criteriaBuilder.function("day", Integer.class, movimentacaoRoot.get("data"));
            /* Predicate são algumas afirmações que eu faço, por exemplo aqui, eu estou testando
             se o parametro que eu enviei é igual ao da consulta. */
            Predicate predicate = criteriaBuilder.equal(expressionDay, dia);
            predicateList.add(predicate);
        }
        if (mes != null) {
            Expression expressionMonth = criteriaBuilder.function("month", Integer.class, movimentacaoRoot.get("data"));
            Predicate predicate = criteriaBuilder.equal(expressionMonth, mes);
            predicateList.add(predicate);
        }
        if (ano != null) {
            Expression expressionYear = criteriaBuilder.function("year", Integer.class, movimentacaoRoot.get("data"));
            Predicate predicate = criteriaBuilder.equal(expressionYear, ano);
            predicateList.add(predicate);
        }

        criteriaQuery.where((Predicate[]) predicateList.toArray(new Predicate[0]));
        TypedQuery<Movimentacao> typedQuery = entityManager.createQuery(criteriaQuery);

        return typedQuery.getResultList();
    }

}
