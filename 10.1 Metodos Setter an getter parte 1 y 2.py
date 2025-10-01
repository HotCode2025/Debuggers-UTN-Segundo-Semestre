class persona2:  # Creamos una clase

    def __init__(self, nombre, apellido, edad):  # Método __init__
        self._nombre = nombre
        self._apellido = apellido
        self._edad = edad

    def mostrar_detalle(self):
        print(f"La clase persona tiene los siguientes atributos: {self._nombre} {self._apellido} {self._edad}")

    @property
    def nombre(self):  # Método getter
        print("Método Getter")
        return self._nombre

    @nombre.setter
    def nombre(self, nombre):  # Método setter
        print("Método Setter")
        self._nombre = nombre

    @property
    def apellido(self):
        return self._apellido

    @apellido.setter
    def apellido(self, apellido):
        self._apellido = apellido

    @property
    def edad(self):
        return self._edad

    @edad.setter
    def edad(self, edad):
        self._edad = edad


    



persona1 = persona2("Bruno", "Fiochi", 19)


print(persona1.nombre)  #Metod Getter

persona1.nombre="Juan carlos"#Llamamos al metodo setter
print(persona1.nombre)  
print(persona1.mostrar_detalle())  
#Tarea de llamar a los nuevos metodos

#Getter
print(persona1.apellido)

print(persona1.edad)

#Setter
persona1.apellido="Martinez"
print(persona1.apellido)
persona1.edad=20
print(persona1.edad)




