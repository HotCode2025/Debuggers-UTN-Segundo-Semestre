# Clase Orden 
class Orden:
    contador_ordenes = 0 # Variable de clase

    def __init__(self, productos):
        Orden.contador_ordenes += 1 # Aumento para la variable de clase
        self._id_orden = contador_ordenes # Asignacion desde la variable de clase
        self._productos = list(productos)

    def agregar_producto(self, producto)
        self._producotos.append(producto) # Agregar nuevo producto

