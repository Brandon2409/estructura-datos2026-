package edu.udelp.ejercicios.Deshacer;

public class NodoAccion {

    private Accion dato;
    private NodoAccion siguiente;

    public NodoAccion(Accion dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Accion getDato() { return dato; }
    public NodoAccion getSiguiente() { return siguiente; }
    public void setSiguiente(NodoAccion siguiente) { this.siguiente = siguiente; }
}
