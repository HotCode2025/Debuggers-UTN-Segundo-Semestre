/*
6.4 Ejercicio: Proyecto Caja

Proyecto caja
Ejercicio 1: Crear un proyecto segun las especificaciones moestradas
a continuacion

La formula es: volumen = ancho * alto * profundidad 

*/

package proyectoCaja;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class proyectoCaja {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú de opciones Proyecto Caja");
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
        double ancho;
        do {
            System.out.print("\nIngrese el ancho: ");
            ancho = Double.parseDouble(scanner.nextLine());
            if (ancho <= 0) {
                System.out.println("Error: El ancho no puede ser 0.");
            }
        } while (ancho <= 0);
        
        double alto;
        do {
            System.out.print("Ingrese el alto: ");
            alto = Double.parseDouble(scanner.nextLine());
            if (alto <= 0) {
                System.out.println("Error: El alto no puede ser 0.");
            }
        } while (alto <= 0);

        double profundidad;
        do {
            System.out.print("Ingrese la profundidad: ");
            profundidad = Double.parseDouble(scanner.nextLine());
            if (profundidad <= 0) {
                System.out.println("Error: La profundidad no puede ser 0.");
            }
        } while (profundidad <= 0);
        
        System.out.println("\nEl volumen es: " + (alto * ancho * profundidad));
        
    }

// Usando JOptionPane 
    public static void usandoJOptionPane() {
        String entrada;
        double alto, ancho, profundidad;
        
        do {
            entrada = JOptionPane.showInputDialog(
                null,
                "Ingrese el ancho:",
                "Ancho",
                JOptionPane.QUESTION_MESSAGE
            );
            ancho = Double.parseDouble(entrada);
        } while (ancho <= 0);
        
        do {
            entrada = JOptionPane.showInputDialog(
                null,
                "Ingrese el alto:",
                "Alto",
                JOptionPane.QUESTION_MESSAGE
            );
            alto = Double.parseDouble(entrada);
        } while (alto <= 0);
            
        do {
            entrada = JOptionPane.showInputDialog(
                null,
                "Ingrese la profundidad:",
                "Profundidad",
                JOptionPane.QUESTION_MESSAGE
            );
            profundidad = Double.parseDouble(entrada);
        } while (profundidad <= 0);
        
    JOptionPane.showMessageDialog(null, "La volumen es: " + (alto * ancho * profundidad));
    }
}
