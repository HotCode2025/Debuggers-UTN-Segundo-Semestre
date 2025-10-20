package clase6;

import javax.swing.JOptionPane;

public class Clase6SumaJOptionPane {
    public static void main(String[] args) {
        int suma = 0;
        int numero;
        for (int i = 1; i <= 10; i++){
            numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero "+i+":"));
            suma += numero;
            }
        JOptionPane.showMessageDialog(null,"La suma total es: "+ suma);
    }  
}
