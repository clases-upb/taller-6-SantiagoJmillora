package org.example;

public class PuntoSiete {
    /*
     * 7. Escriba un algoritmo que calcule el producto y la división. Los operandos
     * serán la suma de elementos de la diagonal principal y la suma de los
     * elementos de la diagonal secundaria. Los elementos de la matriz deben ser
     * llenados usando la función random para calcular números aleatorios entre 10 y
     * 100.
     */

    public static int[][] Matriz = new int[5][5]; 
    public static void main(String[] args) {
        try {
            int producto = 0, sumaDiagonalPP = SumarDiagonalPP(), sumaDiagonalSecundaria = SumarDiagonalSecundaria();
            double division = 0;
            //Impresion de matriz
            System.out.println("MATRIZ");
            for (int i = 0; i < Matriz.length; i++) {
                for (int j = 0; j < Matriz.length; j++) {
                    System.out.print(Matriz[i][j] + " ");
                }
                System.out.println();
            }
            
            System.out.println("Suma diagonal principal " + sumaDiagonalPP);
            System.out.println("Suma diagonal secundaria " + sumaDiagonalSecundaria);
            producto = sumaDiagonalPP * sumaDiagonalSecundaria;
            division = sumaDiagonalPP / sumaDiagonalSecundaria;
            System.out.println("El resultado de " + sumaDiagonalPP + " * " + sumaDiagonalSecundaria + " es igual a " + producto);

            if(sumaDiagonalPP > sumaDiagonalSecundaria)
                System.out.println("El resultado de " + sumaDiagonalPP + " / " + sumaDiagonalSecundaria + " es igual a " + division);
            else    
                System.out.println("La sumatoria de la diagonal secundaria es mayor a la diagonal principal, por ende no podemos calcular la division");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static int SumarDiagonalPP() throws Exception{
        try {
           int resultado = 0;

           //recorriendo la matriz
           for (int i = 0; i < Matriz.length; i++) {
            for (int j = 0; j < Matriz.length; j++) {
                //Llenando la matriz con aleatorios
                Matriz[i][j] = (int)(Math.random() * 100 - 10 + 11);

                //Sumando la diagonal principal
                if(i == j)
                    resultado += Matriz[i][j];
            }
           }

           return resultado;
        } catch (Exception e) {
            throw new Exception("Ocurrio un error en SumarDiagonalPP " + e);
        }
    }

    public static int SumarDiagonalSecundaria() throws Exception{
        try {
            int resultado = 0;

            //Recorremos la matriz
            for (int i = 0; i < Matriz.length; i++) {
                for (int j = Matriz.length -1; j >= 0; j--) {
                    //Cada vez que la j coincida con la I se suma 
                    if(i + j == Matriz.length -1)
                        resultado += Matriz[i][j];
                }
            }

            return resultado;
        } catch (Exception e) {
            throw new Exception("Ocurrio un error en SumarDiagonalSecundaria " + e);
        }
    }
}
