# Clase 9 POO Parte 5
# 12.2 Creamos las clases padres
class FiguraGeometrica:
    def __init__(self, ancho, alto):
        self._ancho = ancho
        self._alto = alto

    @property
    def ancho(self):
        return self._ancho

    @ancho.setter
    def ancho(self, ancho):
        self._ancho = ancho

    @property
    def alto(self):
        return self._alto

    @alto.setter
    def alto(self, alto):
        self._alto = alto

    def __str__(self):
        return f'FiguraGeometrica Ancho: {self._ancho}, Alto: {self._alto}'

# Clase 9 POO Parte 5
# 12.2 Creamos las clases padres
class Color:
    def __init__(self, color):
        self._color = color

    @property
    def color(self):
        return self._color

    @color.setter
    def color(self, color):
        self._color = color

    def __str__(self):
        return f'Color [color: {self._color}]'

# 12.3 Creamos la clase hija Cuadrado
from FiguraGeometrica import FiguraGeometrica
from Color import Color

class Cuadrado(FiguraGeometrica, Color):
    def __init__(self, lado, color):
        #super.__init__(lado)
        FiguraGeometrica.__init__(self, lado, lado)
        Color.__init__(self, color)

    def calcular_area(self):
        return self.alto * self.ancho

    def __str__(self):
        return f'{FiguraGeometrica.__str__(self)} {Color.__str__(self)}'

# 12.8 Tarea 1 y tarea 2 Creación de la clase Rectángulo
from Color import Color
from FiguraGeometrica import FiguraGeometrica


class Rectangulo(FiguraGeometrica, Color):
    def __init__(self, ancho, alto, color):
        FiguraGeometrica.__init__(self, ancho, alto)
        Color.__init__(self, color)

    def calcular_area(self):
        return self.ancho * self.alto

    def __str__(self):
        return f'{FiguraGeometrica.__str__(self)} {Color.__str__(self)}'


# 12.4 Creamos la clase para testear nuestro código
from Cuadrado import Cuadrado
from Rectangulo import Rectangulo

cuadrado1 = Cuadrado(5, 'Azul')
print(cuadrado1.ancho)
print(cuadrado1.alto)
print(f"Cálculo del área del cuadrado: {cuadrado1.calcular_area()}")

# 12.6 Metodo MRO: Method Resolution Order
# MRO = Method Resolution Order
print(Cuadrado.mro())

# 12.8 Tarea 1 y tarea 2 Creación de la clase Rectángulo
print(cuadrado1)

rectangulo1 = Rectangulo(3, 8, 'verde')
print(f'El calculo del area del rectangulo: {rectangulo1.calcular_area()}')
print(rectangulo1)


