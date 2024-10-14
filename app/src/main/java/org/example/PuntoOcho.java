package org.example;

import java.util.Random;

public class PuntoOcho {
    /*
     * 8. Escriba un algoritmo que llene de manera aleatoria una matriz de 100 filas
     * por 3 columnas con Xs y Os. Y mediante un vector cuente el número de Xs y Os
     * en cada fila. Imprima la matriz antes de llenarla, luego de llenarla y el
     * vector con el resultado.
     */
    public static void main(String[] args) {
        int filas = 100, columnas = 3;
        char[][] matriz = new char[filas][columnas];
        int[][] vectorContador = new int[filas][2]; 

        Random random = new Random();

        // Imprimir matriz antes de llenarla
        System.out.println("Matriz vacía:");
        imprimirMatriz(matriz);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextBoolean() ? 'X' : 'O'; // Llenar aleatoriamente con 'X' o 'O' | Si el random es verdadero entonces rellena con X, sino, rellena con O
                
                // Contar 'X' y 'O'
                if (matriz[i][j] == 'X') {
                    vectorContador[i][0]++;
                } else {
                    vectorContador[i][1]++;
                }
            }
        }

        // Imprimir la matriz después de llenarla
        System.out.println("\nMatriz llena:");
        imprimirMatriz(matriz);

        // Imprimir el vector con el conteo de 'X' y 'O' en cada fila
        System.out.println("\n'X' y 'O' por fila:");
        for (int i = 0; i < filas; i++) {
            System.out.println("Fila " + (i + 1) + ": X = " + vectorContador[i][0] + ", O = " + vectorContador[i][1]);
        }
    }

    // Método para imprimir la matriz
    public static void imprimirMatriz(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
