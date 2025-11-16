class Aritmetica:
    """
    El nombre de este tipo de comentario es: DocString
    esto es documentacion de la clase en python
    Vamos a hacer en esta clase algunas operacion de: suma, resta, multiplicacion y mas
    """
    def __init__(self, operandoA, operandoB):
        self.operandoA = operandoA
        self.operandoB = operandoB
        print('Se ha creado una instancia de la clase Aritmetica')

    # Metodo para sumar
    def sumar(self):
        return self.operandoA + self.operandoB


aritmetica1 = Aritmetica(7, 9)
print(aritmetica1.sumar()) # Llamamos al metodo sumar para que realice la operacion
