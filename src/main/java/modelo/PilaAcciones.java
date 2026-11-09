package modelo;

/**
 * Pila (LIFO) hecha a mano con nodos enlazados.
 * No usa Stack, ArrayDeque ni LinkedList.
 * Solo guardamos el nodo de arriba ("tope"); cada nodo apunta al de abajo.
 */
public class PilaAcciones {

    private Nodo tope;   // nodo de arriba (null si la pila está vacía)
    private int tamanio; // cuántas acciones hay guardadas

    public PilaAcciones() {
        this.tope = null;
        this.tamanio = 0;
    }

    /** Pone una acción arriba de la pila. */
    public void push(String accion) {
        Nodo nuevo = new Nodo(accion);
        nuevo.siguiente = tope; // el nuevo apunta al que era el tope
        tope = nuevo;           // ahora el nuevo es el tope
        tamanio++;
    }

    /** Quita y devuelve la acción de arriba. Devuelve null si está vacía. */
    public String pop() {
        if (isEmpty()) {
            return null;
        }
        String accion = tope.accion;
        tope = tope.siguiente; // el tope baja un lugar
        tamanio--;
        return accion;
    }

    /** Devuelve la acción de arriba SIN quitarla. Devuelve null si está vacía. */
    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return tope.accion;
    }

    public boolean isEmpty() {
        return tope == null;
    }

    public int size() {
        return tamanio;
    }

    /** Deja la pila vacía (se usa para limpiar "por rehacer"). */
    public void vaciar() {
        tope = null;
        tamanio = 0;
    }

    /** Devuelve las acciones en un arreglo, de la cima hacia el fondo (solo para mostrarlas). */
    public String[] aArreglo() {
        String[] resultado = new String[tamanio];
        Nodo actual = tope;
        int i = 0;
        while (actual != null) {
            resultado[i++] = actual.accion;
            actual = actual.siguiente;
        }
        return resultado;
    }
}