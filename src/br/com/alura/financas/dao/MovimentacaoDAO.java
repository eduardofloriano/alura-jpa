package br.com.alura.financas.dao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.financas.enums.TipoMovimentacaoEnum;
import br.com.alura.financas.modelo.Conta;

public class MovimentacaoDAO {

	private EntityManager em;
	
	public MovimentacaoDAO(EntityManager em ){
		this.em = em;
	}
	
	public BigDecimal obterSomaMovimentacoesPorConta(Conta conta, TipoMovimentacaoEnum tipo){
		
		TypedQuery<BigDecimal> query = em.createQuery("select sum(m.valor) from Movimentacao m where m.conta = :pConta"
				+ " and m.tipoMovimentacao = :pTipo", BigDecimal.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipo);
		
		BigDecimal valor = query.getSingleResult();
		return valor;
		
	}
	
	
	public Double obterMediaMovimentacoesPorConta(Conta conta, TipoMovimentacaoEnum tipo){
		
		TypedQuery<Double> query = em.createNamedQuery("obterMediaMovimentacoesPorConta", Double.class);
		
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipo);
		
		Double valor = query.getSingleResult();
		return valor;
		
	}
	
}
