package modelo;

/**
 * Lógica del deshacer / rehacer usando dos pilas:
 *  - realizadas: acciones que el usuario ya hizo.
 *  - porRehacer: acciones que el usuario deshizo.
 */
public class EditorTexto {

    private PilaAcciones realizadas;
    private PilaAcciones porRehacer;

    public EditorTexto() {
        realizadas = new PilaAcciones();
        porRehacer = new PilaAcciones();
    }

    /** Registra una acción nueva. Al hacerlo, ya no se puede rehacer lo anterior. */
    public void registrarAccion(String accion) {
        realizadas.push(accion);
        porRehacer.vaciar(); // regla del caso: limpiar "por rehacer"
    }

    /** Mueve la última acción realizada a "por rehacer". Devuelve null si no hay nada. */
    public String deshacer() {
        if (realizadas.isEmpty()) {
            return null;
        }
        String accion = realizadas.pop();
        porRehacer.push(accion);
        return accion;
    }

    /** Regresa la última acción deshecha a "realizadas". Devuelve null si no hay nada. */
    public String rehacer() {
        if (porRehacer.isEmpty()) {
            return null;
        }
        String accion = porRehacer.pop();
        realizadas.push(accion);
        return accion;
    }

    public String cimaRealizadas()  { return realizadas.peek(); }
    public String cimaPorRehacer()  { return porRehacer.peek(); }

    public String[] historialRealizadas()  { return realizadas.aArreglo(); }
    public String[] historialPorRehacer()  { return porRehacer.aArreglo(); }

    public int cantidadRealizadas()  { return realizadas.size(); }
    public int cantidadPorRehacer()  { return porRehacer.size(); }
}