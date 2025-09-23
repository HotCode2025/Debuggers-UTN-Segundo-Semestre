import javax.swing.JOptionPane;
import java.util.Random;

public class Ejr5_JOption {
    public static void main(String[] args) {
        Random random = new Random();
        int numeroSecreto = random.nextInt(101); // Número entre 0 y 100
        int intentos = 0;
        int numeroUsuario = -1;

        JOptionPane.showMessageDialog(null, "🔢 ¡Bienvenido al juego de adivinar el número!\nEstoy pensando en un número entre 0 y 100...");

        while (numeroUsuario != numeroSecreto) {
            String input = JOptionPane.showInputDialog(null, "👉 Ingresá tu número:");

            if (input == null) { // Si el usuario cierra la ventana o cancela
                JOptionPane.showMessageDialog(null, "Juego cancelado.");
                System.exit(0);
            }

            try {
                numeroUsuario = Integer.parseInt(input);
                intentos++;

                if (numeroUsuario < numeroSecreto) {
                    JOptionPane.showMessageDialog(null, "📈 Es mayor");
                } else if (numeroUsuario > numeroSecreto) {
                    JOptionPane.showMessageDialog(null, "📉 Es menor");
                } else {
                    JOptionPane.showMessageDialog(null, "🎉 ¡Correcto! El número era " + numeroSecreto
                            + "\n🔁 Lo adivinaste en " + intentos + " intentos.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, " ingresá un número válido.");
            }
        }
    }
}
