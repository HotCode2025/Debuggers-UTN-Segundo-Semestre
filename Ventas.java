package SistemaDeVentas;

import java.util.Scanner;

/**
 *
 * @author Debuggers UTN
 */
public class Ventas {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int cantidadProductoVenta, productoVenta;
        float precioVenta;
        int opcion1, i, totalClientes, totalProductos, nroVenta, nroCliente, nroProducto;
        String salir, columna1, columna2, columna3, columna4;
        float totalVenta;
        boolean existe;
        String textoMostrar;
        

        existe = false;
        do {
            System.out.println("+------------------------------+");
            System.out.println("|        Modulo de ventas      |");
            System.out.println("+------------------------------+");
            System.out.println(" ");
            System.out.println(" Ingrese el numero de cliente: ");
            nroCliente = entrada.nextInt();
            if (nroCliente < 1 || nroCliente > totalClientes) {
                System.out.println("El cliente numero " + nroCliente + " no existe. Presione Enter para continuar");
            } else {
                existe = true;
            }
        }  
        
        nroVenta = 0;
        do {
            System.out.println("+------------------------------+");
            System.out.println("|        Modulo de ventas      |");
            System.out.println("+------------------------------+");
            System.out.println(" ");
            System.out.println("Nombre Cliente: " + clienteNombre[nroCliente]);
            System.out.println("Domicilio Cliente: " + domicilioCliente[nroCliente]);

            if (nroVenta != 0) {
                System.out.println(" ");
                System.out.println("Productos en el pedido: ");
                for (i = 0, i < nroVenta, i++ ) {
                    System.out.println((i + 1) + " . " + productoNombre[productoVenta[i + 1]] + " -Cantidad: " + cantidadProductoVenta[i + 1]);
                }
            }
            System.out.println(" ");
            do {
                System.out.println("Numero Producto(0(cero) para finalizar)");
                nroProducto = entrada.nextInt();
                if (nroProducto >= 1 && nroProducto <= totalProductos) {
                    nroVenta++;
                    productoVenta[nroVenta] = nroProducto;
                    precioVenta[nroVenta] = productoPrecio[nroProducto];
                    System.out.println("Ingrese la cantidad de: " + productoNombre[nombreProducto] + ": ");
                    cantidadProductoVenta[nroVenta] = entrada.nextInt();
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
        
    }
}
