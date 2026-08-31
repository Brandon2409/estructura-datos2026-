package edu.udelp.Tarea;

public class Conversor {
    private static int prioridad(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    private static boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static String infijaAPostfija(String infija) {
        Pila pila = new Pila();
        String postfija = "";
        int parentesis = 0;

        for (int i = 0; i < infija.length(); i++) {
            char c = infija.charAt(i);

            if (c == ' ') {
                continue;
            }

            if (Character.isDigit(c)) {
                String numero = "";
                while (i < infija.length() && (Character.isDigit(infija.charAt(i)) || infija.charAt(i) == '.')) {
                    numero += infija.charAt(i);
                    i++;
                }
                i--;
                postfija += numero + " ";
            }
            else if (c == '(') {
                pila.empujar("(");
                parentesis++;
            }
            else if (c == ')') {
                parentesis--;
                if (parentesis < 0) {
                    System.out.println("Error: Hay un paréntesis de cierre sin apertura.");
                    return null;
                }
                while (!pila.estaVacia() && !pila.peek().equals("(")) {
                    postfija += pila.pop() + " ";
                }
                pila.pop();
            }
            else if (esOperador(c)) {
                while (!pila.estaVacia() && !pila.peek().equals("(") &&
                        prioridad(c) <= prioridad(pila.peek().charAt(0))) {
                    postfija += pila.pop() + " ";
                }
                pila.empujar(String.valueOf(c));
            }
            else {
                System.out.println("Error: Carácter no permitido '" + c + "'");
                return null;
            }
        }

        if (parentesis != 0) {
            System.out.println("Error: Los paréntesis no están balanceados.");
            return null;
        }

        while (!pila.estaVacia()) {
            postfija += pila.pop() + " ";
        }

        return postfija.trim();
    }

    public static Double evaluarPostfija(String postfija) {
        if (postfija == null) return null;

        Pila pila = new Pila();
        String[] tokens = postfija.split(" ");

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if (token.isEmpty()) continue;

            if (token.length() == 1 && esOperador(token.charAt(0))) {
                String num2Str = pila.pop();
                String num1Str = pila.pop();

                if (num1Str == null || num2Str == null) {
                    System.out.println("Error: Operadores sin suficientes operandos.");
                    return null;
                }

                double num2 = Double.parseDouble(num2Str);
                double num1 = Double.parseDouble(num1Str);
                double res = 0;

                char op = token.charAt(0);
                if (op == '+') res = num1 + num2;
                else if (op == '-') res = num1 - num2;
                else if (op == '*') res = num1 * num2;
                else if (op == '/') {
                    if (num2 == 0) {
                        System.out.println("Error: División entre cero.");
                        return null;
                    }
                    res = num1 / num2;
                }

                pila.empujar(String.valueOf(res));
            }
            else {
                pila.empujar(token);
            }
        }

        String resultadoFinalStr = pila.pop();

        if (!pila.estaVacia()) {
            System.out.println("Error: Expresión incompleta o mal formada.");
            return null;
        }

        return Double.parseDouble(resultadoFinalStr);
    }
}
