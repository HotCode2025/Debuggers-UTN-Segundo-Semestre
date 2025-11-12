/*
 Uso de la palabra Final
Esta palabra tiene diferentes significados dependiendo donde
se aplique:
    Variables: Evita cambiar el valor que almacena la variable
    Metodos: Evita que se modifique ladefinicion o el comportamiento
             de un metodo desde una subclase (hija)
    Clases: Evita que se creen clases hijas
Otra caracteristica es que normalmente, cuando trabajamos con variables
se combina con el modificador de acceso estatico para convertir una 
variable en una constante, es decir que no se puede modificar su valor,
el ejemplo de esto es la clase Math en la cual todos sus atributos 
son de tipo static y final, es por esto que la variable pi* ce conoce
como constante.
 */
//10.4 Uso de la palabra reservada final, Parte 1 a la Parte 4
package test;

import domain.Persona;

public class TestFinal {

    public static void main(String[] args) {
        final int miDni = 36897645;
        System.out.println("miDni = " + miDni);
        //miDni = 35098679; // No se puede modificar variable final
        //Persona.CONSTANTE_AQUI = 9; //No se puede modificar
        System.out.println("Mi atributo constante es: " + Persona.CONSTANTE_AQUI);

        final Persona persona1 = new Persona();
        //persona1 = new Persona(); No se puede asignar una nueva referencia
        persona1.setNombre("Jairo Ubilla");
        System.out.println("persona1 nombre: " + persona1.getNombre());
        persona1.setNombre("Wilson");
        System.out.println("persona1 nombre: " + persona1.getNombre());
    }
}
