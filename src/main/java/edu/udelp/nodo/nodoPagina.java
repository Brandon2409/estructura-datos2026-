package edu.udelp.nodo;

import edu.udelp.model.Pagina;

public class nodoPagina {

    private Pagina dato;
    private nodoPagina enlace;

    public nodoPagina(Pagina pagina){this.dato=pagina;};
        public Pagina getDato(){
            return dato;
        }

    public Pagina getPagina(){return dato;}

    public void toPagina(Pagina dato){this.dato=dato;}

    public nodoPagina getEnlace(){return enlace;}

    public void setEnlace(nodoPagina enlace){this.enlace=enlace;}

    @Override
    public String toString(){return this.dato.toString();}
}
