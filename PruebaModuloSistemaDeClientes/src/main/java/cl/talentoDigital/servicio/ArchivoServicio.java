package cl.talentoDigital.servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import cl.talentoDigital.modelo.CategoriaEnum;
import cl.talentoDigital.modelo.Cliente;

public class ArchivoServicio extends Exportador {

	public void cargarDatos(String fileName, ClienteServicio cs) {
			
		File archivo = new File(fileName + "/DBClientes.csv");

		if (archivo.exists()) {

			try {
				FileReader fr = new FileReader(archivo);
				BufferedReader br = new BufferedReader(fr);

				String linea = br.readLine();

				while (linea != null) {

					String[] cliente = linea.split(",");
					
					Cliente nuevoCliente = new Cliente(cliente[0], cliente[1], cliente[2], Integer.parseInt(cliente[3]), CategoriaEnum.valueOf(cliente[4].toUpperCase()));
					cs.getListaClientes().add(nuevoCliente);
					
					linea = br.readLine();

				}

				br.close();
					
				System.out.println("Datos cargados correctamente en la lista\n");

			} catch (IOException e) {
				System.out.println("Error al cargar archivo");
				e.printStackTrace();
			}

		} else {
			System.out.println("archivo no fue encontrado. Intente con otra ruta");

		}

	}

}
