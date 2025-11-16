class Persona:
    def __init__(self, nombre, edad):
        self.__nombre = nombre   # Atributo encapsulado (privado)
        self.__edad = edad       # Atributo encapsulado (privado)

    # Getter y Setter para nombre
    def get_nombre(self):
        return self.__nombre

    def set_nombre(self, nombre):
        self.__nombre = nombre

    # Getter y Setter para edad
    def get_edad(self):
        return self.__edad

    def set_edad(self, edad):
        self.__edad = edad

    def __str__(self):
        return f'Persona: [ Nombre: {self._nombre}, Edad: {self._edad} ]'


# Clase Empleado que hereda de Persona
class Empleado(Persona):
    def __init__(self, nombre, edad, sueldo):
        super().__init__(nombre, edad)
        self.__sueldo = sueldo  # Atributo encapsulado (privado)

    # Getter y Setter para sueldo
    def get_sueldo(self):
        return self.__sueldo

    def set_sueldo(self, sueldo):
        self.__sueldo = sueldo

    def __str__(self):
        return f'Empleado: [ Sueldo: {self._sueldo}] {super().__str__()}'

empleado1 = Empleado('Jose', 35, 45000)
print(empleado1.nombre)
print(empleado1.edad)
print(empleado1.sueldo)

