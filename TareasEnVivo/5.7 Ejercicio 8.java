/*
5.7 Ejercicio Ciclos 08 con Scanner y JOptionPane

Ejercicio 8: Pedir un numero N, mostrar todos los numero de 1 al B

*/
package Ejercicio8;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Ejercicio8 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú de opciones Ejercicio 8");
            System.out.println("1) Usando Scanner");
            System.out.println("2) Usando JOptionPane");
            System.out.println("0) Salir");
            System.out.print("\nSeleccione una opción: ");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    usandoScanner(scanner);
                    break;
                case 2:
                    usandoJOptionPane();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 0);
    }
    
// Usando Scanner
    public static void usandoScanner(Scanner scanner) {
        System.out.print("\nIngrese un número entero: ");
        int n = Integer.parseInt(scanner.nextLine());

        if (n < 1) {
            System.out.println("El número debe ser mayor o igual a 1.");
            return;
        }

        System.out.println("Mostrando números del 1 al " + n + ":");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
        System.out.println(); // Salto de línea para un formato limpio.
    }

// Usando JOptionPane 
    public static void usandoJOptionPane() {
        String input = JOptionPane.showInputDialog(
            null,
            "Ingrese un número entero:",
            "Entrada de Datos",
            JOptionPane.QUESTION_MESSAGE
        );

        int n = Integer.parseInt(input);

        if (n < 1) {
            JOptionPane.showMessageDialog(
                    null,
                    "El número debe ser mayor o igual a 1.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        StringBuilder resultado = new StringBuilder("Los números del 1 al " + n + " son:\n");
        for (int i = 1; i <= n; i++) {
            resultado.append(i).append(" ");
        }

        JOptionPane.showMessageDialog(
            null,
            resultado.toString(),
            "Resultado",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}