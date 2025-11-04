class Persona: # Creamos una clase

    def __init__(self, nombre, apellido, edad): # Se lo llama metodo Init Dunder (Double Underscore)
        self.nombre = nombre
        self.apellido = apellido
        self.edad = edad

persona1 = Persona('Ariel', 'Betancud', 40) # Necesitamos enviar argumentos
# print(persona1.nombre) # Nos dice que es una clase
# print(persona1.apellido)
# print(persona1.edad)

persona2 = Persona('Osvaldo', 'Giordanini', 45)
print(f'El objeto2 de la clase persona es: {persona2.nombre} {persona2.apellido} Su edad es: {persona2.edad}')

#Tarea de hacer lo mismo con persona1
print(f'El objeto1 de la clase persona es: {persona1.nombre} {persona1.apellido} Su edad es: {persona1.edad}')
