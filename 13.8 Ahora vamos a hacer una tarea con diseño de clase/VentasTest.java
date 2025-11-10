package ventas;

public class VentasTest {
    public static void main(String[] args) {

        // Creamos 10 productos
        Producto producto1 = new Producto("Monitor", 25000);
        Producto producto2 = new Producto("Teclado", 8000);
        Producto producto3 = new Producto("Mouse", 5000);
        Producto producto4 = new Producto("Silla Gamer", 65000);
        Producto producto5 = new Producto("Parlantes", 12000);
        Producto producto6 = new Producto("Auriculares", 7000);
        Producto producto7 = new Producto("Notebook", 350000);
        Producto producto8 = new Producto("Webcam", 10000);
        Producto producto9 = new Producto("Impresora", 45000);
        Producto producto10 = new Producto("Microfono", 15000);

        // Creamos primera orden y agregamos productos
        Orden orden1 = new Orden();
        orden1.agregarProducto(producto1);
        orden1.agregarProducto(producto2);
        orden1.agregarProducto(producto3);
        orden1.mostrarOrden();

        // Creamos segunda orden y agregamos otros productos
        Orden orden2 = new Orden();
        orden2.agregarProducto(producto4);
        orden2.agregarProducto(producto5);
        orden2.agregarProducto(producto6);
        orden2.agregarProducto(producto7);
        orden2.agregarProducto(producto8);
        orden2.agregarProducto(producto9);
        orden2.agregarProducto(producto10);
        orden2.mostrarOrden();
    }
}