# Clase 5 - Parte 3
#
# Ejercicio 2: Funcion con *args para multiplicar
# Crear una funcion para multiplicar los valores recibidos
# de tipo numerico, utilizando argumentos variables *args 
# como parametro de la funcion y regresar como resultado
# la multiplicacion de todos los valores pasados como argumento
#

# ----------------------------------------------------------------------
def multiplicar_valores(*args):
    resultado = 1
    for valor in args:
        resultado *= valor
    return resultado

# Ejemplos
print("El resultado es:", multiplicar_valores(1, 2, 3))
print("El resultado es:", multiplicar_valores(10, 8, 6, 2))
print("El resultado es:", multiplicar_valores(1.5, 2.5, 3.5))
