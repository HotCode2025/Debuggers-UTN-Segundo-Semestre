'''
Basicamente, la sobrecarga de un operador
significa que un mismo operador puede comportarse
de diferentes formas.

Por ejemplo, el operador de sumar (+)
Este operador se puede comportar de maneras
distintas dependiendo si esta trabajando con string,
con tipos enteros o con tipos lista.

Asi que dependiendo del tipo con el que este trabajando
es posible tener diferentes resultados.
'''

a = 3
b = 5
print(a + b)

a = 'Hola'
b = 'mundo'
print(a + b)

a = [3, 4, 5]
b = [6, 7, 8, 9]
print(a + b)