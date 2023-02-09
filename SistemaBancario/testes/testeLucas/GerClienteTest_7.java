/**
 * 
 */
package testeLucas;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;



import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.CoreMatchers.*;

import negocio.Cliente;
import negocio.GerenciadoraClientes;

/**
 * Testes para garantir o funcionamento correto das operações do cliente, realizado pela classe {@link GerenciadoraClientes}
 * @author Lucas Silveira
 * @date 09/02/2023
 *
 */
public class GerClienteTest_7 {
	
	private GerenciadoraClientes gerCliente;
	private int idCliente1= 1;
	private int idCliente2= 2;
	private int idCliente3= 3;
	
	@Before
	public void setUp() {
		
		/*Montagem do Cenário*/
		
		//Criando alguns clientes
		
		Cliente  cliente1 = new Cliente(idCliente1, "Lucas Silveira", 32, "lucas.silveira@gmail.com", 4, true);
		Cliente  cliente2 = new Cliente(idCliente2, "jucelino", 32, "lucas.silveira@gmail.com",3, true);
		Cliente  cliente3 = new Cliente(idCliente3, "Jandira", 32, "lucas.silveira@gmail.com",3, true);
		
		//Inserindo clientes na lista de Clientes do banco
		
		List<Cliente> clientes = new ArrayList<>();
		
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		
		 gerCliente = new GerenciadoraClientes(clientes);
		
		
		
	}
	@After
	public void tearDown() {
		gerCliente.limpa();
	}
	
	
	
	@Test
	public void testePesquisaCliente() {
		
		//Execução 
		
	Cliente cliente = gerCliente.pesquisaCliente(idCliente1);
		
	
	//Verificação
	
	assertThat(cliente.getId(), is (idCliente1));
	
	
		
	}
	
	@Test
	public void testeRemoveCliente () {
		
		//Execução
		
		boolean clienteRemovido = gerCliente.removeCliente(idCliente2);
		
		//verificação
		
		assertTrue(clienteRemovido);
		assertThat(gerCliente.getClientesDoBanco().size(), is (2));
		assertNull(gerCliente.pesquisaCliente(idCliente2));
		
	}

}
