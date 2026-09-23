package edu.udelp.nodo;

public class nodo {

    private int dato;
    private nodo enlace;

    public nodo(int dato) {
        this.dato = dato;
        this.enlace = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public nodo getEnlace() {
        return enlace;
    }

    public void setEnlace(nodo enlace) {
        this.enlace = enlace;
    }

    @Override
    public String toString() {
        return String.valueOf(dato);
    }

}
