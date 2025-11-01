/*
6.4 Ejercicio: Proyecto Caja

Proyecto caja
Ejercicio 1: Crear un proyecto segun las especificaciones moestradas a continuacion

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
        int ancho;
        do {
            System.out.print("\nIngrese el ancho: ");
            ancho = Integer.parseInt(scanner.nextLine());
            if (ancho <= 0) {
                System.out.println("Error: El ancho no puede ser 0.");
            }
        } while (ancho <= 0);
        
        int alto;
        do {
            System.out.print("Ingrese el alto: ");
            alto = Integer.parseInt(scanner.nextLine());
            if (alto <= 0) {
                System.out.println("Error: El alto no puede ser 0.");
            }
        } while (alto <= 0);

        int profundidad;
        do {
            System.out.print("Ingrese la profundidad: ");
            profundidad = Integer.parseInt(scanner.nextLine());
            if (profundidad <= 0) {
                System.out.println("Error: La profundidad no puede ser 0.");
            }
        } while (profundidad <= 0);
        
        Caja caja1 = new Caja();
        caja1.ancho = ancho;
        caja1.alto = alto;
        caja1.profundidad = profundidad;
        int volumen = caja1.calcularVolumen();
        System.out.println("\nEl volumen es: " + volumen);
        
    }

// Usando JOptionPane 
    public static void usandoJOptionPane() {
        String entrada;
        int alto, ancho, profundidad;
        
        do {
            entrada = JOptionPane.showInputDialog(
                null,
                "Ingrese el ancho:",
                "Ancho",
                JOptionPane.QUESTION_MESSAGE
            );
            ancho = Integer.parseInt(entrada);
        } while (ancho <= 0);
        
        do {
            entrada = JOptionPane.showInputDialog(
                null,
                "Ingrese el alto:",
                "Alto",
                JOptionPane.QUESTION_MESSAGE
            );
            alto = Integer.parseInt(entrada);
        } while (alto <= 0);
            
        do {
            entrada = JOptionPane.showInputDialog(
                null,
                "Ingrese la profundidad:",
                "Profundidad",
                JOptionPane.QUESTION_MESSAGE
            );
            profundidad = Integer.parseInt(entrada);
            
        } while (profundidad <= 0);
        
        Caja caja2 = new Caja();
        caja2.ancho = ancho;
        caja2.alto = alto;
        caja2.profundidad = profundidad;
        int volumen = caja2.calcularVolumen();
        
        JOptionPane.showMessageDialog(null, "La volumen es: " + volumen);
    }

}
