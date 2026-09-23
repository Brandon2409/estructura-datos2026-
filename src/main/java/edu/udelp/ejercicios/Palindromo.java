package edu.udelp.ejercicios;

import edu.udelp.Stack.ArrayStack;

import java.util.Locale;

public class Palindromo {

    public boolean evaluar(String palabra) {
        palabra = palabra.toLowerCase().replace(" ", "");

        ArrayStack pila = new ArrayStack(palabra.length());

        for (int i =0; i < palabra.length(); i++){
            pila.push(palabra.charAt(i));
        }
        for (int i =0; i < palabra.length(); i++){
            if (palabra.charAt(i) != pila.pop()) {
                return false;
            }
        }
        return false;
    }
}
