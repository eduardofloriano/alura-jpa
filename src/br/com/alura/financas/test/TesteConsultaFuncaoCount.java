package br.com.alura.financas.test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JpaUtil;

public class TesteConsultaFuncaoCount {

	
	
	public static void main(String[] args) {

		EntityManager em = new JpaUtil().getEntityManager();

		Conta conta = em.find(Conta.class, 100);
		TypedQuery<Long> query = em.createQuery(
				"select count(m) from Movimentacao m where m.conta = :pConta",
				Long.class);

		query.setParameter("pConta", conta);

		long valor = query.getSingleResult();
		System.out.println("Total de movimentacoes: " + valor);

		em.close();
		System.exit(0);

	}
	
}
