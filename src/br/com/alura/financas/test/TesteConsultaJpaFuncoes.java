package br.com.alura.financas.test;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.financas.dao.MovimentacaoDAO;
import br.com.alura.financas.enums.TipoMovimentacaoEnum;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JpaUtil;

public class TesteConsultaJpaFuncoes {

	public static void main(String[] args) {
		
		EntityManager em = new JpaUtil().getEntityManager();
		
		MovimentacaoDAO dao = new MovimentacaoDAO(em);
		
		Conta conta = em.find(Conta.class, 100);
		
		BigDecimal valorSoma = dao.obterSomaMovimentacoesPorConta(conta, TipoMovimentacaoEnum.SAIDA);
		double valorMedia = dao.obterMediaMovimentacoesPorConta(conta, TipoMovimentacaoEnum.SAIDA);
		
		System.out.println("Soma: "+valorSoma);
		System.out.println("Media: "+valorMedia);
				
		em.close();
		System.exit(0);
		
		

	}

}
