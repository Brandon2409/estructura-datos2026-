package edu.udelp.queue;

import edu.udelp.exception.UdelpException;
import edu.udelp.nodo.nodo;

public class Queue {
    private nodo front;

    private nodo rear;

    private int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    public void enqueue(int valor) {

        nodo nuevo = new nodo(valor);
        if (isEmpty()) {
            front = nuevo;
            rear = nuevo;
        } else {
            rear.setEnlace(nuevo);
            rear = nuevo;
        }
        size++;

    }

    public int dequeue(){
        if(isEmpty()){
            throw new UdelpException("cola vacia");
        }
        int valor = front.getDato();
        front = front.getEnlace();
        size--;
        return valor;

    }
    public int peek(){
        if (isEmpty()){
            throw new UdelpException("Cola vacia");

        }
        return front.getDato();

    }
    @Override
    public String toString(){

        StringBuilder s = new StringBuilder();
        nodo aux = front;
        while (aux != null){
            s.append(aux.getDato()).append("<");
            aux = aux.getEnlace();
        }
        return s.toString();
    }
}
