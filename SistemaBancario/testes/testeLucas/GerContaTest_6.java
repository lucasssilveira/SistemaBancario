/**
 * 
 */
package testeLucas;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import negocio.ContaCorrente;
import negocio.GerenciadoraContas;

/**
 * @author Lucas Silveira
 * 
 *         Teste das funcionalidades da clasee {@link GerenciadoraContas}
 *
 */
public class GerContaTest_6 {

	private GerenciadoraContas gerContas;

	@Test
	public void testTransfereValor() {

		/* Criação do cenário */
		/* Criando constas */

		int idConta1 = 1;
		int idConta2 = 2;

		ContaCorrente conta1 = new ContaCorrente(idConta1, 200, true);
		ContaCorrente conta2 = new ContaCorrente(idConta2, 0, true);

		List<ContaCorrente> contasDoBanco = new ArrayList<>();

		contasDoBanco.add(conta1);
		contasDoBanco.add(conta2);

		gerContas = new GerenciadoraContas(contasDoBanco);

		// Executanto o método a ser testado

		boolean sucesso = gerContas.transfereValor(1, 100, 2);

		// verificação

		assertTrue(sucesso);
		assertThat(conta2.getSaldo(), is(100.0));
		assertThat(conta1.getSaldo(), is(100.0));

	}

	/*
	 * Teste para verificar a tentativa de transferir um valor insuficiente
	 * 
	 * @author Lucas Silveira
	 * 
	 * 
	 */

	@Test
	public void trasnfereValorInsuficiente() {

		/* Criação do cenário */
		/* Criando constas */

		int idConta1 = 1;
		int idConta2 = 2;

		ContaCorrente conta1 = new ContaCorrente(idConta1, 100, true);
		ContaCorrente conta2 = new ContaCorrente(idConta2, 0, true);

		List<ContaCorrente> contasDoBanco = new ArrayList<>();

		contasDoBanco.add(conta1);
		contasDoBanco.add(conta2);

		gerContas = new GerenciadoraContas(contasDoBanco);

		// Executanto o método a ser testado

		boolean sucesso = gerContas.transfereValor(idConta1, 200, idConta2);

		// verificação

		assertTrue(sucesso);
		assertThat(conta1.getSaldo(), is(-100.0));
		assertThat(conta2.getSaldo(), is(200.0));

	}

}
