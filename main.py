#lista = Enzo, Agos, Richard, Sandra
# la lista se ennumera desde el 0 aunque tenga cuatro elementos. quedaran listados 0. enzo , 1. agos etc
"""
nombres = ["Enzo","Agos","Richard","Sandra"] #para definir ponemos entre corchetes y las variables entre comillas simple o doble
print(nombres)
print(nombres[0]) #muestra el primer elemento "enzo"
print(nombres[1])
print(nombres[3])
print(nombres[-1]) #si queremos ver el ultimo elemento y no lo sabemos
print(nombres[-2]) #se puede utilizar de manera inversa, comenzando desde atras, este seria el anteultimo

#recuperar el rango de una lista
print(nombres[0:2]) #solo va a recorrer una cantidad de indices. van a ser el 0 y 1, la posicion 2 no la recorre. empieza del 0 y recorre 2 posiciones
#ir del inicio de la lista al indice (sin incluirlo)
print(nombres[ :3]) #nos muestra las primeras 3 posiciones. si dejamos vacio se entiende que es desde el principio
print(nombres[1: ]) #nos muestra desde el segundo elemento hasta el final, porque selecciona el indice uno. el cero queda excluido
#modificar el valor dentro de la lista
nombres[3] = "Chandi"
nombres[0] = "Enzito"
print(nombres)
#iterar una lista
for nombre in nombres: #nombre es singular, la lista es plural
    print(nombre)
else:
    print("Se acabaron los elementos de la lista")

#preguntamos cuantos elementos tiene la lista
print(len(nombres)) #le pasamos como parametro la lista

#como agregar un elemento a la lista
nombres.append("Indy")
print(nombres) #ingresa al final. El llamado efecto cola

#insertar un elemento en un indice especifico ( lo de arriba pero en un lugar especifico) "(lista).insert"
nombres.insert(1,"Emma") #ponemos el nombre de la lista, entre parentesis colocamos la ubicacion, coma, el objeto en string
print(nombres) #se agrego en el espacio especifico, y todos los correlativos se corrieron una posicion
nombres.insert(3,"Franco")
print(nombres)

#para eliminar un elemento de la lista "(lista).remove"
nombres.remove("Franco")
print(nombres)

#eliminar el ultimo elemento de la lista
nombres.pop()
print(nombres)
#eliminar un indice especifico
del nombres[2] #DEL significa delete (eliminar)
print(nombres)
#eliminar, borrar, limpiar todos los elementos
nombres.clear()
print(nombres) #mostrara solo los corchetes vacios

#eliminar la lista

del nombres
print(nombres) #tirara error porque no habra lista
"""
""" 
#tuplas. las listas son mutables, en cambio las tuplas son inmutables. sigue el orden de los elementos pero no se los puede eliminar.
#definimos una tupla
cocina = ("cuchara","cuchillo","tenedor")
print(cocina)
print(len(cocina))
#acceder a un elemento. para esto utilizamos corchetes, no parentesis
print(cocina[0])
#mostrar de manera inversa
print(cocina[-1])
#acceder a un rango
print(cocina[0:2]) #el elemento del lado derecho de los dos puntos demarca la cantidad
#ejemplo
verduras = ("papa",) #para que sea una tupla si o si tiene que tener la coma, sino sera un string (cadena). necesita al menos 1 elemento

#reccoremos los elementos de la tupla
for cocinar in cocina:
#    print(cocinar) print esta usando \n para saltos de linea. salen uno abajo del otro
# para que sea en lista en un solo renglon
    print(cocinar, end=" ")
#para modificar una tupla, debemos pasar de tupla a lista y luego de modificar de lista a tupla
cocinaLista = list(cocina)
cocinaLista[0] = "plato"
cocina = tuple(cocinaLista)
print("\n", cocina) #con esto anulamos el end de arriba Todo esto no suele ser una buena practica

#del cocina
#print(cocina)
"""















