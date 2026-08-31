package edu.udelp.Tarea;

public class Pila {
    private Nodo cima;

    public Pila() {
        this.cima = null;
    }

    public void empujar(String dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    public String pop() {
        if (estaVacia()) {
            return null;
        }
        String dato = cima.dato;
        cima = cima.siguiente;
        return dato;
    }

    public String peek() {
        if (estaVacia()) {
            return null;
        }
        return cima.dato;
    }

    public boolean estaVacia() {
        return cima == null;
    }
}