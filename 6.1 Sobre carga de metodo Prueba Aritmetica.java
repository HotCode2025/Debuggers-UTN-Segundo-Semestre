
public class prueba {
    
public static void main(String[] args) {
    Aritmetica aritmetical = new Aritmetica();
    aritmetical.a = 3;
    aritmetical.b = 7;
    aritmetical.sumarNumeros();

    int resultado = aritmetical.sumarConRetorno();
    System.out.println("resultado = " + resultado);

    resultado = aritmetical.sumarConArgumentos(12, 26);
    System.out.println("Resultado usando argumentos = " + resultado);

    System.out.println("aritmetical a: " + aritmetical.a);
    System.out.println("aritmetical b: " + aritmetical.b);
    
    Aritmetica aritmetica2 = new Aritmetica(5, 8);
    System.out.println("aritmetica2 a: " + aritmetica2.a);
    System.out.println("aritmetica2 b: " + aritmetica2.b);
}

    
    
    
}

 
