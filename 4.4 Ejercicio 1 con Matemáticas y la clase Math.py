import math
#importamos la clase math para hacer uso de la funcion sqrt (raiz cuadrada)
#Ejercicio de matematicas para sacar la raiz cuadrada de un numero positivo
numero = int(input("Digite un numero positivo: "))
while numero < 0:
    print("Error: Debería ser un numero positivo")
    numero = int(input("Digite un numero positivo: "))
print(f"\nSu raíz cuadrada es: {math.sqrt(numero):.2f}")