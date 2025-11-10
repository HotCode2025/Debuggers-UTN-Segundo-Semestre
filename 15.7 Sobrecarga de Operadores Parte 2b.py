class Persona:
    def __init__(self, nombre, edad):
        self.nombre = nombre
        self.edad = edad

    def __add__(self, other):
        return f"{self.nombre}{other.nombre}"

    def __sub__(self, otro):
        return self.edad - otro.edad

persona1 = Persona("Enzo",26)
persona2 = Persona("Agos",22)

print(persona1 + persona2)
print(persona1 - persona2)