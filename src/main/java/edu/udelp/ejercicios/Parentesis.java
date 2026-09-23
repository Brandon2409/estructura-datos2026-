package edu.udelp.ejercicios;

import edu.udelp.Stack.ArrayStack;

public class Parentesis {
    public boolean evaluar (String ecuacion){
        boolean resultado = false;
        ArrayStack stack = new ArrayStack(ecuacion.length());

        for (int i =0; i < ecuacion.length(); i++){
            char c =ecuacion.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                resultado = false;
            } else if (c == ')') {
                stack.pop();
            }

        }
        return resultado;
    }
}
