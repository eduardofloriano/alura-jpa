package br.com.alura.financas.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.financas.modelo.Conta;

public class TesteJpa {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setAgencia("Agencia Teste Um");
		conta.setBanco("Banco Teste Um");
		conta.setNumero("Numero Teste Um");
		conta.setTitular("Titular Teste Um");
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas-postgresql");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(conta);
		
		em.getTransaction().commit();
		em.close();
		

	}

}
