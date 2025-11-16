package test;

import domain.Empleado;
import domain.Cliente;

import java.util.Date;

public class TestHerencia {
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Ariel", 57000.0);
        System.out.println("Empleado: " + empleado1);

        Cliente cliente1 = new Cliente("Debuggers UTN", new Date(), true);
        System.out.println("Cliete: " + cliente1);

    }
}
