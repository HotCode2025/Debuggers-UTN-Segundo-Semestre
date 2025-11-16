package CicloWhile;

public class EjercicioWhile01 {
    public static void main(String[] args) {
        // break
        System.out.println("break");
        for (var contador1 = 0; contador1 <= 7; contador1++) {
            if (contador1 % 2 == 0) {
                System.out.println("Contador = " + contador1);
                break;
            }
        }

        // continue
        System.out.println("continue");
        for (var contador1 = 0; contador1 <= 7; contador1++) {
            if (contador1 % 2 != 0) {
                continue;
            }
            System.out.println("Contador = " + contador1);
        }
    }
}
