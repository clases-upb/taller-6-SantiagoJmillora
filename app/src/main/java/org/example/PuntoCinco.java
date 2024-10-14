package org.example;

import java.util.Scanner;

public class PuntoCinco {
    /*
     * 5. Escriba un algoritmo para convertir un número decimal en un número
     * hexadecimal, apoyado en vectores.
     */
    public static void main(String[] args) {
        try {
            Scanner decimalesScanner = new Scanner(System.in);
            int decimal;
            System.out.println("Que numero desea convertir a hexadecimal? ");
            decimal = decimalesScanner.nextInt();
            System.out.println(ConversionHexa(decimal));
            decimalesScanner.close();
        } catch (Exception e) {
            
        }
    }

    public static String SinEntradaUsuario() throws Exception{
        try {
            int[] decimales = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
            String[] hexadecimales;
            short contador = 0;
            String msjSalida = "";

            for (int i = 0; i < decimales.length; i++) {
                contador++;
            }

            hexadecimales = new String[contador];

            for (int i = 0; i < decimales.length; i++) {
                switch (decimales[i]) {
                    case 0:
                            hexadecimales[i] = "0";
                        break;
                    case 1:
                            hexadecimales[i] = "1";
                        break;
                    case 2:
                            hexadecimales[i] = "2";
                        break;
                    case 3:
                            hexadecimales[i] = "3";
                        break;
                    case 4:
                            hexadecimales[i] = "4";
                        break;
                    case 5:
                            hexadecimales[i] = "5";
                        break;
                    case 6:
                            hexadecimales[i] = "6";
                        break;                   
                    case 7:
                            hexadecimales[i] = "7";
                        break;
                    case 8:
                            hexadecimales[i] = "8";
                        break;
                    case 9:
                            hexadecimales[i] = "9";
                        break;
                    case 10:
                            hexadecimales[i] = "A";
                        break;
                    case 11:
                            hexadecimales[i] = "B";
                        break;
                    case 12:
                            hexadecimales[i] = "C";
                        break;
                    case 13:
                            hexadecimales[i] = "D";
                        break;
                    case 14:
                            hexadecimales[i] = "E";
                        break;
                    case 15:
                            hexadecimales[i] = "F";
                        break;
                }
            }

            for (int i = 0; i < hexadecimales.length; i++) {
                msjSalida += hexadecimales[i];
            }

            return msjSalida;
        } catch (Exception e) {
            throw new Exception("Ocurrio un error en sinEntradaUsuario " + e);
        }
    }
    

    public static String ConversionHexa(int numero) throws Exception{
        try {
            String msjFinal = "El numero " + numero + " en hexadecimal es ";
            String[] hexadecimales = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
            String[] conversionHecha;
            int residuo, posicionVector = 0, tamanoVector = 0, temp;

            temp = numero;

            while(temp > 0){
                temp = temp / 16;
                tamanoVector++;
            }

            conversionHecha = new String[tamanoVector];
            temp = numero;

            while(temp > 0){
                residuo = temp % 16;
                conversionHecha[posicionVector] = hexadecimales[residuo];
                posicionVector++;
                temp /= 16;
            }

            for (int i = conversionHecha.length -1 ; i >= 0; i--) {
                msjFinal += conversionHecha[i];
            }

            return msjFinal;
        } catch (Exception e) {
            throw new Exception("Ocurrio un error " + e);
        }
    }

    
}
