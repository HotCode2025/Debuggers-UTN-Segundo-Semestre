# Clase Empleado
class Empleado:
    def __init__(self, nombre, sueldo):
        self._nombre = nombre
        self._sueldo = sueldo

    def __str__(self): # sobreescribir metodo
        return f'Empleado: [Nombre: {self._nombre}, Sueldo: {self._sueldo}]'

# Clase Gerente
class Gerente(Empleado):
    def __init__(self, nombre, sueldo, departamento):
        super().__init__(nombre, sueldo)
        self._departamento = departamento

    def __str__(self): # sobreescribir metodo
        return f'Gerente: [Departamento: {self._departamento}] {super().__str__()}'

# -------------------------------------------------------------------------------------
# Test polimorfismo

def imprimir_detalles(objeto):
    print(objeto) # De manera indirecta llamamos al metodo str de la clase empleado o gerente
    print(type(objeto)) # nos devuelvo el tipo de dato que recibe

empleado = Empleado('Ariel', 50000.00)
imprimir_detalles(empleado)