
conjunto2 = set() #a traves de set es la unica forma que el conjunto puede inicialiarse vacio
conjunto1 = {"bye"} # a un conjunto que esta inicializado con llaves no se le puede agregar nada ya que fue creado de esa manera

#como determinar si un conjunto es subconjunto de otro
conjunto3= conjunto1 | conjunto2
print(conjunto2.issubset(conjunto3)) #responde con un booleano
print(conjunto1.issubset(conjunto3))
print(conjunto3.issubset(conjunto1))
print(conjunto3.issubset(conjunto2))

#como saber si ambos conjuntos son disconexos, osea no comparten ningun elemento. responde tambien con booleano
print(conjunto3.issuperset(conjunto1)) #preguntamos si los elementos del conjunto 1 estan dentro del 3
print(conjunto3.issuperset(conjunto2))
print(conjunto2.issuperset(conjunto1))

#como saber si ambos conjuntos son disconexos. esto es si no comparten elementos en comun. tambien responde con booleano
print(conjunto1.isdisjoint(conjunto2)) #no hay cosas en comun

#convertir un conjunto en totalmente inmutable
conjunto1 = frozenset #no se pueden agregar ni quitar elementos de este conjunto