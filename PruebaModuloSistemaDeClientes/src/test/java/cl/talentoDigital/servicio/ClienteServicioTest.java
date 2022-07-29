package cl.talentoDigital.servicio;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cl.talentoDigital.modelo.CategoriaEnum;
import cl.talentoDigital.modelo.Cliente;
import cl.talentoDigital.servicio.ClienteServicio;

@DisplayName("Test clase ClienteServicio")
public class ClienteServicioTest {

	@Test
	public void agrearClienteTest() {
		Cliente clienteTest = new Cliente("15222333-4", "Pepe", "Lota", 2, CategoriaEnum.ACTIVO);
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		listaClientes.add(clienteTest);
		
		//assertTrue();
		
	}

}
