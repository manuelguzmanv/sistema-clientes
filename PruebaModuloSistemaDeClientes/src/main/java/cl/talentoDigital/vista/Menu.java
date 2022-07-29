package cl.talentoDigital.vista;

import java.util.Scanner;

import cl.talentoDigital.modelo.CategoriaEnum;
import cl.talentoDigital.modelo.Cliente;
import cl.talentoDigital.servicio.ClienteServicio;
import cl.talentoDigital.servicio.ArchivoServicio;
import cl.talentoDigital.servicio.ExportadorCsv;
import cl.talentoDigital.servicio.ExportadorTxt;
import cl.talentoDigital.utilidades.Util;

public class Menu {

	Scanner sc = new Scanner(System.in);
	ClienteServicio clienteServicio = new ClienteServicio();
	ArchivoServicio as = new ArchivoServicio();
	ExportadorCsv eCsv = new ExportadorCsv();
	ExportadorTxt eTxt = new ExportadorTxt();

	public void iniciarMenu() {

		String opcion;

		do {

			desplegarMenu();
			opcion = sc.nextLine();

			switch (opcion) {
			case "1":
				clienteServicio.listarClientes();
				Util.limpiarPantalla();
				break;
			case "2":
				capturaDatosNuevoCliente();
				Util.limpiarPantalla();
				break;
			case "3":
				editarCliente();
				Util.limpiarPantalla();
				break;
			case "4":
				menuCargaDatos();
				Util.limpiarPantalla();
				break;
			case "5":
				exportarDatos();
				Util.limpiarPantalla();
				break;
			case "6":
				cerrarMenu();
				break;
			default:
				System.out.println("[ALERTA] Ingrese una opcion valida");
				break;
			}
		} while (!opcion.equals("6"));

	}

	private void menuCargaDatos() {
		Scanner scRutaCarga = new Scanner(System.in);
		System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv: (por defecto 'src')");
		as.cargarDatos(scRutaCarga.nextLine(), clienteServicio);
		
	}

	private void exportarDatos() {
		System.out.println("---------Exportar Datos-----------\n"
				+ "Seleccione el formato a exportar:\n"
				+ "1.-Formato csv\n"
				+ "2.-Formato txt\n");

			switch (sc.nextLine()) {
			case "1":
				System.out.println("Exportar Clientes");
				System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.csv:");
				eCsv.exportar(sc.nextLine(),clienteServicio.getListaClientes());
				break;
			case "2":
				System.out.println("Exportar Clientes");
				System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.txt:");
				eTxt.exportar(sc.nextLine(),clienteServicio.getListaClientes());
				break;
		default:
			break;
				
		}
	}

	
	private void desplegarMenu() {
		System.out.println(
				"------MENU------" + "\n[1] Listar Clientes\n" + "[2] Agregar Cliente\n" + "[3] Editar Cliente\n"
						+ "[4] Cargar Datos\n" + "[5] Exportar Datos\n" + "[6] Salir\n" + "Ingrese una opcion:\n");
	}

	
	private void capturaDatosNuevoCliente() {

		String run = null, nombre = null, apellido = null, aniosTexto = null;

		Scanner sc1 = new Scanner(System.in);
		System.out.println("-------------Crear Cliente-------------\n");
		System.out.println("Ingresa RUN del Cliente:");
		run = sc1.nextLine();
		System.out.println("Ingresa Nombre del Cliente:");
		nombre = sc1.nextLine();
		System.out.println("Ingresa Apellido del Cliente:");
		apellido = sc1.nextLine();
		
		do {
			System.out.println("Ingresa años como Cliente:");
			aniosTexto = sc1.nextLine();	
		} while (!aniosTexto.matches("[0-9]*"));
		
		
		clienteServicio.agregarCliente(run, nombre, apellido, Integer.parseInt(aniosTexto));

	}

	
	public void editarCliente() {
		Scanner sc2 = new Scanner(System.in);
		System.out.println("-------------Editar Cliente-------------\n" + "Seleccione qué desea hacer:\n"
				+ "1.-Cambiar el estado del Cliente\n" + "2.-Editar los datos ingresados del Cliente\n"
				+ "Ingrese opcion:\n" + "----------------------------------------");

		switch (sc.nextLine()) {
		case "1":
			editarStatusCliente();
			break;
		case "2":
			editarDatosCliente();
			break;
		default:
			System.out.println("[ALERTA] Opcion no valida, intente nuevamente.");
			break;

		}

	}

	
	private void editarStatusCliente() {
		Scanner sc3 = new Scanner(System.in);
		System.out.println("Ingrese RUN del Cliente a editar:");
		String runCliente = sc.nextLine();

		for (Cliente clienteTemp : clienteServicio.getListaClientes()) {

			if (runCliente.equalsIgnoreCase(clienteTemp.getRunCliente())) {

				System.out.println("El estado actual es: " + clienteTemp.getNombreCategoria());

				if (clienteTemp.getNombreCategoria().equals(CategoriaEnum.ACTIVO)) {

					System.out.println("[1] Si desea cambiar el estado del Cliente a Inactivo");
					System.out.println("[2] Si desea mantener el estado del cliente Activo");

					if (sc.nextLine().equalsIgnoreCase("1")) {
						clienteTemp.setNombreCategoria(CategoriaEnum.INACTIVO);
						System.out.println("[INFO] Proceso realizado con exito.");
					} else {
						System.out.println("[INFO] Proceso realizado con exito.");
					}

				} else {

					System.out.println("[1] Si desea cambiar el estado del Cliente a Activo");
					System.out.println("[2] Si desea mantener el estado del cliente Inactivo");

					if (sc.nextLine().equalsIgnoreCase("1")) {
						clienteTemp.setNombreCategoria(CategoriaEnum.ACTIVO);
						System.out.println("[INFO] Proceso realizado con exito.");
					} else {
						System.out.println("[INFO] Proceso realizado con exito.");
					}

				}

			} else {

				System.out.println("[ALERTA] El cliente ingresado no existe. Intente nuevamente.");

			}
		}

	}

	
	private void editarDatosCliente() {
		Scanner sc4 = new Scanner(System.in);

		System.out.println("Ingrese RUN del Cliente a editar:");
		String runCliente = sc4.nextLine();
		Boolean clienteExiste = false;

		for (Cliente clienteTemp : clienteServicio.getListaClientes()) {
			if (runCliente.equalsIgnoreCase(clienteTemp.getRunCliente())) {
				clienteExiste = true;
				clienteServicio.mostrarCliente(runCliente);
				System.out.println("Ingrese opcion a editar de los datos del cliente:");

				switch (sc.nextLine()) {
				case "1":
					System.out.println("Ingrese nuevo RUN del Cliente:");
					clienteTemp.setRunCliente(sc4.nextLine());
					System.out.println("[INFO] Datos cambiados con éxito");
					break;
				case "2":
					System.out.println("Ingrese nuevo nombre del Cliente:");
					clienteTemp.setNombreCliente(sc4.nextLine());
					System.out.println("[INFO] Datos cambiados con éxito");
					break;
				case "3":
					System.out.println("Ingrese nuevo apellido del Cliente:");
					clienteTemp.setApellidoCliente(sc4.nextLine());
					System.out.println("[INFO] Datos cambiados con éxito");
					break;
				case "4":
					System.out.println("Ingrese nueva antiguedad del Cliente:");
					clienteTemp.setAniosCliente(sc4.nextInt());
					System.out.println("[INFO] Datos cambiados con éxito");
					break;
				default:
					System.out.println("[ALERTA] Opcion no valida, intente nuevamente.");
					break;
				}
			}
		}
		if (clienteExiste == false) {
			System.out.println("[ALERTA] El cliente ingresado no existe. Intente nuevamente.");
		}
	}

	
	private void cerrarMenu() {
		try {
			System.out.println("-----------------------------------");
			System.out.println("Abandonando el sistema de clientes...");
			Util.esperar();
			System.out.println("Acaba de salir del sistema");
		} catch (Exception e) {
			System.out.println("Error al salir: " + e);
		}
	}

}
