
package Clase7;

import javax.swing.JOptionPane;
public class Clase73EjCiclosJOptionPane {
    public static void main(String[] args) {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero para poder calcular su factorial: "));
        long factorial = 1;
        
        for (int i=1; i <= numero;i++){
            factorial *=i;
        }
        JOptionPane.showMessageDialog(null,"El factorial de "+ numero + " es: " +factorial);
    }
}
