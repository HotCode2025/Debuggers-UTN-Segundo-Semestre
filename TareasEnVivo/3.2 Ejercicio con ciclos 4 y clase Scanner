
    
import java.util.ArrayList;
import java.util.Scanner;
public class ejrs4_Scanner {
    

    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            int numero;
            
            do {
                System.out.print("Digite un número: ");
                numero = scanner.nextInt();
                
                if (numero != 0) {
                    numeros.add(numero);
                }
            } while (numero != 0);
            
            System.out.println("\nNúmeros ingresados:");
            for (int n : numeros) {
                System.out.println(n);
            }
            
            System.out.println("El número 0 finaliza el programa.");
        }
    }
}

    

