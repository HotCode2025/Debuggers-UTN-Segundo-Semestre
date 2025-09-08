/**
 * Ejercicio 7; pedir numeros hasta que se introduzca uno negativo
 * Calcular la media
  */
package Ejercicio;

import java.util.Scanner;

public class Ejercicio_Scanner {
        public static void main(String[] args) {
        int numero, suma = 0, contador = 0;

        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingresar un número (número negativo para fin): ");
        numero = entrada.nextInt();

        while (numero >= 0) {
            suma += numero;
            contador++;
            System.out.print("Ingresar un número (número negativo para fin): ");
            numero = entrada.nextInt();
        }

        if (contador > 0) {
            double media = (double) suma / contador;
            System.out.println("La media de los números ingresados es: " + media);
        }
    }
}
