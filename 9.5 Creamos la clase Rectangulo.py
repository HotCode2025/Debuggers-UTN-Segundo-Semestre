class Rectangulo:
    def __init__(self,base,altura):
        self.base = base
        self.altura = altura

    def calcular_area(self):
        return self.base * self.altura

base = float(input("Digite el valor de la base: "))
altura = float(input("Digite el valor de la altura: "))
rectangulo1 = Rectangulo(base,altura)
print(f"El Area del rectangulo es: {rectangulo1.calcular_area()}")