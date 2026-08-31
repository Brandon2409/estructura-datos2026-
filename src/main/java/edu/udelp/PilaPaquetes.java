package edu.udelp;

public class PilaPaquetes {

    Nodo tope;

    public PilaPaquetes() {
        tope = null;
    }


    public void push(Paquete paquete) {

        Nodo nuevo = new Nodo(paquete);

        nuevo.siguiente = tope;

        tope = nuevo;
    }

    public Paquete pop() {

        if (isEmpty()) {
            return null;
        }

        Paquete paqueteRetirado = tope.paquete;

        tope = tope.siguiente;

        return paqueteRetirado;
    }


    public Paquete peek() {

        if (isEmpty()) {
            return null;
        }

        return tope.paquete;
    }


    public boolean isEmpty() {

        return tope == null;
    }


    public void mostrar() {

        if (isEmpty()) {
            System.out.println("No hay paquetes almacenados.");
            return;
        }

        Nodo actual = tope;

        System.out.println("\n===== PAQUETES EN EL ALMACÉN =====");

        while (actual != null) {

            actual.paquete.mostrar();

            System.out.println("-------------------------");

            actual = actual.siguiente;
        }
    }
    public Paquete buscar(int id) {

        Nodo actual = tope;

        while (actual != null) {

            if (actual.paquete.id == id) {
                return actual.paquete;
            }

            actual = actual.siguiente;
        }

        return null;
    }
}