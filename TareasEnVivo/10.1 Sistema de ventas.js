// ------------------------------------------------------------------------------
// Clase 10 Sistema de Ventas
// ------------------------------------------------------------------------------
// 10.1 

class Producto {
    static contadorProductos = 0; // Atributo estatico

    constructor(nombre, precio) {
        this.idProducto = ++Producto.contadorProductos; 
        this._nombre = nombre;
        this._precio = precio;
    }

    getIdProducto() {
        return this.idProducto;
    }
    getNombre() {
        return this._nombre;
    }
    getPrecio() {
        return this._precio;
    }

    setNombre(nombre) {
        this._nombre = nombre;
    }
    setPrecio(precio) {
        this._precio = precio;
    }

    // Metodo toString()
    toString() {
        return `[ID Producto: ${this.idProducto}, Nombre: ${this._nombre}, Precio: $${this._precio.toFixed(2)}]`;
    }
}

// -------------------------------------------------------------

class Orden {
    static contadorOrdenes = 0; // Atributo estatico
    static MAX_PRODUCTOS = 5; // Constante

    constructor() {
        this.idOrden = ++Orden.contadorOrdenes;
        this.productos = []; // Array para los objetos "Producto"
        this.contadorProductosAgregados = 0;
    }
    
    // Agregar un Producto a la Orden
    agregarProducto(producto) {
        if (this.productos.length < Orden.MAX_PRODUCTOS) {
            this.productos.push(producto);
            this.contadorProductosAgregados++;
            console.log(`Producto "${producto.getNombre()}" agregado a la Orden ${this.idOrden}.`);
        } else {
            console.log(`No se pueden agregar mas productos a la orden ${this.idOrden}. El maximo es ${Orden.MAX_PRODUCTOS}.`);
        }
    }

    // Calcula el monto total de la orden
    calcularTotal() {
        let totalVenta = 0;
        for (let producto of this.productos) {
            totalVenta += producto.getPrecio();
        }
        return totalVenta;
    }

    // Mostrar orden
    mostrarOrden() {
        let detalleProductos = '';
        for (let producto of this.productos) {
            detalleProductos += '- ' + producto.toString() + '\n';
        }

        console.log(`\n===========================================================`);
        console.log(`Orden ID: ${this.idOrden}`);
        console.log(`Total Productos: ${this.contadorProductosAgregados}`);
        console.log(`Productos:\n${detalleProductos}`);
        console.log(`TOTAL A PAGAR: $${this.calcularTotal().toFixed(2)}`);
        console.log(`\n===========================================================`);
    }
}

// -------------------------------------------------------------
// Creamos los productos
const raton = new Producto("Mouse Genius", 12000);
const teclado = new Producto("Teclado Genius", 15000);
const monitor = new Producto("Monitor 24 pulgadas", 150000);
const webcam = new Producto("Webcam HD", 20000);
const microfono = new Producto("Microfono Gamer", 18200);
const silla = new Producto("Silla Gamer", 350000);

// Creamos la orden numero 1
const orden1 = new Orden(); 
orden1.agregarProducto(raton);
orden1.agregarProducto(teclado);
orden1.agregarProducto(monitor);
orden1.agregarProducto(webcam);
orden1.agregarProducto(microfono);

// Intento de agregar un sexto producto (debería fallar por el MAX_PRODUCTOS = 5)
orden1.agregarProducto(silla); 

orden1.mostrarOrden();

// Creamos la orden numero 2
const orden2 = new Orden();

orden2.agregarProducto(raton); 
orden2.agregarProducto(teclado);
orden2.agregarProducto(silla);

orden2.mostrarOrden();

