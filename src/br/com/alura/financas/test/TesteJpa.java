package br.com.alura.financas.test;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Locale;

import javax.persistence.EntityManager;

import br.com.alura.financas.enums.TipoMovimentacaoEnum;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.util.JpaUtil;

public class TesteJpa {

	public static void main(String[] args) throws ParseException {

		
		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();

		Conta conta = em.find(Conta.class, 50);
		Movimentacao movimentacao = createMovimentacao(conta, new BigDecimal("220.00"), TipoMovimentacaoEnum.SAIDA, "Imposto de Renda");
		
		em.persist(movimentacao);
		
//		Conta conta = createConta("Carem Souza Almeida", "Bradesco");
//		em.persist(conta);
		
		
		em.getTransaction().commit();		
		em.close();
		System.exit(0);
	}

	private static Conta createConta(String titular, String banco ){
		Conta conta = new Conta();
		conta.setTitular(titular);
		conta.setBanco(banco);
		conta.setNumero("12345");
		conta.setAgencia("123-4");
		return conta;
	}
	
	private static Movimentacao createMovimentacao(Conta conta, BigDecimal valor, TipoMovimentacaoEnum tipoMovimentacao, String descricao){
		Movimentacao movimentacao = new Movimentacao();
		
		movimentacao.setConta(conta);
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao(descricao);
		movimentacao.setTipoMovimentacao(tipoMovimentacao);
		movimentacao.setValor(valor);
		
		return movimentacao;
	}

}
