class Persona: # Creamos una clase

    def __init__(self): # Se lo llama metodo Init Dunder (Double Underscore)
        self.nombre = 'Juan' # Atributo de instancia
        self.apellido = 'Zalazar'
        self.edad = 22

persona1 = Persona() # Este es un constructor, apunta directamente al metodo (al init)
print(persona1.nombre) # Nos dice que es una clase
print(persona1.apellido)
print(persona1.edad)