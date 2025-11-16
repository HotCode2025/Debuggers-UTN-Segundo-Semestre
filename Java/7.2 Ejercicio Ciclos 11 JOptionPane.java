/*
7.2 Ejercicio Ciclos 

Ejercicio 11: Diseñar un progfrma que muestre el producto 
de los 10 primeros numeros impares

*/

package ejercicio11;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class ejercicio11 {
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
        long producto = 1;
        System.out.println("Calculando el producto de los 10 primeros números impares:");
        
        for (int i = 1; i < 20; i += 2) {
            System.out.println("Multiplicando " + producto + " * " + i);
            producto = producto * i;
        }
        
        System.out.println("\nEl resultado final es: " + producto);

    }

// Usando JOptionPane 
    public static void usandoJOptionPane() {
        long producto = 1;
        
        StringBuilder detallesCalculo = new StringBuilder();
        detallesCalculo.append("Pasos del cálculo:\n\n");
        
        for (int i = 1; i < 20; i += 2) {
            detallesCalculo.append("Multiplicando por: ").append(i).append("\n");
            producto = producto * i;
        }
        
        detallesCalculo.append("\nEl producto final es: ").append(producto);
        
        JOptionPane.showMessageDialog(
            null, 
            detallesCalculo.toString(), 
            "Producto de Números Impares", 
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}

