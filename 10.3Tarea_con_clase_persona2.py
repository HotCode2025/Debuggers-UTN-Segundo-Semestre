# 10.3 Tarea con clase persona2
# Tarea crear tres objetos más, utilizando los metodos getter and setter
# para modificar, y mostrar los cambios con el metodo mostrar_detalles
from Persona2 import Persona2

persona2 = Persona2('Alex', 'Diaz', 25)
print(persona2.nombre)
print(persona2.apellido)
print(persona2.edad)
persona2.nombre = 'Ane'
persona2.apellido = 'Lara'
persona2.edad = 20
print(persona2.mostrar_detalles())

persona3 = Persona2('Carol', 'Lazo', 19)
print(persona3.nombre)
print(persona3.apellido)
print(persona3.edad)
persona3.nombre = 'Carolina'
persona3.apellido = 'Lazio'
persona3.edad = 20
print(persona3.mostrar_detalles())

persona4 = Persona2('Aleja', 'Uribe', 25)
print(persona4.nombre)
print(persona4.apellido)
print(persona4.edad)
persona4.nombre = 'Alexis'
persona4.apellido = 'Rojas'
persona4.edad = 17
print(persona4.mostrar_detalles())
print(__name__)  # Comprobacion del modulo prinsipal en ejecucion