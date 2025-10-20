
package Clase7;

import java.util.Scanner;

public class clase73EjCiclosScanner {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese un numero para poder calcular su factorial: ");
        int numero = entrada.nextInt();
        long factorial = 1;
        
        for (int i = 1; i <= numero; i++){
            factorial *= i;
        }
        System.out.println("El factorial de " + numero + " es: "+factorial);
    }
    
}
