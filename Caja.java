/*
6.4 Ejercicio: Proyecto Caja

Proyecto caja
Ejercicio 1: Crear un proyecto segun las especificaciones moestradas
a continuacion

La formula es: volumen = ancho * alto * profundidad 

 */
package caja;

public class Caja {

    //Atributos
    int ancho;
    int alto;
    int profundo;

    //Constructor1
    public Caja() { // Vacio

    }

    //Constructor2
    public Caja(int ancho, int alto, int profundo) { // Parametros
        this.ancho = ancho;
        this.alto = alto;
        this.profundo = profundo;
    }

    //Metodo para calcular
    public int calcularVolumen(){
        return ancho * alto * profundo ;
    }
}