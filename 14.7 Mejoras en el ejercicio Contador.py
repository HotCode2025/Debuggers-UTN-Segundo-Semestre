class Persona:
    contador_personas = 0  # Variable de clase

 #14.7 Mejoras en el ejercicio Contador
 #
    @classmethod
    def generar_siguiente_valor(cls):
        # Método de clase: puede llamarse sin crear una instancia.
        # Incrementa el contador y devuelve el siguiente valor disponible.
        cls.contador_personas += 1
        return cls.contador_personas
    
    def __init__(self, nombre, edad):
        # Al crear una nueva instancia incrementamos el contador de la clase
        # y asignamos un id único a cada persona
        Persona.contador_personas += 1  # vamos incrementando
        self.id_persona = Persona.contador_personas
        self.nombre = nombre
        self.edad = edad

    def __str__(self):
        return f'Persona [{self.id_persona} = {self.nombre}[{self.edad}]'
    
    
persona1 = Persona('Bruno', 19)
print(persona1)
persona2 = Persona('Ana', 25)
print(persona2)
persona3 = Persona('Luis', 30)
print(persona3)
Persona.generar_siguiente_valor()  # No es necesario crear un objeto para llamar al método de clase
persona4 = Persona('Carla', 28)
print(persona4)
print(f'Cantidad de personas creadas: {Persona.contador_personas}')