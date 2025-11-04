
# Concater listas
lista1 = [1, 2, 3, 1]
lista2 = [4, 5, 6, 1]
lista3 = lista1 + lista2
print(lista3)

# Agregar varios elementos en una lista
lista3.extend([7, 8, 9, 1])
print(lista3)

# En que posicion esta un elemento
print(lista3.index(5))

# Cuantos veces aparace un elemento en la lista
print(lista3.count(1))

# Invertrir la lista
lista3.reverse()
print(lista3)

# Multiplicar una lista repitiendo sus elementos
lista3 = lista3 * 2
print(lista3)

# Metodos de ordenaiento
lista3.sort()
print(lista3)

lista3.sort(reverse=True)
print(lista3)

# Repaso tuplas
tupla = (4, 'Hola', 3.14, [1, 2, 3], 4, 'Hola')
print(tupla)

print(4 in tupla)