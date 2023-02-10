package testeLucas;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import negocio.Cliente;
import negocio.GerenciadoraClientes;
import negocio.IdadeNaoPermitidaException;

import static org.hamcrest.CoreMatchers.*;

/**
 * Classe de teste para garantir o funcionamento das principais operações sobre
 * clientes, realizadas pela classe {@link GerenciadoraClientes}.
 * 
 * @author Lucas Silveira
 * @date 10/02/2023
 */

public class GerClienteTest_10 {

	private GerenciadoraClientes gerClientes;
	private int idCLiente01 = 1;
	private int idCLiente02 = 2;

	@Before
	public void setUp() {

		/* ========== Criando o Cenário ========== */

		// criando alguns clientes
		Cliente cliente01 = new Cliente(idCLiente01, "Lucas Silveira", 32, "lucas@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCLiente02, "Cristianao Ronaldo", 35, "cris@gmail.com", 1, true);

		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);

		gerClientes = new GerenciadoraClientes(clientesDoBanco);
	}

	@After
	public void tearDown() {
		gerClientes.limpa();
	}

	@Test
	public void testPesquisaCliente() {

		/* ========== Execução========== */
		Cliente cliente = gerClientes.pesquisaCliente(idCLiente01);

		/* ========== Verificações(testes) ========== */
		assertThat(cliente.getId(), is(idCLiente01));

	}

	@Test
	public void testeRemoveCliente() {

		// Execução

		boolean clienteRemovido = gerClientes.removeCliente(idCLiente02);

		// verificação

		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCLiente02));
	}

	// Teste para verificar a tentativa de remover um cliente inexistente

	@Test
	public void testeRemoveClienteInexistente() {

		// Execução
		boolean clienteInexistente = gerClientes.removeCliente(10001);

		// Verificação

		assertThat(clienteInexistente, is(false));
		assertThat(gerClientes.getClientesDoBanco().size(), is(2));

	}

	/*
	 * teste para validar a se a entrada correta da idade, dentro do valor permitido
	 * 
	 * @author Lucas Silveira
	 * 
	 * @date 10/02/2023
	 */
	@Test
	public void testeIdadeValida1() throws IdadeNaoPermitidaException {

		// Criando um cliente com idade válida

		Cliente cliente = new Cliente(1, "Lucas S", 25, "lukas.silveira@hotmail.com", 7, true);

		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());

		assertTrue(idadeValida);

	}

	/*
	 * teste para validar a se a entrada correta da idade, dentro do valor permitido
	 * 
	 * @author Lucas Silveira
	 * 
	 * @date 10/02/2023
	 */
	@Test
	public void testidadeValida2() throws IdadeNaoPermitidaException {
		
		Cliente cliente = new Cliente(1, "Lucas S", 18, "lukas.silveira@hotmail.com", 7, true);

		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());

		assertTrue(idadeValida);

	}
	
	/*
	 * teste para validar a se a entrada correta da idade, dentro do valor permitido
	 * 
	 * @author Lucas Silveira
	 * 
	 * @date 10/02/2023
	 */
	@Test
	public void testidadeValida3 () throws IdadeNaoPermitidaException {
		
		Cliente cliente = new Cliente(1, "Lucas S", 65, "lukas.silveira@hotmail.com", 7, true);

		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());

		assertTrue(idadeValida);
		
	}
	
	/*
	 * teste para validar a se a entrada correta da idade, dentro do valor permitido
	 * 
	 * @author Lucas Silveira
	 * 
	 * @date 10/02/2023
	 */
	
	@Test
	public void testidadeValida4 () throws IdadeNaoPermitidaException {
		
		Cliente cliente = new Cliente(1, "Lucas S", 17, "lukas.silveira@hotmail.com", 7, true);

		

		try {
			gerClientes.validaIdade(cliente.getIdade());
			fail();
			
		}catch (Exception e) {
			
			assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
		}
		
		
	}
	
	
	/*
	 * teste para validar a se a entrada correta da idade, dentro do valor permitido
	 * 
	 * @author Lucas Silveira
	 * 
	 * @date 10/02/2023
	 */
	
	@Test
	public void testidadeValida5 () throws IdadeNaoPermitidaException {
		
		Cliente cliente = new Cliente(1, "Lucas S", 68, "lukas.silveira@hotmail.com", 7, true);

		

		try {
			gerClientes.validaIdade(cliente.getIdade());
			fail();
			
		}catch (Exception e) {
			
			assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
		}
		
		
	}
	
	
	

}
