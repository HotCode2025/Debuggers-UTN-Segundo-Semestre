# Clase 7 POO Parte 2
#
# 9.9 Encapsulamiento Parte 2

class Persona:
    def __init__(self, nombre, apellido, dni, edad, *args, **wkargs):
        self.nombre = nombre
        self.apellido = apellido
        self.edad = edad
        self._dni = dni # Atributo encapsulado
        self.args = args
        self.wkargs = wkargs

    def mostar_detalle(self):
        print(f'La clase Persona tiene los siguientes datos: {self.nombre} {self.apellido} {self.edad}, {self._dni}, la direccion es: {self.args}, los datos importantes son: {self.wkargs} ')


persona3 = Persona('Rogelio', 'Romero', 12345678, 22, 'Telefono', '5495512345', 'Calle Lopez', 823, 'Manzana', 77, 'Casa', 18, Altura=1.83, Peso=105, CFavorto='Azul', Auto='Citroen', Modelo=2021)

persona3.mostar_detalle()

