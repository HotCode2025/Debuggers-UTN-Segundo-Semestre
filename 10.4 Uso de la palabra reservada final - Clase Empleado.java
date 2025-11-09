package domain;

// public class Empleado extends Persona { no se puede crear una clase hija porque la clase persona en FINAL
public class Empleado extends Persona {
    public void imprimir() {
        System.out.println("Metodo imprimir de la clase hija");
    }
}
