package Metodos; //LLamado clases en clase

public class PruebaPersona {

    public static void main(String[] args) {
        Persona persona1 = new Persona(); //new es una palabra reservada para acceder, luego llamamos al constructor
        persona1.nombre = "Ariel"; //El valor hexadecimal normalmente comienza con 0x, un valor referencia en memoria (persona1)
        persona1.apellido = "Betancud";
        persona1.obtenerInformacion();

        //Video de crear un objeto mas
        Persona persona2 = new Persona();
        System.out.println("persona2 = " + persona2);
        System.out.println("persona1 = " + persona1);
        persona2.obtenerInformacion();
        persona2.nombre = "Osvaldo";
        persona2.apellido = "Giordanini";
        persona2.obtenerInformacion();

    }
}
