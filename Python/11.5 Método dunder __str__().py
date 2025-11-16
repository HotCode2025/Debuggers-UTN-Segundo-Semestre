# Método dunder __str__()

# clase clientePersona

class Persona:
    def __init__(self, nombre, apellido, edad):
        self._nombre = nombre
        self._apellido = apellido
        self._edad = edad
    def mostar_detalle(self):
        print(f'Los datos a mostrar son: {self._nombre} {self._apellido} {self._edad} ')

    @property
    def nombre(self): # Metodo get
        return self._nombre
    
    @nombre.setter
    def nombre(self, nombre): # Metodo set
        self._nombre = nombre

    @property
    def apellido(self): # Metodo get
        return self._apellido
    
    @apellido.setter
    def apellido(self, apellido): # Metodo set
        self._apellido = apellido

    @property
    def edad(self): # Metodo get
        return self._edad
    
    @edad.setter
    def edad(self, edad): # Metodo set
        self._edad = edad

    def __str__(self): # sobreescribir metodo
        return f'Persona: [Nombre: {self._nombre}, Edad: {self._edad}]'


# Clase Empleado
class Empleado(Persona): # Esta clase es hija de la clase Persona
    def __init__(self, nombre, edad, sueldo):
        super().__init__(nombre, edad)
        self._sueldo = sueldo

    @property
    def sueldo(self):
        return self._sueldo

    @sueldo.setter
    def sueldo(self, sueldo):
        self._sueldo = sueldo

    def __str__(self): # sobreescribir metodo
        return f'Empleado: [Sueldo: {self._sueldo}] {super().__str__}'

# ---------------------------------------------------------------------
# Objeto clase Persona
persona1 = Persona('Osvaldo', 40)
print(persona1)

# Objeto clase Empleado
empleado1 = Empleado('Pablo', 23, 57000)
print(empleado1)
