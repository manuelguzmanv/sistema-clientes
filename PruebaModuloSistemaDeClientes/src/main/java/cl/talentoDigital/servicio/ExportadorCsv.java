package cl.talentoDigital.servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import cl.talentoDigital.modelo.Cliente;

public class ExportadorCsv extends Exportador {

	Scanner sc = new Scanner(System.in);
	List<Cliente> listaClientes;

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {

		File archivo = new File(fileName + "/clientes.csv");

		try {

			if (archivo.createNewFile()) {
				FileWriter fw = new FileWriter(archivo);
				BufferedWriter bw = new BufferedWriter(fw);

				for (Cliente cliente : listaClientes) {
					bw.write("-------------Datos del Cliente-------------");
					bw.newLine();
					bw.write("RUN del Cliente: " + cliente.getRunCliente());
					bw.newLine();
					bw.write("Nombre del Cliente: " + cliente.getNombreCliente());
					bw.newLine();
					bw.write("Apellido del Cliente: " + cliente.getApellidoCliente());
					bw.newLine();
					bw.write("Años como Cliente: " + cliente.getAniosCliente());
					bw.newLine();
					bw.write("Categoría del Cliente: " + cliente.getNombreCategoria());
					bw.newLine();
					bw.write("-------------------------------------------\n");

				}
				bw.close();
				System.out.println("Datos de clientes exportados correctamente en formato csv.");

			} else {
				System.out.println("Error al exportar. Antes debe borrar anchivo anterior");
			}
		} catch (IOException e) {
			System.out.println("Error al crear el archivo");
			e.printStackTrace();
		}

	}

}
