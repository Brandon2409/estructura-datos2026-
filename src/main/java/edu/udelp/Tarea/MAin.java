package edu.udelp.Tarea;

import java.util.Scanner;

public class MAin {
    public static void MAin(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== CALCULADORA RPN =====");
        System.out.println("\nIngresa una expresión:");
        String expresionInfija = scanner.nextLine();

        String expresionPostfija = Conversor.infijaAPostfija(expresionInfija);

        if (expresionPostfija != null) {
            Double resultado = Conversor.evaluarPostfija(expresionPostfija);

            if (resultado != null) {
                System.out.println("\nExpresión infija:");
                System.out.println(expresionInfija);

                System.out.println("\nExpresión postfija:");
                System.out.println(expresionPostfija);

                System.out.println("\nResultado:");
                if (resultado % 1 == 0) {
                    System.out.println(resultado.longValue());
                } else {
                    System.out.println(resultado);
                }
            }
        }

        scanner.close();
    }
}
