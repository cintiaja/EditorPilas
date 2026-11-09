package JennieID.vista;

import java.util.Scanner;

/** Vista: solo muestra cosas y lee lo que escribe el usuario. No tiene lógica de pilas. */
public class VistaConsola {

    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n===== EDITOR DE TEXTO: DESHACER / REHACER =====");
        System.out.println("1. Registrar una acción");
        System.out.println("2. Deshacer");
        System.out.println("3. Rehacer");
        System.out.println("4. Ver la cima de cada pila");
        System.out.println("5. Mostrar historial de cada pila");
        System.out.println("6. Mostrar cuántas acciones hay en cada pila");
        System.out.println("7. Salir");
    }

    /** Lee una opción y valida que sea un número entero; si no, devuelve -1. */
    public int leerOpcion() {
        System.out.print("Elige una opción: ");
        String texto = scanner.nextLine().trim();
        try {
            return Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String leerAccion() {
        System.out.print("Escribe la acción (ej. Escribir 'hola'): ");
        return scanner.nextLine().trim();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /** Muestra un historial de la cima hacia el fondo. */
    public void mostrarHistorial(String titulo, String[] acciones) {
        System.out.println("--- " + titulo + " (cima -> fondo) ---");
        if (acciones.length == 0) {
            System.out.println("(vacía)");
            return;
        }
        for (int i = 0; i < acciones.length; i++) {
            System.out.println((i + 1) + ". " + acciones[i]);
        }
    }
}