
package clase6;

import java.util.Scanner;
public class Clase6SumaScanner {

    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        int suma = 0;
        int numero;
        
        for (int i = 1; i <=10; i++){
            System.out.println("Ingrese el número "+ i + ":");
            numero = entrada.nextInt();
            suma += numero;
        }
        System.out.println("La suma total es: " + suma);
    }
    
}
