# Clase 6 POO Parte 1
#
# 8.5 Referencias de memoria de objetos con el Debug

class Persona:
    def __init__(self, nombre, apellido, edad):
        self.nombre = nombre
        self.apellido = apellido
        self.edad = edad

print(type(Persona))
print(Persona)

persona1 = Persona('Arial', 'Betancud', 40)

print(persona1.nombre)
print(persona1.apellido)
print(persona1.edad)
print(f'El obejeto1 de la clase persona: {persona1.nombre} {persona1.apellido} {persona1.edad} ')

persona2 = Persona('Osvaldo', 'Giordanini', 45)
print(f'El obejeto2 de la clase persona: {persona2.nombre} {persona2.apellido} {persona2.edad} ')

