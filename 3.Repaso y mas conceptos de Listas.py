# lista = Ariel , Liliana , Natalia , Osvaldo

nombres = ['Naty', 'Osvaldo', 'Lily', 'Ariel']
print(nombres)
print(nombres[0:2]) #Solo muestra el indice 0,1 pero no el indice 2

# Ir del inicio de la lista al indice (sin incuirlo)
print(nombres[ :3]) # indices a mostrar 0,1,2

# Desde el indicado hasta el final
print(nombres[1: ])

# Modificamos un valor
nombres[2] = 'Liliana'
nombres[0] = 'Natalia'
print(nombres)

# Iterar una lista
for nombre in nombres: # nombre es singular, la lista es plural
    print(nombre)
else:
    print('Se acabaron los elementos de la lista')

# Preguntamos cuantos elementos tiene
print(len(nombres)) # Le pasamos como parametro la lista

# Agregamos un elemento
nombres.append('Marcelo')
nombres.append([1, 2, 3])
nombres.append(True)
nombres.append(10.45)
nombres.append([4, 5])
nombres.append(7)
print(nombres)