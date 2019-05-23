package br.com.moraesofia.jpa2.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaexemplo");;
	
	public static EntityManager getEntityManager(){
		return factory.createEntityManager();
	}
	
}
