# Figuras geometricas

class FiguraGeometrica:
    def __init__(self, ancho, alto):
        self.ancho = ancho
        self.alto = alto

class Color:
    def __init__(self, color):
        self.color = color

class Cuadrado(FiguraGeometrica, Color):
    def __init__(self, lado, color):
        FiguraGeometrica.__init__(self, lado, lado)
        Color.__init__(self, color)

    def calcular_area(self):
        return self.alto * self.ancho

# Test figura geometrica

cuadrado1 = Cuadrado(5, 'Azul')
print (cuadrado1.ancho)
print (cuadrado1.alto)

print(f'Calculo del area del cuadrado: {cuadrado1.calcular_area()}')

# Metodo MRO = Method Resolution Order

print(Cuadrado.mro())
