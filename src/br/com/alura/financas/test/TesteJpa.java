package br.com.alura.financas.test;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.alura.financas.enums.TipoMovimentacaoEnum;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.util.JpaUtil;

public class TesteJpa {

	public static void main(String[] args) {

		
		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();

		Conta conta = em.find(Conta.class, 500);
		Movimentacao movimentacao = createMovimentacao(conta, new BigDecimal("192.4"), TipoMovimentacaoEnum.ENTRADA);
		
		em.persist(movimentacao);
		
		em.getTransaction().commit();		
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
	
	private static Movimentacao createMovimentacao(Conta conta, BigDecimal valor, TipoMovimentacaoEnum tipoMovimentacao){
		Movimentacao movimentacao = new Movimentacao();
		
		movimentacao.setConta(conta);
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Nova Movimentacao");
		movimentacao.setTipoMovimentacao(tipoMovimentacao);
		movimentacao.setValor(valor);
		
		return movimentacao;
	}

}
