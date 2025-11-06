from Cuadrado import Cuadrado
from Rectangulo import Rectangulo

print("creacion de objeto clase cuadrado".center(50,"_"))
cuadrado1 = Cuadrado(5,"azul")
print(cuadrado1.ancho)
print(cuadrado1.alto)
print(f"Calculo del area del cuadrado: {cuadrado1.calcular_area()}")

#MRO = method resolution order
print(Cuadrado.mro())

print(cuadrado1)

print("creacion del objeto clase rectangulo".center(50,"_"))


rectangulo1 = Rectangulo(3,8,"verde")
print(f"calculo del area del rectangulo: {rectangulo1.calcular_area()}")
print(rectangulo1)