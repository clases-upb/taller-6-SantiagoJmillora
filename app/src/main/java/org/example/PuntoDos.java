package org.example;

public class PuntoDos {
    /*
     * 2. Escriba un algoritmo que calcule aleatoriamente N temperaturas, las lleve
     * a un vector y luego calcule su media, cuántas temperaturas están por encima
     * de la media y cuántas por debajo.
     */

     //Declaracion de vector a nivel global con una cantidad de espacios aleatoria [1, 10]
     public static int[] temperaturas = new int[(int)(Math.random() * (10 + 1))];

     public static void main(String[] args) {
        try {
            //Salida de RellenarVector()
            System.out.print("Las temperaturas son \n");
            if(RellenarVector()){
                for (int i = 0; i < temperaturas.length; i++) {
                    System.out.println(temperaturas[i] + " en la posicion " + i);
                }
            }

            //Salida de CalcularMedia()
            System.out.println("La media de las temperaturas es "+ CalcularMedia());

            //Salida EncimaMeida
            System.out.println("Hay " + EncimaMedia() + " valores por encima de la media.");

            //Salida DebajoMedia
            System.out.println("Hay " + DebajoMedia() + " valores por debajo de la media.");

        } catch (Exception e) {
            // TODO: handle exception
        }
     }

     //Funcion para rellenar el vector
     public static boolean RellenarVector() throws Exception{
        try {
            int temperaturaAleatoria = 0;
            //ciclo for para rellenar el vector
            for(int i = 0; i < temperaturas.length; i++){
                temperaturaAleatoria = (int)(Math.random() * (100 + 1));
                temperaturas[i] = temperaturaAleatoria;
            }

            return true;
        } catch (Exception e) {
            throw new Exception("Ocurrio un error en vRellenar " + e);
        }
     }

     //Funcion para calcular su media
     public static double CalcularMedia() throws Exception{
        try {
            double media = 0;

            //Ciclo for para encontrar la media del vector
            for(int i = 0; i < temperaturas.length; i++){
                media += temperaturas[i];
            }

            media /= temperaturas.length;

            return media;
        } catch (Exception e) {
            throw new Exception("Ocurrio un error en CalcularMedia " + e);
        }
     }

     //Funcion para saber cuantas temperaturas estan por encima de la media
     public static int EncimaMedia() throws Exception{
        try {
            int contador = 0;

            //Ciclo para recorrer el vector
            for(int i = 0; i < temperaturas.length; i++){
                if(temperaturas[i] > CalcularMedia())
                    contador++;
            }

            return contador;
        } catch (Exception e) {
            throw new Exception("Ocurrio un error en la funcion EncimaMedia " + e);
        }
     }

     public static int DebajoMedia() throws Exception{
        try {
            int contador = 0;

            //Ciclo para recorrer el vector
            for(int i = 0; i < temperaturas.length; i++){
                if(temperaturas[i] < CalcularMedia())
                    contador++;
            }

            return contador;
        } catch (Exception e) {
            throw new Exception("Ocurrio un error en DebajoMedia " + e);
        }
     }
}
