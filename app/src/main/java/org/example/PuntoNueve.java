package org.example;

import java.util.Random;

public class PuntoNueve {
    /*
     * 9. Llene una matriz de 5x5 con números aleatorios entre 1 y 9. En un vector
     * adicional, calcule la cantidad de números repetidos por cada fila y en otro
     * vector la cantidad de números repetidos de cada columna.
     */
        public static void main(String[] args) {
        int filas = 5;
        int columnas = 5;
        int[][] matriz = new int[filas][columnas];  // Matriz de 5x5
        int[] repetidosFila = new int[filas];       // Vector para contar repetidos por fila
        int[] repetidosColumna = new int[columnas]; // Vector para contar repetidos por columna

        Random random = new Random();

        // Llenar la matriz con números aleatorios entre 1 y 9
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextInt(9) + 1; // Genera números entre 1 y 9
            }
        }

        // Imprimir la matriz generada
        System.out.println("Matriz llena:");
        imprimirMatriz(matriz, filas, columnas);

        // Calcular repetidos por fila
        for (int i = 0; i < filas; i++) {
            repetidosFila[i] = contarRepetidos(matriz[i]);
        }

        // Calcular repetidos por columna
        for (int j = 0; j < columnas; j++) {
            int[] columna = new int[filas];
            for (int i = 0; i < filas; i++) {
                columna[i] = matriz[i][j]; // Extraer columna
            }
            repetidosColumna[j] = contarRepetidos(columna);
        }

        // Imprimir el conteo de repetidos por fila
        System.out.println("\nRepetidos por fila:");
        for (int i = 0; i < filas; i++) {
            System.out.println("Fila " + (i + 1) + ": " + repetidosFila[i]);
        }

        // Imprimir el conteo de repetidos por columna
        System.out.println("\nRepetidos por columna:");
        for (int j = 0; j < columnas; j++) {
            System.out.println("Columna " + (j + 1) + ": " + repetidosColumna[j]);
        }
    }

    // Método para contar los números repetidos en un array
    public static int contarRepetidos(int[] array) {
        int[] conteo = new int[10]; // Para contar ocurrencias de números del 1 al 9
        for (int i = 0; i < array.length; i++) {
            conteo[array[i]]++;
        }

        int repetidos = 0;
        for (int i = 1; i < conteo.length; i++) { // Contar cuántos números se repiten
            if (conteo[i] > 1) {
                repetidos += conteo[i] - 1; // Si un número se repite, sumar las repeticiones
            }
        }

        return repetidos;
    }

    // Método para imprimir la matriz
    public static void imprimirMatriz(int[][] matriz, int filas, int columnas) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}

