package proyectoCaja;

public class Caja {
    
    int ancho;
    int alto;
    int profundidad;
    
    // Contructor vacio
    public Caja() {
    }

    // Constructor con parametros
    public Caja(int alto, int ancho, int profundidad) {
        this.alto = alto;
        this.ancho = ancho;
        this.profundidad = profundidad;
    }
    
    public int calcularVolumen() {
        return alto * ancho * profundidad;
    }
}
