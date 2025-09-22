#definimos los datos necesarios que venian del video anterior
class Persona: #creamos una clase
    def __init__(self,nombre,apellido,edad): #se lo llama metodo init dunder
        self.nombre = nombre
        self.apellido= apellido
        self.edad = edad
persona1 = Persona("Enzo","Navarro",26)
print(persona1.nombre)
print(persona1.apellido)
print(persona1.edad)

persona1.nombre = "Rebeca"
persona1.apellido = "Navarro"
persona1.edad = 0
print(f"El objeto 1 de la clase persona: {persona1.nombre} {persona1.apellido}. Su edad es: {persona1.edad}")