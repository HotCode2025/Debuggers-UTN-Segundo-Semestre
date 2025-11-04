# -------------------------------------------------------------------------------------
# 3.1 Repaso del tipo set o conjunto

# Video 1

conjunto1 = set() # Con parentesis inicializa un conjunto vacio
conjunto2 = {'bey', } # Con llave debe tener un elemento

conjunto1.add(7)
conjunto1.add('Hola')
print(conjunto1)

conjunto2.add('Hola')
print(conjunto2)

print(3 not in conjunto2)

# Como hacer la igualdasd de dos conjuntos
print(conjunto1 == conjunto2) # Nos devuelve un booleano

# Video 2

# Operacion con conjuntos
conjunto3 = conjunto1 | conjunto2
print(conjunto3)

# Interseccion - Los valores que estan en ambo conjuntos
conjunto3 = conjunto1 & conjunto2
print(conjunto3)

# Los valores del conjunto 1 que no esten en el conjunto 2
conjunto3 = conjunto1 - conjunto2
print(conjunto3)
conjunto3 = conjunto2 - conjunto1
print(conjunto3)

# Los elementos que estan repetidos en los conjuntos
conjunto3 = conjunto1 ^ conjunto2
print(conjunto3)

# Video 3

# Preguntamos si un conjunto es un subconjunto de otro
conjunto3 = conjunto1 | conjunto2
print(conjunto1.issubset(conjunto3))
print(conjunto2.issubset(conjunto3))

print(conjunto3.issubset(conjunto1))

# Si en un conjuto estan todos los elementos de otro conjunto
print(conjunto3.issuperset(conjunto1))
print(conjunto3.issuperset(conjunto2))

print(conjunto1.issuperset(conjunto3))

# Como saber si ambos conjuntos no comparten elementos
print(conjunto1.isdisjoint(conjunto2))

# Convertir un conjunto totalmente en inmutable. No se puede modificar
conjunto1 = frozenset 

# -------------------------------------------------------------------------------------
# 3.2 Repaso de Diccionarios

# Video 1
dicccionarioNuevo = {'Azul': 'Blue', 'Rojo': 'Red', 'Verde': 'Green', 'Amarillo': 'Yellow'}

# Como eliminaos un elemento
print(dicccionarioNuevo)
del (dicccionarioNuevo['Azul'])
print(dicccionarioNuevo)

# Como agregamos un elemento
dicccionario2 = {'Ariel': {'edad': 40, 'Altura': 1.83}, 'Osvaldo': [45, 1.85], 'Natalia': [35, 1.67]}
print(dicccionario2['Ariel']['edad'])
print(dicccionario2['Osvaldo'])

# -------------------------------------------------------------------------------------
# 3.3 Ejercicio con Diccionario y tarea 

seleccionArgentina = {
    10: {'Nombre': 'Lionel Messi',       'Edad': 35, 'Altura': 1.70, 'Precio': '50.00 millones', 'Posicion': 'Extremo Derecho'},
    11: {'Nombre': 'Anfel Di Maria',     'Edad': 34, 'Altura': 1.80, 'Precio': '12.00 millones', 'Posicion': 'Extremo Derecho'},
    24: {'Nombre': 'Paulo Dyvala',       'Edad': 28, 'Altura': 1.77, 'Precio': '35.00 millones', 'Posicion': 'Media Punta'},
    19: {'Nombre': 'Nicolas Otamendi',   'Edad': 34, 'Altura': 1.83, 'Precio': ' 3.50 millones', 'Posicion': 'Defensa'},
     1: {'Nombre': 'Franco Armani',      'Edad': 35, 'Altura': 1.89, 'Precio': ' 3.50 millones', 'Posicion': 'Portero'},
    50: {'Nombre': 'Emiliano Martínez',  'Edad': 32, 'Altura': 1.00, 'Precio': '20.00 millones', 'Posicion': 'Portero'},
    51: {'Nombre': 'Cristian Romero',    'Edad': 27, 'Altura': 1.00, 'Precio': '50.00 millones', 'Posicion': 'Defensa central'},
    52: {'Nombre': 'Nicolás Tagliafico', 'Edad': 33, 'Altura': 1.00, 'Precio': ' 6.00 millones', 'Posicion': 'Lateral izquierdo'},
    53: {'Nombre': 'Marcos Acuña',       'Edad': 33, 'Altura': 1.00, 'Precio': ' 2.00 millones', 'Posicion': 'Lateral izquierdo'},
    54: {'Nombre': 'Gonzalo Montiel',    'Edad': 28, 'Altura': 1.00, 'Precio': ' 5.00 millones', 'Posicion': 'Lateral derecho'},
}

print(seleccionArgentina[10])
print(seleccionArgentina.values())

# Recorrer el array
for llave in seleccionArgentina:
    print(llave)

for valor in seleccionArgentina.values():
    print(valor)

for llave, valor in seleccionArgentina.items():
    print(llave, valor)

# Tamaño
print(len(seleccionArgentina))

# -------------------------------------------------------------------------------------
# 3.4 Método con listas llamado PILAS

# Pilas usando listas

pila = [1, 2, 3]
print(pila)

# Agregar elementos a la pila
pila.append(4)
pila.append(5)
print(pila)

# Borrar elementos de la pila
pila.pop()
print(pila)

elementoBorrado = pila.pop()
print(f'Sacamos el elemento: {elementoBorrado}')
print(f'La pila ahora quedo asi: {pila}')

# -------------------------------------------------------------------------------------
# 3.5  Método con listas llamado COLA

# Estructura de datos tipo fifo
cola = ['Ariel', 'Osvaldo', 'Liliana', 'Pilar']

# Agregamos elementos
cola.append('Natalia')
cola.append('Jose')
print(cola)

# Sacamos elementos
seRetira = cola.pop(0)
print(f'Atendido {seRetira}')

seRetira = cola.pop(0)
print(f'Atendido {seRetira}')

