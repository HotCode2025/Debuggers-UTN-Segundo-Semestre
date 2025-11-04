#Tipos de tuplas SET
planetas= {"Marte","Jupiter", "Venus"}
print(len(planetas)) #Len=lenght = largo

#verificar existencia de un elemento dentro del set
print("Jupiter" in planetas)


#Agregar elementos

planetas.add("tierra")
print(planetas)

#Eliminar elementos:
planetas.remove("tierra")#Funcion al estar mal escrita da error
print(planetas)

planetas.discard("Marte")#Esta funcion no da error
print(planetas)

#Limpiar set o conjunto

planetas.clear()
print(planetas)

#  Eliminar set o conjunto
del planetas
print(planetas) 
