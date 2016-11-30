package br.com.alura.financas.test;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JpaUtil;

public class TesteJpa {

	public static void main(String[] args) {

		
		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();

		Conta conta = em.find(Conta.class, 550);
		em.getTransaction().commit();
		
		
		em.getTransaction().begin();
		conta.setTitular("Mario Quintanas Filho");
		em.merge(conta);
		em.getTransaction().commit();
		
		System.out.println(conta.getTitular());
		em.close();

	}

	private static Conta createConta(String nome) {
		Conta conta = new Conta();
		conta.setTitular(nome);
		conta.setBanco("Banco HSBC");
		conta.setNumero("12345");
		conta.setAgencia("123-4");
		return conta;
	}

}
