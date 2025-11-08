# Clase Producto

class Producto:
    contador_productos = 0 # Variable de clase

    def __init__(self, nombre, precio):
        Producto.contador_productos += 1 # Aumento para la variable de clase
        self._id_producot = contador_productos # Asignacion desde la variable de clase
        self._nombre = nombre
        self._precio = precio

    @property
    def nombre(self): # Metodo get
        return self._nombre
    
    @nombre.setter
    def nombre(self, nombre): # Metodo set
        self._nombre = nombre

    @property
    def precio(self): # Metodo get
        return self._precio
    
    @precio.setter
    def precio(self, precio): # Metodo set
        self._precio = precio

    def __str__(self): # sobreescribir metodo
        return f'ID Producto: {self._id_producto}, Nombre: {self._nombre}, Precio: {self._precio}]'

# clase Orden
class Orden:
    contador_ordenes = 0 # Variable de clase

    def __init__(self, productos):
        Orden.contador_ordenes += 1 # Aumento para la variable de clase
        self._id_orden = contador_ordenes # Asignacion desde la variable de clase
        self._productos = list(productos)

    def agregar_producto(self, producto)
        self._producotos.append(producto) # Agregar nuevo producto

    def calcular_total(self):
        total = 0 # Variable temporal para almacenar el total temporal
        for producto in self.productos:
            total += producto.precio
        return total

    def __init__(self):
        productos_str = ''
        for producto in self.productos:
            productos_str += producto.__str__() + ' | '
        return f'Orden: {self._id_orden}, \nProducto: {productos_str}'


# ---------------------------------------------------------------------
# Probamos las clases Producto y Ordenes

producto1 = Producto('Camiseta', 100.00)
producto2 = Producto('Pantalon', 150.00)
producto3 = Producto('Camisa', 120.00)
producto4 = Producto('Corbata', 150.00)
producto5 = Producto('Saco', 250.00)
producto6 = Producto('Medias', 45.00)

productos1 = [producto1, producto2] # Lista deproductos
orden1 = Oren(productos1) # El primer objeto orden pasando la lista de productos
orden1.agregar_producto(producot5) # Agregamos productos extras a la lista
orden1.agregar_producto(producot3)
print(orden1)
print(f'Total de la orden1: {orden1.calcular_total()}')

productos2 = [producto3, producto4] 
orden2 = Orden(productos2)
orden2.agregar_producto(producot6)
orden2.agregar_producto(producot2)
print(orden2)
print(f'Total de la orden2: {orden2.calcular_total()}')

