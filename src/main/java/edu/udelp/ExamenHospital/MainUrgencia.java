package edu.udelp.ExamenHospital;

public class MainUrgencia {
    public static void main(String[] args) {
        PrioridadUrgencia dequeue = new PrioridadUrgencia();

        dequeue.encolarPrioridad(new Paciente("Pedro", 3));
        dequeue.encolarPrioridad(new Paciente("Ana", 2));
        dequeue.encolarPrioridad(new Paciente("Carlos", 1));
        dequeue.encolarPrioridad(new Paciente("Sofia", 1));

        dequeue.mostrarCola();

        dequeue.dequeue();

        dequeue.mostrarCola();
    }
}
