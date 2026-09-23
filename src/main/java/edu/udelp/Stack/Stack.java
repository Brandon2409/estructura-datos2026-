package edu.udelp.Stack;

import edu.udelp.exception.UdelpException;
import edu.udelp.nodo.nodo;

public class Stack {

    private nodo top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if (isEmpty()) {
            throw new UdelpException("Pila vacia");
        }
        return top.getDato();
    }

    public void push(int dato) {
        nodo nuevo = new nodo(dato);
        nuevo.setEnlace(top);
        top = nuevo;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new UdelpException("Pila vacia");
        }
        int dato = top.getDato();
        top = top.getEnlace();
        size--;
        return dato;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        nodo aux = top;
        while (aux != null) {
            s.append(aux.getDato()).append(" -> ");
            aux = aux.getEnlace();
        }
        s.append("null");
        return s.toString();
    }
}

