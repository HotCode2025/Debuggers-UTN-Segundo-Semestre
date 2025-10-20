class Aritmetica:
# Vamos a hacer en esta clase algunas operaciones de : suma, resta, multiplicacion y mas
    def __init__(self, operandoA, operandoB):
        self.operandoA = operandoA
        self.operandoB = operandoB

    # Método para sumar
    def sumar(self):
        return self.operandoA + self.operandoB

    # Método de resta
    def resta(self):
        return self.operandoA - self.operandoB

    # Método de multiplicacion
    def multiplicar(self):
        return self.operandoA * self.operandoB

    # Método para dividir
    def dividir(self):
        return self.operandoA / self.operandoB

aritmetica1 = Aritmetica(7, 9) # Le pasamos los argumentos para los operados
print(f'La suma de los numeros es: {aritmetica1.sumar()}')
print(f'la resta de los numeros es: {aritmetica1.resta()}')
print(f'la multiplicacion de los numeros es: {aritmetica1.multiplicar()}')
print(f'la dicision de los numeros es: {aritmetica1.dividir():.2f}')