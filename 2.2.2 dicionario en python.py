# PARTE 1

# una llave y un valor
# dict(key,value)
diccionario = {
    'IDE':'Integrated Developement Environment',
    'POO':'Programacion Orientada a objetos',
    'SABD':'Sistema de Administracion de Base de Datos'

}
#verificar la cantidad de elementos del diccionario
print(diccionario)
print(len(diccionario))

#acceder a un diccionario con la llave (key)
print(diccionario['IDE'])

#otra forma de recuperar elemento
print(diccionario.get('POO'))
print(diccionario.get('SABD'))

#MODIFICAMOS ELEMENTOS
diccionario['IDE'] = 'Entorno de desarrollo Integrado'
print(diccionario)


# PARTE 2

# como recorrer los elementos
for termino in diccionario: #recorremos mostrando las llaves
    print(termino)

#necesitamos una funcion para recorrer un diccionario
for termino, valor in diccionario.items():
    print(termino, valor)

# otras maneras de acceder a un diccionario
for termino in diccionario.keys(): #estamos usando una funcion
    print(termino) #muestra solo las llaves

for valor in diccionario.values(): #usamos una funcion para acceder al valor
    print(valor)

#comprobar la existencia de algun elemento
print('IDE' in diccionario) #devuelve un booleano

# agregar un elemento
diccionario['PK'] = 'Primary key'
print(diccionario)

#eliminar un elemento
diccionario.pop('SABD')
print(diccionario)

#vaciar un diccionario
diccionario.clear()
print(diccionario)

#eliminar diccionario
del diccionario #el diccionario se elimina


