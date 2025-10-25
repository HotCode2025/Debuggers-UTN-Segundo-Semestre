from Cuadrado import Cuadrado
from Rectangulo import Rectangulo

print('Creando un objeto de la clase Cuadrado'.center(50,'-'))
cuadrado1 = Cuadrado(5, 'Azul')
cuadrado1.alto = 7
print(cuadrado1.ancho)
print(cuadrado1.alto)   
print(f'Cálculo del área del cuadrado: {cuadrado1.calcular_area()}')

#print(Cuadrado.mro())  # Muestra el orden de resolución de métodos (Method Resolution Order)

#print(cuadrado1)  # Muestra la representación en cadena del objeto Cuadrado

print('Creando un objeto de la clase Rectángulo'.center(50,'-'))
rectangulo1 = Rectangulo(4, 6, 'Rojo')
rectangulo1.ancho = 8
print(f'Cálculo del área del rectángulo: {rectangulo1.calcular_area()}')
print(rectangulo1)  # Muestra la representación en cadena del objeto Rectángulo

#figura1=FiguraGeometrica(5, 7) no se puede intanciar por que FiguraGeometrica es abstracta