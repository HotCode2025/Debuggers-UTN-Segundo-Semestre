class Persona: #creamos una clase

    def __init__(self,nombre, apellido, edad):
        self.nombre = nombre
        self.apellido = apellido
        self.edad = edad

    def mostrar_detalle(self):
        print(f"Persona: {self.nombre} {self.apellido} {self.edad}")

persona1 = Persona("Enzo","Navarro",26)
print(f"El objeto1 de la clase persona: {persona1.nombre} {persona1.apellido} Su edad es: {persona1.edad}")
persona2 = Persona("Agostina","Martinez", 26)
print(f"El Objeto2 de la clase persona: {persona2.nombre} {persona2.apellido} Su edad es: {persona2.edad}")

persona1.nombre = "Ricardo"
persona1.apellido = "Navarro Perez"
persona1.edad = 59
print(f"El objeto1 modificado de la clase persona: {persona1.nombre} {persona1.apellido} Su edad es: {persona1.edad}")

#los atributos son: caracteristicas
# los metodos son: el comportamiento que van a tener los objetos (acciones)
persona1.mostrar_detalle() #la referencia se pasa de manera automatica
persona2.mostrar_detalle()

#Persona.mostrar_detalle(persona1) deberemos pasarle una referencia para el sel o dara error





