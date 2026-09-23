package edu.udelp.Stack;

public class ArrayStack {
    private int [] dato ;
    private int pos= -1;

    public ArrayStack(int size){dato = new int [size];}
    public void push (int dato){this.dato[++pos] =dato;}

    public int pop(){return dato[pos--];}
    public int peek (){return dato[pos];}

    public boolean isEmpty() { return pos ==-1;}
    public boolean isFull(){return pos == dato.length -1;}

    public int size () {return pos;}

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(int i = 0; i <= pos; i++){
            builder.append(dato[i]).append(",");
        }
        builder.append("]");

        return builder.toString();
    }
}
