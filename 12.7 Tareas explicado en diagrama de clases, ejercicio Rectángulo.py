# Clase color
class Color:
    def __init__(self, color):
        self.__color = color

    def get_color(self):
        return self.__color

#set

    def set_color(self, color):
        self.__color = color

    def __str__(self):
        return f'Color: {self.__color}'

# Clase figuraGeometrica

class FiguraGeometrica:
    def __init__(self, ancho, alto):
        self.__ancho = ancho
        self.__alto = alto

    def get_ancho(self):
        return self.__ancho
    
    def get_alto(self):
        return self.__alto

#set

    def set_ancho(self, ancho):
        self.__ancho = ancho

    def set_alto(self, alto):
        self.__alto = alto

    def __str__(self):
        return f'FiguraGeometrica Ancho: {self, __ancho} y Alto: {self,__alto}'

# Clase Cuadrado (hereda de FiguraGeometrica y Color)
class Cuadrado(FiguraGeometrica, Color):
    def __init__(self, lado, color):
        FiguraGeometrica.__init__(self, lado, lado)
        Color.__init__(self, color)

    def calcular_area(self):
        return self.get_ancho() * self.get_alto()

    def __str__(self):
        return f'Cuadrado [Lado: {self.get_ancho()}, {Color.__str__(self)}, Área: {self.calcular_area()}]'


# Clase Rectangulo (hereda de FiguraGeometrica y Color)
class Rectangulo(FiguraGeometrica, Color):
    def __init__(self, ancho, alto, color):
        FiguraGeometrica.__init__(self, ancho, alto)
        Color.__init__(self, color)

    def calcular_area(self):
        return self.get_ancho() * self.get_alto()

    def __str__(self):
        return f'Rectángulo [Ancho: {self.get_ancho()}, Alto: {self.get_alto()}, {Color.__str__(self)}, Área: {self.calcular_area()}]'


# Clase de prueba
if __name__ == '__main__':
    print("PRUEBA DE FIGURAS GEOMÉTRICAS")

    cuadrado1 = Cuadrado(5, "Rojo")
    cuadrado2 = Cuadrado(10, "Azul")
    rectangulo1 = Rectangulo(4, 8, "Verde")
    rectangulo2 = Rectangulo(6, 3, "Amarillo")

    figuras = [cuadrado1, cuadrado2, rectangulo1, rectangulo2]

    for figura in figuras:
        print(figura)