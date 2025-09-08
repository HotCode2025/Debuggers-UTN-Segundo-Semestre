/**
 * Ejercicio 6: Pedir numeros hasta que se teclee un 0
 * mostrar la suma de todos los numeros introducidos
 */

package Ejercicio1;

import java.util.Scanner;

public class Ejercicio1_Scanner {
    public static void main(String[] args) {
        int numero;
        int suma = 0;

        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingresar un número (0 para fin): ");
        numero = entrada.nextInt();

        do {
            suma = suma + numero;
            System.out.print("Ingresa un número (0 para fin): ");
            numero = entrada.nextInt();
        } while (numero != 0);

        System.out.println("La suma de todos los números es: " + suma);
    }
}
