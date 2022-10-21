package br.com.alura.jpa.tests;

import br.com.alura.jpa.model.Categoria;
import br.com.alura.jpa.model.Movimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TestaJPQLMovimentacaoDeUmaCategoriaJoin {
    public static void main(String[] args) {
        Categoria categoria = new Categoria();
        categoria.setId(3L);

        String jpql = "SELECT movimentacao FROM Movimentacao AS movimentacao JOIN movimentacao.categorias AS categorias WHERE categorias = :pCategorias";

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Movimentacao> queryJPQL = entityManager.createQuery(jpql, Movimentacao.class);
        queryJPQL.setParameter("pCategorias", categoria);

        List<Movimentacao> listaDeMovimentacoes = queryJPQL.getResultList();

        listaDeMovimentacoes.forEach(movimentacao -> {
            System.out.println("========pContaModel=========");
            System.out.println("Categorias: " + movimentacao.getCategorias());
            System.out.println("Descrição: " + movimentacao.getDescricao());
            System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
            System.out.println("Valor: " + movimentacao.getValor());
        });
    }
}
