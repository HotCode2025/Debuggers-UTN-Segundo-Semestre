class Producto:
    contador_productos = 0 #Variable de clase

    def __init__(self,nombre,precio):
        Producto.contador_productos += 1 #aumento para la variable de clase
        self._id_producto = Producto.contador_productos #Asignacion desde variable de clase
        self._nombre = nombre
        self._precio = precio
    #Metodos Setters and Getters
    @property
    def nombre(self):
        return self._nombre

    @nombre.setter
    def nombre(self,nombre):
        self._nombre = nombre

    @property
    def precio(self):
        return self._precio

    @precio.setter
    def precio(self,precio):
        self._precio = precio
    #Modificamos desde los str
    def __str__(self):
        return f"Id producto: {self._id_producto}, Nombre: {self._nombre}, Precio: {self._precio}"

if __name__==" main  ":
    producto1 = Producto("Camiseta", 100.00)
    producto2 = Producto("Pantalon", 150.00)
