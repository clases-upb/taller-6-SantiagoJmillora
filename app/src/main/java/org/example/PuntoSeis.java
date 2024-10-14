package org.example;

import java.util.Scanner;

public class PuntoSeis {
    /*
     * 6. Escriba un algoritmo que solicite al usuario el orden de una matriz
     * cuadrática, implemente su matriz transpuesta (investiga qué es) y la imprima.
     */
    public static void main(String[] args) {
        try {
                    Scanner tamanoMatrizScanner = new Scanner(System.in);
                    int tamanoMatriz = 0;
                    
                    System.out.println("De que tamaño desea la matriz cuadratica?");
                    tamanoMatriz = tamanoMatrizScanner.nextInt();
                    System.out.println(MatrizTranspuesta(tamanoMatriz));
                    tamanoMatrizScanner.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static String MatrizTranspuesta(int tamano) throws Exception{
        try {
            String msjFinal = "";
            int[][] matriz = new int[tamano][tamano];
            int[][] transpuesta = new int[tamano][tamano];

            //Rellenar la matriz con aleatorios
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    matriz[i][j] = (int)(Math.random() * (10));
                    msjFinal += matriz[i][j] + " ";
                }
                msjFinal += "\n";
            }
            msjFinal += "La transpuesta seria: \n";
            //Hacer la transpuesta
            for (int i = 0; i < transpuesta.length; i++) {
                for (int j = 0; j < transpuesta.length; j++) {
                    transpuesta[j][i] = matriz[i][j];
                }
            }
            
            for (int i = 0; i < transpuesta.length; i++) {
                for (int j = 0; j < transpuesta.length; j++) {
                    msjFinal += transpuesta[i][j]  + " ";
                    //La impresion se debe hacer como se hace normalmente solamente se cambia el orden de las i(filas) y j(columnas) para llenar la matriz
                }
                msjFinal += "\n";
            }
            return msjFinal;
        } catch (Exception e) {
            throw new Exception("Ocurrio un error en MatrizTranspuesta" + e);
        }
    }
}
