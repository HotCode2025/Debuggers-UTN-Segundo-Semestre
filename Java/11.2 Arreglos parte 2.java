
package test;

import java.util.Arrays;


public class TestArreglos {

    /**
     *
     * @param args
     */
    public static void main(String[] args) { //en el lado derecho instanciamos un objeto de tipo object
        int edades[] = new int [3]; //en el lado izquierdo declaramos la variable
        System.out.println("edades = " + (edades));
        
        edades[0] = 17;
        System.out.println("edades 0 = " + edades [0]);
        edades[1] = 7;
        System.out.println("edades 1 = " + edades [1]);
        edades[2] = 27;
        System.out.println("edades 2 = " + edades [2]);
    }
}
