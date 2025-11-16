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
    #@edad.setter
    #def edad (self, edad):
     #   print("Ahora con la edad en el metodo set")
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
#atributo read-only seria la edad porque no tiene el metodo set
#persona1.edad = 40
#print(persona1.edad)

