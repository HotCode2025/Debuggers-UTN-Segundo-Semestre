# Clase 6 POO Parte 1
#
# 8.3 Creación de objetos con argumentos

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

