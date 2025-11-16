/**
 * Ejercicio 6: Pedir numeros hasta que se teclee un 0
 * mostrar la suma de todos los numeros introducidos
 */

package Ejercicio1;

import javax.swing.JOptionPane;

public class Ejercicio1_JOptionPane {
    public static void main(String[] args) {
        int numero, suma = 0;
        
        do {
            String entrada = JOptionPane.showInputDialog("Ingrese un número (0 para fin):");
            numero = Integer.parseInt(entrada);
            suma += numero;
        } while (numero != 0);

        JOptionPane.showMessageDialog(null, "La suma de todos los números es: " + suma);
    }
}
