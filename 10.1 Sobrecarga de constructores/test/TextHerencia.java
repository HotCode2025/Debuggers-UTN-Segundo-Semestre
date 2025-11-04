
package test;

import domain.Empleado;
import domain.Cliente;
import domain.Persona;
import java.util.Date;

public class TextHerencia {
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Ariel", 57000.0);
        System.out.println("empleado1 = " + empleado1);
        
//        Cliente cliente1 = new Cliente(new Date(), true, "Bety", "F", 32, "9 de Julio 1413");
//        System.out.println("cliente1 = " + cliente1);
//        
//        Persona persona1 = new Persona();
    }
}
