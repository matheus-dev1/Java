package br.com.alura.jpa.tests;

import br.com.alura.jpa.model.Cliente;
import br.com.alura.jpa.model.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaRelacionamentoOneToOneClienteConta {
    public static void main(String[] args) {
        Conta conta = new Conta(
                9734, 001, "Rubens", 10.000
        );
        Cliente cliente = new Cliente(
                conta.getTitular(),
                "Programador Web",
                "Rua Tiradentes, 1837",
                conta
        );

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(conta);
        entityManager.persist(cliente);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
