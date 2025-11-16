/**
 *
 * @author Kevito
 */
class Persona {
    String nombre;
    String apellido;
    
    Persona(String nombre, String apellido) { //Constructor
        super(); //LLamada al contructor de la clase Padre object
        this.nombre = nombre;
        this.apellido = apellido;
        System.out.println("Objeto persona usando this: "+this);
    }
}

class Imprimir {
    public Imprimir(){
        super(); //el constructor de la clase padre, para reservar memoria
    }
    
    public void imprimir(Persona persona) {
        System.out.println("Persona desde la clase imprimir: "+persona);
        System.out.println("Impresion del objeto actual (this): "+this);
    }
}
