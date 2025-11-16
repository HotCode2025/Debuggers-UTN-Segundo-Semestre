class Persona:  # Creamos una clase

    def __init__(self, nombre, apellido, dni, edad, *args, **kwargs):
        self.nombre = nombre
        self.apellido = apellido
        self._dni = dni #Este atributo esta encapsulado de una manera sugerida
        self.edad = edad
        self.args = args
        self.kwargs = kwargs

    def mostrar_detalle(self):
        print(f'La clase Persona tiene los sig datos: {self.nombre} {self.apellido} {self._dni} {self.edad}, la direccion es: {self.args}, los datos son: {self.kwargs}')


# Crear objetos y utilizar la clase
persona1 = Persona('Ariel', 'Betancud', 406456, 40)
print(f'el objeto1 de la clase persona es: {persona1.nombre} {persona1.apellido} Su edad es: {persona1.edad}')

persona2 = Persona('Osvaldo', 'Giordanini', 45456456, 45)
print(f'El objeto2 de la clase persona es: {persona2.nombre} {persona2.apellido} Su edad es: {persona2.edad}')

persona1.nombre = 'Liliana'
persona1.apellido = 'Buccella'
persona1.edad = 40
print(f'el objeto1 de la clase persona es: {persona1.nombre} {persona1.apellido} Su edad es: {persona1.edad}')

persona1.mostrar_detalle()
persona2.mostrar_detalle()

persona1.telefono = '2611234567'
print(f'Este es el telefono de {persona1.nombre}: {persona1.telefono}')
# print(persona2.telefono)  # Esto daría error porque persona2 no tiene el atributo telefono

persona3 = Persona('Carlos', 'Gomez', 5054654 , 50, 'Calle Falsa 123', 'Ciudad', pais='Argentina', profesion='Ingeniero')
persona3.mostrar_detalle()
# print(persona3._dni) # Podemos acceder pero no es recomendable