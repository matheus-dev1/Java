package br.com.alura.jpa.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
    public static EntityManager gerenciadorDeEntidade(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
        return entityManagerFactory.createEntityManager();
    }
}
