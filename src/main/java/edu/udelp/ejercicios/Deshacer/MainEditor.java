package edu.udelp.ejercicios.Deshacer;

public class MainEditor {
    public static void main(String[] args) {
        Deshacer historial = new Deshacer();

        historial.registrarAccion(new Accion("Escribir", "Hola Mundo"));
        historial.registrarAccion(new Accion("Escribir", " este es un examen"));
        historial.registrarAccion(new Accion("Borrar", "examen"));

        historial.mostrarPila();

        historial.deshacer();
        historial.deshacer();

        historial.mostrarPila();
    }
}
