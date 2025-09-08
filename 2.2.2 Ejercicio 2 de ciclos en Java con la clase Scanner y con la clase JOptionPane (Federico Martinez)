/*
Ejercicio 2: Leer un numero e indicar si es positivo o negativo.
El proceso se repetira hasta que se introduza un cero 0
Hacer este ejercicio con la clase Scanner y luego hacerlo nuevamente con la clase JOptionPane*/
package EjercicioCiclosJOptionPane;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class EjercicioCiclosJOptionPane {

    public static void main(String[] args) {

        var numero = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero: "));
        while (numero != 0) {
            if (numero > 0) {
                System.out.println("El numero " + numero + " es POSITIVO");
            } else {
                System.out.println("El numero" + numero + " es NEGATIVO");
            }
            numero = Integer.parseInt(JOptionPane.showInputDialog("Digite otro numero: "));
        }
        System.out.println("El numero " + numero + " Finaliza el programa");
    }

}
