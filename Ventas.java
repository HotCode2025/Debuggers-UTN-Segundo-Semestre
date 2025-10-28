package SistemaDeVentas;

/*
 * @author Debuggers UTN
*/

import java.util.Scanner;
import SistemaDeVentas.ClientesDAO; 
import SistemaDeVentas.ProductosDAO; 
import SistemaDeVentas.UtilDAO; 

public class Ventas {

    // Inicializamos UtilDAO para usar sus métodos
    private static final UtilDAO utilDAO = new UtilDAO(); 
    // Inicializamos Clientes
    private static final ClientesDAO clientesDAO = new ClientesDAO();
    // Inicializamos ProductosDAO
    private static final ProductosDAO productosDAO = new ProductosDAO();

    // Definimos el límite máximo de items en una venta para los arrays
    private static final int MAX_ITEMS = 50; 
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
<<<<<<< HEAD
                
=======
        
        
>>>>>>> 1fc7ee89d3ea41b9c4604b7ee7db5d57697361ea
        // Almacenan los datos de los ítems de la venta (máx. 50)
        int[] cantidadProductoVenta = new int[MAX_ITEMS]; // Cantidad
        int[] productoVenta = new int[MAX_ITEMS];         // ID del Producto
        double[] precioVenta = new double[MAX_ITEMS];     // Precio de Venta unitario (usamos double)
<<<<<<< HEAD
        String[] productoNombreVenta = new String[MAX_ITEMS];

/*        
        renglon[] = int columna1, int cloumna, double columna, String columna4
                
        renglon[nroVenta][columna1] =  
        renglon[nroVenta][columna2] =  
        renglon[nroVenta][columna3] =  
        renglon[nroVenta][columna4] =  
*/

=======
        
>>>>>>> 1fc7ee89d3ea41b9c4604b7ee7db5d57697361ea
        int opcion1, i, nroVenta, nroCliente, nroProducto;
        String salir, columna1, columna2, columna3, columna4;
        float totalVenta;
        boolean existe;
        String textoMostrar;
        
        int totalClientes = utilDAO.totalRegistros("clientes");
        
        existe = false;
        do {
            System.out.println("+------------------------------+");
            System.out.println("|        Modulo de ventas      |");
            System.out.println("+------------------------------+");
            System.out.println(" ");
            System.out.println(" Ingrese el numero de cliente: ");
            nroCliente = entrada.nextInt();
            if (nroCliente < 1 || nroCliente > totalClientes) {
                System.out.println("El cliente numero " + nroCliente + " no existe.");
            } else {
                existe = true;
            }
        } while (existe == false);
        
        Clientes cliente = clientesDAO.buscarPorId(nroCliente);
        
        nroVenta = 0;
        do {
            System.out.println("+------------------------------+");
            System.out.println("|        Modulo de ventas      |");
            System.out.println("+------------------------------+");
            System.out.println(" ");
            System.out.println("Nombre Cliente: " + cliente.getNombre());
            System.out.println("Domicilio Cliente: " + cliente.getDireccion());

            if (nroVenta != 0) {
                System.out.println(" ");
                System.out.println("Productos en el pedido: ");
                for (i = 0; i < nroVenta; i++) {
                    System.out.println(
                        (i + 1) + 
                        " . " + 
//                        productoNombre[productoVenta[i]] + 
                        " -Cantidad: " + 
//                        cantidadProductoVenta[i]
                        " "
                    ); 
                }
            }
            System.out.println(" ");
            
            int totalProductos = utilDAO.totalRegistros("productos");
            
            do {
                System.out.println("Numero Producto(0(cero) para finalizar)");
                nroProducto = entrada.nextInt();
                if (nroProducto >= 1 && nroProducto <= totalProductos) {
                    nroVenta++;
                    
                    Productos producto = productosDAO.buscarPorId(nroProducto);
                    productoVenta[nroVenta] = nroProducto;
                    precioVenta[nroVenta] = producto.getPrecioVenta();
                    
                    System.out.print("Ingrese la cantidad de: " + producto.getNombre() + ": ");
                    cantidadProductoVenta[nroVenta] = entrada.nextInt();
                    entrada.nextLine();
                } else {
                    if (nroProducto != 0) {
                        System.out.println("El producto número " + nroProducto + "no existe. Verifique");
                    }
                }
            } while (nroProducto != 0 && nroProducto != 14);
            do{
                System.out.println(" ");
                System.out.println("Confirma que desea finalizar (Digite S o N): ");
                salir = entrada.nextLine();
                
            }while(!(salir.equalsIgnoreCase("S")|| salir.equalsIgnoreCase("N")));
        }while(!(salir.equalsIgnoreCase("S")));
        
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                                  |R|                                     |");
        System.out.println("| DISTRIBUIDORA DEBUGGERS UTN S.A.S                                        |");
        System.out.println("| Dirección: Las Malvinas 810 - El Cerrito- San Rafael- Mendoza            |");
        System.out.println("+--------------------------------------------------------------------------+");
        textoMostrar = "Nombre Cliente: " + cliente.getNombre();


        while(textoMostrar.length() < 66){
            textoMostrar = textoMostrar+" ";
        }
        System.out.println("| "+ textoMostrar +"|");
        System.out.println("| Domicilio Cliente: " + cliente.getDireccion());
        System.out.println("|                                                                          |");
        System.out.println("| Cantidad | Producto                       | Precio Unit. |     Total     |");
        System.out.println("+--------------------------------------------------------------------------+");
        
        textoMostrar = "Nombre Cliente " + cliente.getNombre();
        while (textoMostrar.length() < 66){
            textoMostrar = textoMostrar+" ";
        }
        totalVenta = 0;
<<<<<<< HEAD

=======
/*
>>>>>>> 1fc7ee89d3ea41b9c4604b7ee7db5d57697361ea
        for(i = 0; i <= nroVenta; i++) {
            columna1 = Integer.toString(cantidadProductoVenta[i]);
            while (columna1.length() < 6){
                columna1 = (" "+columna1);
            }
            columna2 = productoNombre[productoventa[i]];
            while (columna2.length() < 30){
                columna2 = columna2 + " ";
            }
            columna3 = Integer.toString(precioVenta[i]);
            while (columna3.length() < 10){
                columna3 = " "+columna3;
            }
            columna4 = Integer.toString(cantidadProductoVenta[i]*precioVenta[i]);
            while (columna4.length() < 10){
                columna4 = " "+columna4;
            }
            System.out.println("| "+columna1+"   |"+columna2+" | "+columna3+"   | "+columna4+"    |");
            totalVenta = totalVenta + (cantidadProductoventa[i] * precioVenta[i]);
        }
        System.out.println("+----------+--------------------------------+--------------+---------------+");
        System.out.println("|                                                                          |");
        System.out.println("|                                      El total de la venta es: $ "+totalVenta);
        System.out.println("|                                                                          |");
        System.out.println("+----------+--------------------------------+--------------+---------------+");
        
        System.out.println("Presione <enter> para continuar: ");
        salir = entrada.nextLine();
<<<<<<< HEAD
    
=======
     
*/
>>>>>>> 1fc7ee89d3ea41b9c4604b7ee7db5d57697361ea
    }
}
