package cl.talentoDigital.utilidades;

import java.util.concurrent.TimeUnit;

public abstract class Util {
	
	public static void esperar() {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (Exception e) {
			System.out.println("Error al esperar: " + e);
		}

	}

	
	public static void limpiarPantalla() {
		System.out.println("\n\n\n\n\n");
	}

}
