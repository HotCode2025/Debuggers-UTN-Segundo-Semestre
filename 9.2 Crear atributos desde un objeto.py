# Clase 7 POO Parte 2
#
# 9.2 Crear atributos desde un objeto

class Persona:
    def __init__(self, nombre, apellido, edad):
        self.nombre = nombre
        self.apellido = apellido
        self.edad = edad
    def mostar_detalle(self):
        print(f'Persona: {self.nombre} {self.apellido} {self.edad} ')


print(type(Persona))
print(Persona)

persona1 = Persona('Arial', 'Betancud', 40)

print(persona1.nombre)
print(persona1.apellido)
print(persona1.edad)
print(f'El obejeto1 de la clase persona: {persona1.nombre} {persona1.apellido} {persona1.edad} ')

persona2 = Persona('Osvaldo', 'Giordanini', 45)

print(f'El obejeto2 de la clase persona: {persona2.nombre} {persona2.apellido} {persona2.edad} ')

persona1.nombre = 'Liliana'
persona1.apellido = 'Buccella'
persona1.edad = '40'

print(f'El obejeto1 modificado de la clase persona: {persona1.nombre} {persona1.apellido} {persona1.edad} ')

# Los atributos son caracteristicas
# Los metodos son el comportamiento que van a tener los objetos (acciones)

persona1.mostar_detalle() 
persona2.mostar_detalle()

Persona.mostar_detalle(persona1)

persona1.telefono = '549555123456'

print(f'Este es el numero de telefono de {persona1.nombre} {persona1.telefono}')


