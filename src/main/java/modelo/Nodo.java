package modelo;

/**
 * Nodo de la pila: guarda una acción (texto) y una "flecha"
 * que apunta al nodo que está debajo de él.
 */
class Nodo {
    String accion;
    Nodo siguiente;

    Nodo(String accion) {
        this.accion = accion;
        this.siguiente = null;
    }
}