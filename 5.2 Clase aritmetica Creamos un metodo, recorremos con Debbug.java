
public class Aritmetica {
  
    // Atributos de la clase 
    int a;
    int b;
    //El contructor es un metodo especial
    public Aritmetica(){ // Constructor 1 vacio
        System.out.println("Se esta ejecutanto contructor numero uno");
        
    }
   
    //Metodo
    public void sumarNumeros(){
        int resultado = a + b;
        System.out.println("resultado = " + resultado);
    }
    public int sumarConRetorno() {
    // int resultado = a + b;
    return this.a + this.b;
    }
 
}
    