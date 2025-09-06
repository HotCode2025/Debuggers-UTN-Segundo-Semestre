#Tabla de multiplacar de un numero


numero = int(input("ingresa un numero "))

tabla = []
for i in range(1, 11):
    resultado = numero * i
    tabla.append(resultado)


print("La tabla de multiplicar es:", tabla)
