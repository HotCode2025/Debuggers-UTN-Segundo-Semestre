# Tuplas

# Definimos una tupla

cocina = ('cuchara', 'cuchillo', 'tenedor')
print(cocina)

print(len(cocina))

# Acceder a un elemento de un tupla

print(cocina[0])

# mostrar el ultimo
print(cocina[-1])

# Acceder a un rango
print(cocina[0:1])
print(cocina[1:3])

# Recorresmo los elementos de la tupla
for cocinar in cocina:
    print(cocinar, end=' ')

print()
cocinaLista = list(cocina)
cocinaLista[0] = 'plato'
cocina = tuple(cocinaLista)
print(cocina)

# Como eliminar una tupla
del cocina
