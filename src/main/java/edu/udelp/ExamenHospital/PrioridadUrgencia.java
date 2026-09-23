package edu.udelp.ExamenHospital;

public class PrioridadUrgencia {
    private NodoPaciente frente;
    private int tamano;

    public PrioridadUrgencia() {
        this.frente = null;
        this.tamano = 0;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void encolarPrioridad(Paciente paciente) {
        NodoPaciente nuevo = new NodoPaciente(paciente);

        if (estaVacia() || paciente.getNivelUrgencia() < frente.getDato().getNivelUrgencia()) {
            nuevo.setSiguiente(frente);
            frente = nuevo;
        }
        else {
            NodoPaciente actual = frente;
            while (actual.getSiguiente() != null &&
                    actual.getSiguiente().getDato().getNivelUrgencia() <= paciente.getNivelUrgencia()) {
                actual = actual.getSiguiente();
            }
            nuevo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevo);
        }

        tamano++;
        System.out.println("Anotado, Porfavor espere : " + paciente);
    }

    public Paciente dequeue() {
        if (estaVacia()) {
            System.out.println("Sala de espera sola");
            return null;
        }
        Paciente atendido = frente.getDato();
        frente = frente.getSiguiente();
        tamano--;
        System.out.println("Dontor atendiendo " + atendido);
        return atendido;
    }

    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println("Sala de espera vacía.");
            return;
        }
        System.out.println(" Favor de esperar, la sala va por prioridad ");
        NodoPaciente aux = frente;
        int turno = 1;
        while (aux != null) {
            System.out.println(" " + turno + ". " + aux.getDato());
            aux = aux.getSiguiente();
            turno++;
        }
    }
}
