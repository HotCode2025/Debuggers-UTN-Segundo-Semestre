/*
Ejercicio 3:Leer numeros hasta que se introduzca un cero
Para cada uno indica si es par o impar.
Primero lo haremos con la claseScanner
Luego con la clase JOptionPane
*/
package Ciclos03;

import java.util.Scanner;


 public class Ciclos03 {
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
            int numero;
            
            System.out.println("Digite un numero:");
            numero = scanner.nextInt();
            
            while (numero != 0) {
                if (numero % 2 == 0) {
                    System.out.println("El numero " + numero + " es par.");
                } else {
                    System.out.println("El numero " + numero + " es impar");
                }
                
                System.out.println("Digite otro numero (0 para finalizar):");
                numero = scanner.nextInt();
            }
            
            System.out.println("El numero 0 finaliza el programa.");
        }
    }




