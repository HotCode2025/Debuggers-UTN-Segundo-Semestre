  //13.5 Comenzamos con la clase Orden: Parte 3
    public double calcularTotal(){
        double total = 0; //Variable temporal
        for (int i = 0; i < this.contadorProductos; i++){
//            Producto producto = this.productos[i];
//            total += producto.getPrecio();
             total += this.productos[i].getPrecio();
        }
        return total;
    }