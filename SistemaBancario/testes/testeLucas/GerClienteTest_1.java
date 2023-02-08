package testeLucas;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import negocio.Cliente;
import negocio.GerenciadoraClientes;

public class GerClienteTest_1 {
	
	@Test
	public void TestePesquisaCliente() {
		
		//Criando alguns clientes
		Cliente cliente01 = new Cliente(1, "juka bala", 32, "juka@gmail.com", 04, true);
		Cliente cliente02 = new Cliente(2, "Treyce Mo", 32, "treyce@gmail.com", 05, true);
		
		//criando a lista de clientes
		List<Cliente> clientes = new ArrayList();
		
		clientes.add(cliente01);
		clientes.add(cliente02);
		
		GerenciadoraClientes gerenciaClientes = new GerenciadoraClientes(clientes);
		
		Cliente cliente = gerenciaClientes.pesquisaCliente(1);
		
		assertThat(cliente.getId(),is (1));
		assertThat(cliente.getEmail(), is ("juka@gmail.com"));
		assertThat (cliente.getIdade(),is (32));
		
		
		
	}
	

}
