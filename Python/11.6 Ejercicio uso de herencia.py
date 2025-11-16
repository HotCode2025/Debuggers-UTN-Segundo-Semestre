'''
Definir una clase padre llamada vehiculo y dos clases hijas llamadas
Auto y Bicicleta, las cuales heredan de la clase padre Vehiculo. La clase
padre debe tener los siguientes atributos y métodos:

Vehiculo (Clase padre):
-Atributos: Color, ruedas
-Metodos: __init__(color, ruedas) y __str__()

Auto (Clase hija de Vehiculo):
-Atributos: velocidad (km/h)
-Metodos: __init__(color, ruedas, velocidad) y __str__()

Bicicleta (Clase hija de Vehiculo):
-Atributos: tipo (urbana, montaña, etc.)
-Metodos: __init__(color, ruedas, tipo) y __str__()

Crear un objeto de cada clase
'''

class Vehiculo:
    def __init__(self, color, ruedas):
        self._color = color
        self._ruedas = ruedas

    def __str__(self):
        return f'De color: {self._color}, Cantidad de ruedas: {self._ruedas}'

class Auto(Vehiculo):
    def __init__(self, color, ruedas, velocidad):
        super().__init__(color, ruedas)
        self._velocidad = velocidad

    def __str__(self):
        return f'{super().__str__()}, Velocidad: {self._velocidad} Km/h.'

class Bicicleta(Vehiculo):
    def __init__(self, color, ruedas, tipo):
        super().__init__(color, ruedas)
        self._tipo = tipo

    def __str__(self):
        return f'Bicicleta: {super().__str__()}, Tipo (Urbana, montaña, etc.): {self._tipo}.'

vehiculo1 = Vehiculo('rojo', 4)
print(vehiculo1)

auto1 = Auto('Azul', 4, 180)
print(auto1)

bicicleta1 = Bicicleta('Verde', 2, 'Mountain-bike')
print(bicicleta1)