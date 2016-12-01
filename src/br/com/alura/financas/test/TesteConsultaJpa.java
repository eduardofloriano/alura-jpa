package br.com.alura.financas.test;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.util.JpaUtil;

public class TesteConsultaJpa {

	
	public static void main(String[] args) {
		
		EntityManager em = new JpaUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(400);
		
		Query query = em.createQuery("select m from Movimentacao m where m.conta = :pConta");
		query.setParameter("pConta", conta);
		
		List<Movimentacao> movimentacoes = query.getResultList();
		
		for(Movimentacao movimentacao : movimentacoes){
			System.out.println("Movimentacao: " + movimentacao.getDescricao() 
			+ " Valor: " + movimentacao.getValor() 
			+ " Tipo: " + movimentacao.getTipoMovimentacao().toString());			
		}
		
		em.close();
		
		
		
		
	}
}
