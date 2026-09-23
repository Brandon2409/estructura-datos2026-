package edu.udelp.ejercicios.Deshacer;

public class Deshacer {
    private NodoAccion tope;
    private int tamano;

    public Deshacer() {
        this.tope = null;
        this.tamano = 0;
    }

    public void registrarAccion(Accion accion) {
        NodoAccion nuevo = new NodoAccion(accion);
        nuevo.setSiguiente(tope);
        tope = nuevo;
        tamano++;
        System.out.println("Acción registrada: " + accion);
    }
    public Accion deshacer() {
        if (estaVacia()) {
            System.out.println("historial está vacío.");
            return null;
        }
        Accion deshecha = tope.getDato();
        tope = tope.getSiguiente();
        tamano--;
        System.out.println("↩️ Deshaciendo: " + deshecha);
        return deshecha;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public void mostrarPila() {
        if (estaVacia()) {
            System.out.println("Pila de deshacer vacía.");
            return;
        }
        System.out.println("Maximo");
        NodoAccion aux = tope;
        while (aux != null) {
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();
        }
    }
}
