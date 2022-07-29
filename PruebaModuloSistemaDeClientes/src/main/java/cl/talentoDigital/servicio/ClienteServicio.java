package cl.talentoDigital.servicio;

import java.util.ArrayList;
import java.util.List;

import cl.talentoDigital.modelo.CategoriaEnum;
import cl.talentoDigital.modelo.Cliente;

public class ClienteServicio {

	private List<Cliente> listaClientes = new ArrayList<Cliente>();

	public ClienteServicio() {
	}

	public ClienteServicio(List<Cliente> listaClientes) {
		super();
		this.listaClientes = listaClientes;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public void listarClientes() {
		if (listaClientes.size() == 0) {
			System.out.println("\n--------------------------------");
			System.out.println("La lista de clientes esta vacia");
			System.out.println("--------------------------------\n");
		} else {
			for (Cliente cliente : listaClientes) {
				System.out.println("-------------Datos del Cliente-------------\n" + "\nRUN del cliente: "
						+ cliente.getRunCliente() + "\nNombre del cliente: " + cliente.getNombreCliente()
						+ "\nApellido del cliente: " + cliente.getApellidoCliente() + "\nAños como Cliente: "
						+ cliente.getAniosCliente() + "\nCategoría del Cliente: " + cliente.getNombreCategoria()
						+ "\n\n-------------------------------------------\n");
			}
		}
	}

	public boolean agregarCliente(String rut, String nombre, String apellido, int aniosCliente) {

		boolean fueAgregado = false;
		
		if (!rut.equals("")) {
			Cliente cliente = new Cliente(rut, nombre, apellido, aniosCliente);
			cliente.setNombreCategoria(CategoriaEnum.ACTIVO);
			listaClientes.add(cliente);
			fueAgregado = true;
		} else {
			System.out.println("[ALERTA] Cliente no creado. Debe ingresar el RUT");
		}
		
		return fueAgregado;

	}
	
	public void agregarClienteDesdeArchivo(String rut, String nombre, String apellido, int aniosCliente, String categoria) {

		if (!rut.equals("")) {
			Cliente cliente = new Cliente(rut, nombre, apellido, aniosCliente);
			cliente.setNombreCategoria(CategoriaEnum.valueOf(categoria));
			listaClientes.add(cliente);
		} else {
			System.out.println("[ALERTA] Cliente no creado. Debe ingresar el RUT");

		}

	}
	

	public void mostrarCliente(String run) {
		for (Cliente cliente : listaClientes) {
			if (cliente.getRunCliente().equals(run)) {
				System.out.println("[1] El RUN del Cliente es: " + cliente.getRunCliente()
						+ "\n[2] El Nombre del Cliente es: " + cliente.getNombreCliente()
						+ "\n[3] El Apellido del Cliente es: " + cliente.getApellidoCliente()
						+ "\n[4] Los años como Cliente son: " + cliente.getAniosCliente());
			}
		}
	}


}
