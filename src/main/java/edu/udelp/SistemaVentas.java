package edu.udelp;

import java.util.Scanner;

public class SistemaVentas {

    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        int[] ventas = new int[10];
        System.out.println("Sistema de ventas");
        System.out.println();
        capturarVentas(ventas);

        System.out.println();
        System.out.println("Ventas:");
        mostrarArreglo(ventas);

        System.out.println();
        System.out.println("Acomodando");
        ordenarBurbuja(ventas);

        System.out.println();
        System.out.println("Ventas acomodadas:");
        mostrarArreglo(ventas);

        System.out.println();
        System.out.println("Venta mas baja: " + ventas[0]);
        System.out.println("Venta más alta: " + ventas[ventas.length - 1]);
        System.out.println("Promedio de ventas: " + calcularPromedio(ventas));
    }

    public static void capturarVentas(int[] ventas) {

        for (int i = 0; i < ventas.length; i++) {
            System.out.print("Ingresa las ventas del vendedor " + (i + 1) + ": ");
            ventas[i] = entrada.nextInt();
        }
    }

    public static void mostrarArreglo(int[] ventas) {
        for (int i = 0; i < ventas.length; i++) {
            System.out.print(ventas[i] + " ");
        }

        System.out.println();
    }

    public static void ordenarBurbuja(int[] ventas) {
        for (int i = 0; i < ventas.length - 1; i++) {
            for (int j = 0; j < ventas.length - 1 - i; j++) {
                if (ventas[j] > ventas[j + 1]) {
                    int temporal = ventas[j];
                    ventas[j] = ventas[j + 1];
                    ventas[j + 1] = temporal;
                }
            }
        }
    }

    public static double calcularPromedio(int[] ventas) {
        int suma = 0;
        for (int i = 0; i < ventas.length; i++) {
            suma = suma + ventas[i];
        }
        return (double) suma / ventas.length;
    }
}