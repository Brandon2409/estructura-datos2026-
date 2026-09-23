package edu.udelp.ExamenHospital;

public class Paciente {
    private String nombre;
    private int nivelUrgencia;

    public Paciente(String nombre, int nivelUrgencia) {
        this.nombre = nombre;
        this.nivelUrgencia = nivelUrgencia;
    }

    public String getNombre() { return nombre; }
    public int getNivelUrgencia() { return nivelUrgencia; }

    @Override
    public String toString() {
        String urgencia = (nivelUrgencia == 1) ? "alto" : (nivelUrgencia == 2) ? "medio" : "bajo";
        return "[" + urgencia + "] " + nombre + " (Prioridad " + nivelUrgencia + ")";
    }
}
