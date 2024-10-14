package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// import java.util.Scanner;

public class PuntoUno {
    /*
     * 1. Implemente un programa en java donde inserte elementos en dos vectores
     * globales de tamaños aleatorios y de contenido aleatorio (uno numérico y otro
     * de Strings). Considere dejar espacios libres en los vectores.
     * 
     * Desde un menú en el programa principal debe considerar cada opción para
     * llamar las siguientes funciones que también debe programar:
     * 
     * a. Recorrer secuencialmente (recibe un true cuando va del primero al último y
     * un false cuando va del último al primero)
     * • De primer elemento a último elemento: Imprime desde el primer elemento
     * hasta el último del vector dado en el parámetro de entrada.
     * • De último elemento al primer elemento: Imprime desde el último elemento
     * hasta el primero del vector dado en el parámetro de entrada.
     * 
     * b. Actualizar: recibe la posición que va a actualizar y el elemento. Al final
     * imprime el vector actualizado.
     * 
     * c. Añadir: después del último: recibe el elemento que va a añadir. Al final
     * imprime el vector actualizado.
     * 
     * d. Borrar: Recibe la posición donde del elemento que va a borrar.
     * 
     * e. Ordenar el vector:
     * • Ascendentemente.
     * • Descendentemente.
     * 
     * f. Búsqueda: Recibe como parámetro el elemento a buscar y devuelve un String
     * separado por el carácter '-', mostrando las posiciones donde se encuentra el
     * elemento.
     */
    public static Integer[] vectorNumerico;
    public static String[] vectorStrings;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Tamaños aleatorios entre 5 y 10 para ambos vectores
        int tamanoNumerico = random.nextInt(6) + 5;
        int tamanoStrings = random.nextInt(6) + 5;
        //Variable opcion para el do while
        int opcion;

        // Inicializar los vectores con elementos aleatorios y espacios vacios
        vectorNumerico = new Integer[tamanoNumerico];
        vectorStrings = new String[tamanoStrings];

        // Llenar con números aleatorios y Strings aleatorios, dejando algunos espacios vacíos
        for (int i = 0; i < tamanoNumerico; i++) {
            if (random.nextBoolean()) {
                vectorNumerico[i] = random.nextInt(101); // [0, 100]
            }
        }
        for (int i = 0; i < tamanoStrings; i++) {
            if (random.nextBoolean()) {
                vectorStrings[i] = "String" + random.nextInt(100); // String ##
            }
        }

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Recorrer secuencialmente");
            System.out.println("2. Actualizar elemento");
            System.out.println("3. Añadir elemento");
            System.out.println("4. Borrar elemento");
            System.out.println("5. Ordenar el vector");
            System.out.println("6. Buscar elemento");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("¿De primer a último? (true/false): ");
                    boolean secuencia = scanner.nextBoolean();
                    System.out.println("Vector numérico:");
                    recorrerVector(vectorNumerico, secuencia);
                    System.out.println("Vector de Strings:");
                    recorrerVector(vectorStrings, secuencia);
                    break;
                case 2:
                    System.out.println("Actualizar en el vector numérico:");
                    actualizar(vectorNumerico, scanner);
                    System.out.println("Actualizar en el vector de Strings:");
                    actualizar(vectorStrings, scanner);
                    break;
                case 3:
                    System.out.println("Añadir elemento al vector numérico:");
                    añadirElemento(vectorNumerico, scanner);
                    System.out.println("Añadir elemento al vector de Strings:");
                    añadirElemento(vectorStrings, scanner);
                    break;
                case 4:
                    System.out.println("Borrar en el vector numérico:");
                    borrarElemento(vectorNumerico, scanner);
                    System.out.println("Borrar en el vector de Strings:");
                    borrarElemento(vectorStrings, scanner);
                    break;
                case 5:
                    System.out.println("Ordenar vector numérico:");
                    ordenarVector(vectorNumerico, scanner);
                    System.out.println("Ordenar vector de Strings:");
                    ordenarVector(vectorStrings, scanner);
                    break;
                case 6:
                    System.out.println("Buscar en el vector numérico:");
                    buscarElemento(vectorNumerico, scanner);
                    System.out.println("Buscar en el vector de Strings:");
                    buscarElemento(vectorStrings, scanner);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }

    // Función para recorrer secuencialmente el vector
    /*La <T> significa genericos, lo que permite que la funcion trabaje con cualquier tipo de dato, 
    por lo que podrá recibir el vector de enteros y de Strings */
    public static <T> void recorrerVector(T[] vector, boolean haciaAdelante) {
        if (haciaAdelante) {
            for (int i = 0; i < vector.length; i++) {
                System.out.print(vector[i] + " ");
            }
        } else {
            for (int i = vector.length - 1; i >= 0; i--) {
                System.out.print(vector[i] + " ");
            }
        }
        System.out.println();
    }

    // Función para actualizar un elemento en el vector
    public static <T> void actualizar(T[] vector, Scanner scanner) {
        System.out.print("Ingrese la posición a actualizar (0-" + (vector.length - 1) + "): ");
        int posicion = scanner.nextInt();
        if (posicion >= 0 && posicion < vector.length) {
            if (vector instanceof Integer[]) {
                System.out.print("Ingrese el nuevo valor numérico: ");
                vector[posicion] = (T) (Integer) scanner.nextInt();
            } else if (vector instanceof String[]) {
                System.out.print("Ingrese el nuevo valor String: ");
                vector[posicion] = (T) scanner.next();
            }
            System.out.println("Vector actualizado: " + Arrays.toString(vector));
        } else {
            System.out.println("Posición inválida.");
        }
    }

    // Función para añadir un elemento al final del vector
    public static <T> void añadirElemento(T[] vector, Scanner scanner) {
        System.out.print("Ingrese el valor a añadir: ");
        T nuevoElemento = null;
        if (vector instanceof Integer[]) {
            nuevoElemento = (T) (Integer) scanner.nextInt();
        } else if (vector instanceof String[]) {
            nuevoElemento = (T) scanner.next();
        }

        // Añadir el elemento al primer espacio libre o ampliar el vector
        boolean añadido = false;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == null) {
                vector[i] = nuevoElemento;
                añadido = true;
                break;
            }
        }
        if (!añadido) {
            System.out.println("No hay espacio libre. Vector lleno.");
        } else {
            System.out.println("Elemento añadido: " + Arrays.toString(vector));
        }
    }

    // Función para borrar un elemento en el vector
    public static <T> void borrarElemento(T[] vector, Scanner scanner) {
        System.out.print("Ingrese la posición del elemento a borrar (0-" + (vector.length - 1) + "): ");
        int posicion = scanner.nextInt();
        if (posicion >= 0 && posicion < vector.length) {
            vector[posicion] = null;
            System.out.println("Elemento borrado. Vector: " + Arrays.toString(vector));
        } else {
            System.out.println("Posición inválida.");
        }
    }

    // Función para ordenar el vector (ascendente o descendente)
    public static <T extends Comparable<T>> void ordenarVector(T[] vector, Scanner scanner) {
        System.out.print("¿Ordenar ascendentemente? (true/false): ");
        boolean ascendente = scanner.nextBoolean();

        T[] sinNulls = Arrays.stream(vector).filter(e -> e != null).toArray(size -> (T[]) Arrays.copyOf(vector, size));
        Arrays.sort(sinNulls);

        if (!ascendente) {
            for (int i = 0; i < sinNulls.length / 2; i++) {
                T temp = sinNulls[i];
                sinNulls[i] = sinNulls[sinNulls.length - 1 - i];
                sinNulls[sinNulls.length - 1 - i] = temp;
            }
        }

        // Reemplazar el vector con el ordenado
        int index = 0;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] != null) {
                vector[i] = sinNulls[index++];
            }
        }

        System.out.println("Vector ordenado: " + Arrays.toString(vector));
    }

    // Función para buscar un elemento en el vector
    public static <T> void buscarElemento(T[] vector, Scanner scanner) {
        System.out.print("Ingrese el valor a buscar: ");
        T elemento = null;
        if (vector instanceof Integer[]) {
            elemento = (T) (Integer) scanner.nextInt();
        } else if (vector instanceof String[]) {
            elemento = (T) scanner.next();
        }

        StringBuilder posiciones = new StringBuilder();
        for (int i = 0; i < vector.length; i++) {
            if (elemento.equals(vector[i])) {
                if (posiciones.length() > 0) {
                    posiciones.append("-");
                }
                posiciones.append(i);
            }
        }

        if (posiciones.length() > 0) {
            System.out.println("Elemento encontrado en las posiciones: " + posiciones);
        } else {
            System.out.println("Elemento no encontrado.");
        }
    }

}
