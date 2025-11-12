//13.6 Comenzamos con la clase Orden: Parte 4
    public void mostrarOrden() {
        System.out.println("Id Orden: "+idOrden);
        double totalOrden = this.calcularTotal();
        System.out.println("El total de la orden es: $"+totalOrden);
        System.out.println("Productos de la orden: ");
        for(int i = 0; i < this.contadorProductos; i++){
            System.out.println(this.productos[i]);
        }
    }