# Clase 5 Parte 2
# 
# Ejercicio 1: Crear una funcion àra sumar los valores recibidos por tipo
# numeriso, utilizando argumentos variables *args como parametro de la
# funcion y agregar como resultado la suma de todos los valores pasados
# como argumentos
#

# ----------------------------------------------------------------------
def sumar_valores(*args):
    suma = 0
    for valor in args:
        suma += valor
    return suma

# Ejemplos
print("La suma es:", sumar_valores(1, 2, 3))
print("La suma es:", sumar_valores(10, 20, 30, 40, 50))
print("La suma es:", sumar_valores(1.5, 2.5, 3.5))