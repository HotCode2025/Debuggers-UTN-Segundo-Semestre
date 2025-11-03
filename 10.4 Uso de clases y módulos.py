# Clase 8 POO Parte 3 Métodos set & get 
#
# 10.4 Uso de clases y módulos

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

# ----------------------------------------------------------------------------------------

persona = Persona('Lionel', 'Messi', 35)
print(persona.mostar_detalle())
