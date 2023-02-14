/**
 * 
 */
package testeLucas;

import negocio.ContaCorrente;
import negocio.GerenciadoraContas;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Lucas Silveira
 * Classe de teste criada para verificar se o funcionamento das funções da clase {@link GerenciadoraContas}
 *
 */
public class GerContaTest_3 {
	
	private GerenciadoraContas gerContas;
	
	@Test
	public void testTransfereValor () {
		
		/*  Criação do cenário*/
		/*  Criando constas*/
		
		ContaCorrente conta1 = new ContaCorrente(1, 200, true);
		ContaCorrente conta2 = new ContaCorrente(2, 0, true);
		
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		
		contasDoBanco.add(conta1);		
		contasDoBanco.add(conta2);
		
		gerContas = new GerenciadoraContas(contasDoBanco);
		
		
		// Executanto o método a ser testado
		
		gerContas.transfereValor(1, 100, 2);
		
		//verificação
		
		assertThat(conta1.getSaldo(), is (100.0));
		assertThat(conta2.getSaldo(), is (100.0));
		
		
	}
	
	

}
