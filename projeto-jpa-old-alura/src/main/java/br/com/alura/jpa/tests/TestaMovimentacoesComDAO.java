package br.com.alura.jpa.tests;

import br.com.alura.jpa.dao.MovimentacaoDAO;
import br.com.alura.jpa.model.MediaMovimentacaoComDiaMes;
import br.com.alura.jpa.model.Movimentacao;
import br.com.alura.jpa.utils.EntityManagerUtil;

import java.util.List;

public class TestaMovimentacoesComDAO {
    public static void main(String[] args) {
        MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO(EntityManagerUtil.gerenciadorDeEntidade());

        List<MediaMovimentacaoComDiaMes> mediaMovimentacaoComDiaMes = movimentacaoDAO.getMediaMovimentacaoComDiasMes();
        mediaMovimentacaoComDiaMes.forEach(movimentacao -> {
            System.out.println("  --------------BY MODEL-------------  ");
            System.out.println("Data: " + movimentacao.getDia() + "/" + movimentacao.getMes() + " - R$" + movimentacao.getValor());
        });

        List<MediaMovimentacaoComDiaMes> mediaMovimentacaoComDiaMesNamedQuery = movimentacaoDAO.getMediaMovimentacaoComDiasMesNamedQuery();
        mediaMovimentacaoComDiaMesNamedQuery.forEach(movimentacao -> {
            System.out.println("  --------------NAMED QUERY-------------  ");
            System.out.println("Data: " + movimentacao.getDia() + "/" + movimentacao.getMes() + " - R$" + movimentacao.getValor());
        });

        List<Movimentacao> movimentacoes = movimentacaoDAO.getMovimentacoesFiltradasPorDataCriteria(23, 05, 2022);
        movimentacoes.forEach(movimentacao -> {
            System.out.println("  --------------CRITERIA-------------  ");
            System.out.println("Data: " + movimentacao.getData() + " - R$" + movimentacao.getValor());
        });
    }
}
