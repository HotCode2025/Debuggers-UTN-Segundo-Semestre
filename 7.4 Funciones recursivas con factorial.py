#Funciones recursivas
from idlelib.debugger_r import restart_subprocess_debugger

numero = int(input("Digite un numero: "))
def factorial(numero):
    if numero == 1: #caso base
        return 1
    else:
        return numero * factorial(numero-1) #caso recursivo

print(f"El factorial del numero",numero,f"es: {factorial(numero)}")
resultado = factorial(5) # lo hacemos en codigo duro
print(f"El factorial del numero 5 es: {resultado}")


