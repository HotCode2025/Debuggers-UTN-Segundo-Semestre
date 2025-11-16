class Persona2:
    def __init__(self, nombre,apellido,edad,direccion,telefono,email):
        self._nombre = nombre
        self._apellido = apellido
        self._edad = edad
        self._direccion = direccion
        self._telefono = telefono
        self._email = email


    def mostrar_detalles(self):
        print(f"Los datos a mostrar son los siguientes: {self._nombre} {self._apellido} {self._edad} {self._direccion} {self._telefono} {self._email}")

    @property #decorador
    def nombre(self): #metodo getter
        print("Estamos Usando el metodo get")
        return self._nombre
    @property
    def apellido(self):
        print("Seguimos usando el get para apellido")
        return self._apellido
    @property
    def edad(self):
        print("Ahora con la edad")
        return self._edad
    @property
    def direccion(self):
        print("Direccion")
        return self._direccion
    @property
    def telefono(self):
        print("Telefono")
        return self._telefono
    @property
    def email(self):
        print("Email")
        return self._email

    @nombre.setter
    def nombre(self, nombre): #metodo setter
        print("Estamos usando el metodo set")
        self._nombre = nombre
    @apellido.setter
    def apellido(self, apellido):
        print("Seguimos con el apellido en el metodo set")
        self._apellido = apellido
    @edad.setter
    def edad (self, edad):
        print("Ahora con la edad en el metodo set")
    @direccion.setter
    def direccion(self,direccion):
        print("Setter: Direccion")
        self._direccion = direccion
    @telefono.setter
    def telefono(self,telefono):
        print("Setter: telefono")
        self._telefono = telefono
    @email.setter
    def email(self,email):
        print("Setter: email")
        self._email = email


persona1 = Persona2("Enzo","Navarro",26, "Segovia 569", 2604404218,"enzonavarro7738@gmail.com")
print(persona1.nombre) #con esto llamamos al metodo getter que no necesita parametros
#persona1.nombre = "Ricardo" #llamamos al metodo setter
print(persona1.nombre) #otra vez el metodo getter
print(persona1.mostrar_detalles()) #llamamos el metodo mostrar_detalles

# 10.3 Tarea con clase persona2
# Tarea crear tres objetos más, utilizando los metodos getter and setter
# para modificar, y mostrar los cambios con el metodo mostrar_detalles

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
