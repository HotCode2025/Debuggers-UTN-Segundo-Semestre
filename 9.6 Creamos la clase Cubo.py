class cubo:
    def calcular_volumen(self,ancho,alto,profundidad):
        self.ancho = ancho
        self.alto=alto
        self.profundida=profundidad

        def calcular_volumen(self,ancho,alto,profundidad):
            return self.ancho *self.alto* self.profundidad
        def __init__(self, ancho, alto, profundidad):
            self.ancho = ancho
            self.alto = alto
            self.profundidad = profundidad

        def calcular_volumen(self):
            return self.ancho * self.alto * self.profundidad

ancho=float(input("introduce el ancho del cubo: ")) 
alto=float(input("Introduce el alto del cubo: "))
profundidad=float(input("Introduce la profundidad del cubo: "))

cubo1 = cubo(ancho, alto, profundidad)
volumen = cubo1.calcular_volumen()
print("El volumen del cubo es: ", volumen)
