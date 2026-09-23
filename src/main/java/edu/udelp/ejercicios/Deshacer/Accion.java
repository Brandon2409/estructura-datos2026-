package edu.udelp.ejercicios.Deshacer;

public class Accion {
    private String tipoAccion;
    private String contenido;

    public Accion(String tipoAccion, String contenido) {
        this.tipoAccion = tipoAccion;
        this.contenido = contenido;
    }

    public String getTipoAccion() { return tipoAccion; }
    public String getContenido() { return contenido; }

    @Override
    public String toString() {
        return " [" + tipoAccion + "]: " + contenido + "";
    }
}
