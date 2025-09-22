#6.8 Valores por default en Argumentos 

def sumar2(a = 0, b = 0):  # Le damos un valor por default
    return a + b

resultado = sumar2()

# print(f'Resultado de la suma: {resultado}')
print(f'Resultado de la suma: {sumar2(22, 66)}')
