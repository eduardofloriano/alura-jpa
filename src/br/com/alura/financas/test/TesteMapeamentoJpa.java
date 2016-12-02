package br.com.alura.financas.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.util.JpaUtil;

public class TesteMapeamentoJpa {

	public static void main(String[] args) {
		
		EntityManager em = new JpaUtil().getEntityManager();
		
//		Buscar todas movimentacoes da conta
		//Conta conta = em.find(Conta.class, 500);
		Query query = em.createQuery("select c from Conta c join fetch c.movimentacoes where c.id = :pConta");
		query.setParameter("pConta", 500);
		Conta conta = (Conta) query.getSingleResult();
		em.close();
		System.out.println(conta.getMovimentacoes().size());
		
//		Query query = em.createQuery("select c from Conta c join fetch c.movimentacoes");
//		Query query = em.createQuery("select c from Conta c");
//		List<Conta> contas = query.getResultList();
//		
//		for(Conta conta : contas){
//			System.out.println("Conta: " + conta.getTitular() + " - Total de movimentacoes: " + conta.getMovimentacoes().size());
//		}
		

		
		//System.exit(0);
		
	}

}
