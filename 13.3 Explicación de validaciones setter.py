# ----------------------------------------------------------------------------------------
# clase FiguraGeometrica
class FiguraGeometrica:
    def __init__(self, ancho, alto):
        if self._validar_valores(ancho):
            self._ancho = ancho
        else:
            print (f'Valor erroneo para el acho: {ancho}')
        if self._validar_valores(alto):
            self._alto = alto
        else:
            print (f'Valor erroneo para el alto: {alto}')

    @property
    def ancho(self):
        return self._ancho
    
    @property
    def alto(self):
        return self._alto
    
    @ancho.setter
    def ancho(self, ancho):
        if self._validar_valores(ancho):
            self._ancho = ancho
        else:
            print (f'Valor erroneo para el ancho: {ancho}')

    @alto.setter
    def alto(self, alto):
        if self._validar_valores(alto):
            self._alto = alto
        else:
            print (f'Valor erroneo para el alto: {alto}')


    def __str__(self):
        return f'FiguraGeometrica [Ancho: {self._ancho}, Alto: {self._alto}]'
    
    def _validar_valores(self, valor): # Metodo encapsulado
        return True if 0 < valor < 10 else False

    
# ----------------------------------------------------------------------------------------
# clase Color
class Color:
    def __init__(self, color):
        self._color = color

    @property
    def color(self):
        return self.color
    
    @color.setter
    def ancho(self, color):
        self._color = color

    def __str__(self):
        return f'Color [Color: {self._color}]'

# ----------------------------------------------------------------------------------------
# clase Cuadrado
class Cuadrado(FiguraGeometrica, Color):
    def __init__(self, lado, color):
        FiguraGeometrica.__init__(self, lado, lado)
        Color.__init__(self, color)

    def calcular_area(self):
        return self.alto * self.ancho
    
    def __str__(self):
        return f'{FiguraGeometrica.__str__(self)} {Color.__str__(self)}'

# ----------------------------------------------------------------------------------------
# clase Rectangulo
class Rectangulo(FiguraGeometrica, Color):
    def __init__(self, alto, ancho, color):
        FiguraGeometrica.__init__(self, alto, ancho)
        Color.__init__(self, color)

    def calcular_area(self):
        return self.alto * self.ancho
    
    def __str__(self):
        return f'{FiguraGeometrica.__str__(self)} {Color.__str__(self)}'

# ----------------------------------------------------------------------------------------
# Test figura geometrica
print(' ')

print('Creacion de objeto clase Cuadrado'.center(50, '-'))
cuadrado1 = Cuadrado(5, 'Azul')
print (cuadrado1.ancho)
print (cuadrado1.alto)
print(f'Calculo del area del cuadrado: {cuadrado1.calcular_area()}')

cuadrado1.alto = -10
print(f'Calculo del area del cuadrado: {cuadrado1.calcular_area()}')


# Metodo MRO = Method Resolution Order
print(Cuadrado.mro())

print()
print(cuadrado1)

rectangulo1 = Rectangulo(3, 8, 'Verde')
print()

print(f'Calculo del area del rectangulo: {rectangulo1.calcular_area()}')

print (rectangulo1)
