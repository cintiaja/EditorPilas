package JennieID.controlador;

import JennieID.vista.VistaConsola;
import modelo.EditorTexto;

/** Controlador: recibe la opción del menú y le pide al modelo que trabaje; luego usa la vista. */
public class ControladorEditor {

    private EditorTexto editor;
    private JennieID.vista.VistaConsola vista;

    public ControladorEditor(EditorTexto editor, VistaConsola vista) {
        this.editor = editor;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != 7);
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                String accion = vista.leerAccion();
                if (accion.isEmpty()) { // validación de entrada
                    vista.mostrarMensaje("La acción no puede estar vacía.");
                } else {
                    editor.registrarAccion(accion);
                    vista.mostrarMensaje("Acción registrada: " + accion);
                }
                break;
            case 2:
                String deshecha = editor.deshacer();
                if (deshecha == null) {
                    vista.mostrarMensaje("No hay acciones para deshacer.");
                } else {
                    vista.mostrarMensaje("Acción deshecha: " + deshecha);
                }
                break;
            case 3:
                String rehecha = editor.rehacer();
                if (rehecha == null) {
                    vista.mostrarMensaje("No hay acciones para rehacer.");
                } else {
                    vista.mostrarMensaje("Acción rehecha: " + rehecha);
                }
                break;
            case 4:
                mostrarCimas();
                break;
            case 5:
                vista.mostrarHistorial("Acciones realizadas", editor.historialRealizadas());
                vista.mostrarHistorial("Acciones por rehacer", editor.historialPorRehacer());
                break;
            case 6:
                vista.mostrarMensaje("Acciones realizadas: " + editor.cantidadRealizadas());
                vista.mostrarMensaje("Acciones por rehacer: " + editor.cantidadPorRehacer());
                break;
            case 7:
                vista.mostrarMensaje("¡Hasta luego!");
                break;
            default:
                vista.mostrarMensaje("Opción no válida. Elige un número del 1 al 7.");
        }
    }

    private void mostrarCimas() {
        String cimaR = editor.cimaRealizadas();
        String cimaP = editor.cimaPorRehacer();
        vista.mostrarMensaje("Cima de realizadas: " + (cimaR == null ? "(pila vacía)" : cimaR));
        vista.mostrarMensaje("Cima de por rehacer: " + (cimaP == null ? "(pila vacía)" : cimaP));
    }
}