package test;

import domain.Persona;


public class TestMatrices {
    public static void main(String[] args) {
        // Declaramos una matriz de objetos de tipo Persona
        Persona personas[][] = new Persona[2][3];   
        // Asignamos valores a la matriz
        personas[0][0] = new Persona("Ariel");
        personas[0][1] = new Persona("Osvaldo");
        personas[0][2] = new Persona("Liliana");
        personas[1][0] = new Persona("Natalia");
        personas[1][1] = new Persona("Marcelo");
        personas[1][2] = new Persona("Debora");

        System.out.println("Matriz de Personas: ");
        imprimir(personas);
    }

    public static void imprimir(Object matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("matriz " + i + "-" + j + ": " + matriz[i][j]);
            }
        }
    }
}



