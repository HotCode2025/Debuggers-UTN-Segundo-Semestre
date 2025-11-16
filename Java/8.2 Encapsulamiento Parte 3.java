
package leccion8;

public class Leccion8 {


    public static void main(String[] args) {
       Persona persona1 = new Persona("Enzo",57000,false);
        System.out.println("persona1 su nombre es: "+persona1.getNombre());
        //modificar a traves de los metodos
        persona1.setNombre("Juan Ignacio");
        //persona1.nombre = "Juan Ignacio"; //ya no se puede utilizar
        //System.out.println("Nombre es: "+persona1.nombre); //error
        System.out.println("persona1 con su nombre modificado: "+persona1.getNombre);
        System.out.println("persona1 el resultado para el sueldo: "+persona1.getSueldo);
        System.out.println("persona1 para obtener el booleano: "+ persona1.isEliminado);
        
    }
    
}
