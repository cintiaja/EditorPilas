package JennieID;

import JennieID.controlador.ControladorEditor;
import modelo.EditorTexto;
import JennieID.vista.VistaConsola;


/** Punto de entrada: crea el modelo, la vista y el controlador, y arranca. */
public class Main {
    public static <VistaConsola> void main(String[] args) {
        EditorTexto editor = new EditorTexto();
        JennieID.vista.VistaConsola vista = new JennieID.vista.VistaConsola();
        new ControladorEditor(editor, vista).iniciar();
    }
}
