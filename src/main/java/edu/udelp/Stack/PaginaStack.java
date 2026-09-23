package edu.udelp.Stack;

import edu.udelp.exception.UdelpException;
import edu.udelp.model.Pagina;
import edu.udelp.nodo.nodoPagina;

public class PaginaStack {

        // ATRIBUTOS
        private nodoPagina top;
        private int size;
        // CONSTRUCTORES Y FUNCIONES
        public PaginaStack(){
            top = null;
            size = 0;
        }
        public int size(){
            return size;
        }
        public boolean isEmpty(){
            return top == null;
        }
        public Pagina peek(){
            if (isEmpty()) {
                throw new UdelpException("[!] PILA VACÍA [!]");
            }
            return top.getDato();
        }
        public void push(Pagina dato){
            nodoPagina nuevo = new nodoPagina(dato);
            if(top != null){
                nuevo.setEnlace(top);
            }
            top = nuevo;
            size++;
        }

        public Pagina pop(){
            if(top == null){
                throw new UdelpException("[!] PILA VACÍA [!]");
            }

            Pagina dato = top.getDato();
            top = top.getEnlace();
            size--;
            return dato;
        }

        @Override
        public String toString(){
            StringBuilder s = new StringBuilder();
            nodoPagina aux = top;

            while(aux != null){
                s.append(aux.getDato()).append(" ");
                aux = aux.getEnlace();
            }

            return s.toString();
        }
    }


