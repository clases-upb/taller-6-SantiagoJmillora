package org.example;

import java.util.Scanner;

public class PuntoCuatro {

    /*
     * 4. Escriba un algoritmo que cree un vector de N elementos (el N es dado por
     * el usuario) de números short aleatorios positivos mayores que cero, y luego
     * le pregunte al usuario qué posición quiere eliminar. Luego por un menú
     * presente las opciones: Dejar la casilla en 0 o desplazar los elementos de
     * manera que el cero quede en la última posición del vector. Después de la
     * operación mostrará el vector cómo va quedando y volverá a preguntar qué
     * posición quiere borrar y mostrará nuevamente el menú. En el menú aparecerá la
     * opción para terminar el programa.
     */

     public static void main(String[] args) {
        //Declaracion de Scanner para el programa
        Scanner tamanoVectorTeclado = new Scanner(System.in), opcionScanner = new Scanner(System.in), operacionSwitchScanner = new Scanner(System.in);
        int tamanoVector, opcion, operacionSwitch;
        short temp = 0;

        //Definicion de tamano para el vector que se usara en el programa
        System.out.println("Cuantos elementos desea en el vector? ");
        tamanoVector = tamanoVectorTeclado.nextInt();

        //Declaracion del vector con el tamano definido anteriormente
        short[] vector = new short[tamanoVector];

        //Rellenar el vector con valores mayores a 0
        for(int i = 0; i < vector.length; i++){
            vector[i] = (short)(Math.random() * 100 + 1);
        }

        //Do while para preguntar al usuario que posicion desea eleminar
        do {
            //Preguntamos que posicion se quiere elminar
            System.out.println("Que posicion desea eliminar?");
            
            //Ciclo for para mostrale al usuario las posiciones con los valores
            for(int i = 0; i < vector.length; i++){
                System.out.println("La posicion " + i + " tiene un valor de " + vector[i]);
            }
            System.out.println("Para salir del programa escriba " + (vector.length + 1));
            //Despues de mostrar el vector recolectamos la posicion que escogio el usuario
            opcion = opcionScanner.nextInt();

            //Arbol para las operaciones con la posicion seleccionada
            System.out.println("1. Para dejar la casilla " + opcion + " en 0\n2.Para desplazar los elementos de manera que el 0 quede al final.\n");
            operacionSwitch = operacionSwitchScanner.nextInt();

            switch (operacionSwitch) {
                case 1:
                        vector[opcion] = 0;
                        for(int i = 0; i < vector.length; i++){
                            System.out.println(vector[i]);
                        }
                    break;
                case 2:
                        vector[opcion] = 0;
                        for(int i = 0; i < vector.length -1; i++){
                            for(int j = 0; j < vector.length - i - 1; j++){
                                if(vector[j] < vector[j + 1]){
                                    temp = vector[j];
                                    vector[j] = vector[j + 1];
                                    vector[j + 1] = temp;
                                }
                            }
                        }
                        System.out.println("Vector ordenado con el valor 0 como la ultima posicion ");
                        for (int i = 0; i < vector.length; i++) {
                            System.out.println(vector[i]);
                        }
                        break;
                        
                default:
                        System.out.println("Escoja un valor adecuado");
                    break;
            }

            tamanoVectorTeclado.close();
            opcionScanner.close();
            operacionSwitchScanner.close();
        } while (opcion != vector.length + 1);

     }
}
