package br.com.alura.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas-postgresql");
	
	
	public EntityManager getEntityManager(){
		
		return emf.createEntityManager();
	}

}
