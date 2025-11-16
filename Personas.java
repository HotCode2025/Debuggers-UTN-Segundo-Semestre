
package domain
    // 9.1 Comenzamos, crear una nueva carpeta Lección6: estamos en herencia parte 1


public class Personas {
    //Atrivutos de herencia
    protected String nombre;
    protected char genero;
    protected int edad;
    protected String direccion;
    
    //Constructor vacio: este es para crear objetos sin necesidad de iniciar
    //los atributos de la clase
    public Personas() { //Constructor 1
        
    }
    
    public Personas(String nombre) { //Constructor 2
        this.nombre = nombre;
    }

    public Personas(String nombre, char genero, int edad, String direccion) { //Constructor3
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.direccion = direccion;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getGenero() {
        return this.genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
