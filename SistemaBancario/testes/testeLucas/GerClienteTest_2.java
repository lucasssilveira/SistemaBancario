package testeLucas;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import negocio.Cliente;
import negocio.GerenciadoraClientes;

import static org.hamcrest.CoreMatchers.*;

public class GerClienteTest_2 {
	
	@Test
	public void RemoveCliente() {
		
		//Preparando os dados
		/* Criando cliente e uma lista com alguns clientes
		 * */
		
		Cliente cliente1 = new Cliente(1, "Lucas Silveira", 34, "lucas.silveira@hotmail.com", 4, true);
		Cliente cliente2 = new Cliente(2, "Treyce amor", 24, "treyce.silveira@hotmail.com", 4, true);
		
		List<Cliente> clientes = new ArrayList<>();
		
		clientes.add(cliente1);
		clientes.add(cliente2);
		
		GerenciadoraClientes gerCliente = new GerenciadoraClientes(clientes);
		
		// Executando  
		
		
		boolean clienteRemovido = gerCliente.removeCliente(1);
		
		//verificação
		
		assertThat(clienteRemovido,is (true));
		assertThat(gerCliente.getClientesDoBanco().size(), is (1));
		assertNull(gerCliente.pesquisaCliente(1));
		assertTrue(clienteRemovido);
		
		
		
		
	}

}
