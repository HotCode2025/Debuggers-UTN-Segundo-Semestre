/*
5.8 Ejercicio Ciclos 09 Con Scanner y JOptionPane

Ejercicio 9: Pedir el día, mes y año de una fecha e
indicar si la fecha es correcta. Suponiendo que
todos lo meses son de 30 días

*/
package Ejercicio9;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Ejercicio9 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú de opciones Ejercicio 9");
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
        System.out.print("\nIngrese el día (1 al 30): ");
        int dia = Integer.parseInt(scanner.nextLine()); 

        System.out.print("Ingrese el mes (1 al 12): ");
        int mes = Integer.parseInt(scanner.nextLine()); 
        
        System.out.print("Ingrese el año: ");
        int anio = Integer.parseInt(scanner.nextLine()); 

        if (dia >= 1 && dia <= 30 && mes >= 1 && mes <= 12 && anio >= 1) {
            System.out.println("La fecha " + dia + "/" + mes + "/" + anio + " es CORRECTA.");
        }
        else {
            System.out.println("La fecha " + dia + "/" + mes + "/" + anio + " es INCORRECTA.");
        }
    }

// Usando JOptionPane 
    public static void usandoJOptionPane() {
        String input;
        
        input = JOptionPane.showInputDialog(
            null,
            "Ingrese el día (1 al 30):",
            "Día",
            JOptionPane.QUESTION_MESSAGE
        );
        int dia = Integer.parseInt(input);

        input = JOptionPane.showInputDialog(
            null,
            "Ingrese el mes (1 al 12)",
            "Mes",
            JOptionPane.QUESTION_MESSAGE
        );
        int mes = Integer.parseInt(input);

        input = JOptionPane.showInputDialog(
            null,
            "Ingrese el año",
            "Año",
            JOptionPane.QUESTION_MESSAGE
        );
        int anio = Integer.parseInt(input);

        if (dia >= 1 && dia <= 30 && mes >= 1 && mes <= 12 && anio >= 1) {
            JOptionPane.showMessageDialog(
                null,
                "La fecha " + dia + "/" + mes + "/" + anio + " es CORRECTA.",
                "Fecha",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
        else {
            JOptionPane.showMessageDialog(
                null,
                "La fecha " + dia + "/" + mes + "/" + anio + " es INCORRECTA.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
