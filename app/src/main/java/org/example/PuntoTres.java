package org.example;

import java.io.*;

public class PuntoTres {
    /*
     * 3. Cargue un vector a partir de un archivo de palabras, con mínimo 10
     * palabras. Ordene el vector de manera ascendente y luego de forma descendente.
     * 
     * Escriba el vector inicial sin ordenar, los vectores ordenados.
     */

     public static void main(String[] args) {
        try {
            //Variables para manejo de archivos
            File palabras = new File("app\\src\\resources\\palabras.txt");
            BufferedReader bufferedPalabras = new BufferedReader(new FileReader(palabras));
            String lineaPalabras = bufferedPalabras.readLine();

            //Contador para determinar el tamano del vector
            int contador = 0;

            //Declaracion del vector
            String[] vPalabras = new String[10];

            if(lineaPalabras == null)
                System.out.println("Error");
            else{

                while (lineaPalabras != null) {
                    vPalabras[contador] = lineaPalabras;
                    contador++;
                    lineaPalabras = bufferedPalabras.readLine();
                }

                bufferedPalabras.close();
            }


            System.out.println("Orden");
            System.out.println(ImprimirVectorOrden(vPalabras));

            // String resultado = ImprimirVectorDesorden(vPalabras);
            System.out.println("Desorden");
            System.out.println(ImprimirVectorDesorden(vPalabras));
        } catch (Exception e) {
            // TODO: handle exception
        }
     }

     public static String ImprimirVectorOrden(String[] vImprimir) throws Exception{
        try {
            String msjRetornar = "";

            for(int i = 0; i < vImprimir.length; i++){
                msjRetornar += "\n" + vImprimir[i];
            }

            return msjRetornar;
        } catch (Exception e) {
            throw new Exception("Ocurrio un error " + e);
        }
     }

     public static String ImprimirVectorDesorden(String[] vImprimir) throws Exception{
        try {
            String msjString = "";

            for(int i = vImprimir.length - 1; i >= 0; i--){
                msjString += "\n" + vImprimir[i];
            }

            return msjString;
        } catch (Exception e) {
            throw new Exception("Ocurrio un error " + e);
        }       
     }
}
