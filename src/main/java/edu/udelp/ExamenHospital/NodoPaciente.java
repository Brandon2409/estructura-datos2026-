package edu.udelp.ExamenHospital;

public class NodoPaciente {
    private Paciente dato;
    private NodoPaciente siguiente;

    public NodoPaciente(Paciente dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Paciente getDato() { return dato; }
    public NodoPaciente getSiguiente() { return siguiente; }
    public void setSiguiente(NodoPaciente siguiente) { this.siguiente = siguiente; }
}
