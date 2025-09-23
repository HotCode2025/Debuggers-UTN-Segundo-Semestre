/**
 * Ejercicio 7; pedir numeros hasta que se introduzca uno negativo
 * Calcular la media
  */
package Ejercicio;

import javax.swing.JOptionPane;

public class Ejercicio_JOptionPane {
        public static void main(String[] args) {
        int numero, suma = 0, contador = 0;

        String entrada = JOptionPane.showInputDialog("Ingresar un número (número negativo para fin): ");
        numero = Integer.parseInt(entrada);            

        while (numero >= 0) {
            suma += numero;
            contador++;
            entrada = JOptionPane.showInputDialog("Ingresar un número (número negativo para fin): ");
            numero = Integer.parseInt(entrada);
        }

        if (contador > 0) {
            double media = (double) suma / contador;
            System.out.println("La media de los números ingresados es: " + media);
        }
    }
}
