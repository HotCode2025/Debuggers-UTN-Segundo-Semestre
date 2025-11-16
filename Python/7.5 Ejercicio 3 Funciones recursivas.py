# Clase 5 Parte 3
#
# Ejercicio 3: Funciones Recursivas
# Imprimir los numeros del 5 a 1 de manera descendente usando funciones recursivas
# Puede ser cualquier valor positivo
#

# ----------------------------------------------------------------------
def imprimir_numeros_recursivo(numero):
    if numero >= 1:
        print(numero)
        imprimir_numeros_recursivo(numero - 1)

# Ejemplos
imprimir_numeros_recursivo(5)
print()
imprimir_numeros_recursivo(3)
print()
imprimir_numeros_recursivo(10)
