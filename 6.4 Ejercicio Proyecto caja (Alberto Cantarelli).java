/*
6.4 Ejercicio: Proyecto Caja
Proyecto caja
Ejercicio 1: Crear un proyecto segun las especificaciones moestradas
a continuacion

La formula es: volumen = ancho * alto * profundidad 

 */
package caja;

public class PruebaCaja {

    public static void main(String[] args) {
        //Variables
        int medAncho = 5;
        int medAlto = 8;
        int medProfundidad = 4;

        //Constructor vacio, le pasamos valores
        Caja cajita = new Caja(); // Creamos objeto
        cajita.ancho = medAncho;
        cajita.alto = medAlto;
        cajita.profundo = medProfundidad;

        //Metodo, Calculo1
        int resultado = cajita.calcularVolumen();
        System.out.println("Volumen de la cajita: " + resultado);

        // Constructor 2, calculo 2
        Caja cajita1 = new Caja(5, 5, 5);
        System.out.println("Volumen cajita2: " + cajita1.calcularVolumen());

    }
}
