package br.com.alura.lolja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	/*
		Uma classe final não pode ser extendida.
		Exemplo a classe String
		- Isso é importante quando vc projeta a classe de forma a proibir a herança.
		
		Um metodo pode ser final - ele não pode ser sobreescrito
		- Exemplo a classe Thread possui um metodo chamado isAlive que, se vc sobreescrever, teria as mais exoticas reações dentro da maquina virtual java.
		
		Um atributo pode ser final - uma vez definido vc nao pode mudar a referencia do objeto.
		- Util quando vc quer trabalhar com imutabilidade.
		
		Um argumento pode ser final.
		- Ele não pode ter o seu valor alterado dentro do metodo
	*/
	
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("lolja"); 
	
	public static EntityManager getEntityManager() {
		return ENTITY_MANAGER_FACTORY.createEntityManager();
	}
}
