class Persona:
    def __init__(self, nombre, edad):
        self.nombre = nombre
        self.edad = edad

class Empleado(Persona): #Esta clase es hija de la clase persona
    def __init__(self, nombre, edad, sueldo):
        super().__init__(nombre, edad)
        self.sueldo = sueldo

empleado1 = Empleado('Kevin', 29, 75000)
print(empleado1.nombre)
print(empleado1.edad)
print(empleado1.sueldo)

#Tarea: Encapsular los atributos y agregar los métodos getters and setters
#Crear otro objeto, pasar los adatos para nombre, edad y sueldo
#Mostrar estos datos, luego modificar y mostrar nuevamente

class Persona:
    def __init__(self, nombre, edad): # Encapsulamos los atributos usando doble guion bajo (__)
        self.__nombre = nombre
        self.__edad = edad

    # ----- Getters -----
    def get_nombre(self):
        return self.__nombre

    def get_edad(self):
        return self.__edad

    # ----- Setters -----
    def set_nombre(self, nombre):
        self.__nombre = nombre

    def set_edad(self, edad):
        self.__edad = edad


class Empleado(Persona):  # Clase hija
    def __init__(self, nombre, edad, sueldo):
        super().__init__(nombre, edad)
        self.__sueldo = sueldo

    # ----- Getter -----
    def get_sueldo(self):
        return self.__sueldo

    # ----- Setter -----
    def set_sueldo(self, sueldo):
        self.__sueldo = sueldo


#Crear primer objeto
empleado1 = Empleado("Kevin", 29, 75000)
print("Empleado 1:")
print("Nombre:", empleado1.get_nombre())
print("Edad:", empleado1.get_edad())
print("Sueldo:", empleado1.get_sueldo())

#Crear segundo objeto
empleado2 = Empleado("Rocio", 25, 68000)
print("\nEmpleado 2:")
print("Nombre:", empleado2.get_nombre())
print("Edad:", empleado2.get_edad())
print("Sueldo:", empleado2.get_sueldo())

#Modificar los datos del segundo empleado
empleado2.set_nombre("Rocio Juarez")
empleado2.set_edad(26)
empleado2.set_sueldo(72000)

#Mostrar datos modificados
print("\nEmpleado 2 (datos modificados):")
print("Nombre:", empleado2.get_nombre())
print("Edad:", empleado2.get_edad())
print("Sueldo:", empleado2.get_sueldo())
