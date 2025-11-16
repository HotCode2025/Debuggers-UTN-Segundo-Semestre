package ciclowhile;
public class CicloDowhile {
    public static void main(String[]args){
    var conteo=0; //inferencia en tipos
    while (conteo<7){
        System.out.println("conteo = " + conteo);
        conteo++;//aumento en una de la variable 
    }
     var contador=0; 
     do {
         System.out.println("contador= " + contador);
        conteo++; 
     }
    while (contador<=7);
        
    
    
    
    }
}