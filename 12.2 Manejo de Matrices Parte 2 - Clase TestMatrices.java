package test;

public class TestMatrices {
    public static void main(String[] args) {
        int edades[][] = new int [3][2];
        System.out.println("edades = " + edades);
        edades[0][0] = 2; // Llenado manual
        edades[0][1] = 4;
        edades[1][0] = 6;
        edades[1][1] = 8;
        edades[2][0] = 10;
        edades[2][1] = 12;

        System.out.println("edades 0-0 = " + edades[0][0]);
        System.out.println("edades 0-1 = " + edades[0][1]);
        System.out.println("edades 1-0 = " + edades[1][0]);
        System.out.println("edades 1-1 = " + edades[1][1]);
        System.out.println("edades 2-0 = " + edades[2][0]);
        System.out.println("edades 2-1 = " + edades[2][1]);
        
    }
}
