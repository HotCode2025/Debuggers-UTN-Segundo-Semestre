# Tipo Set o conjunto
planetas = {'Marte','Jupiter','Venus'}
print(planetas)
print(len(planetas)) # Usamos la funcion len = length significa largo

# Revisar si un elemento existe dentro de set
print('Jupiter' in planetas)

# Agregar un elemento
planetas.add('Tierra') # add es una funcion
print(planetas)

# Eliminar elementos, puede arrojar un error si el elemento no existe
planetas.remove('Jupiter') # Esta funcion ante un mal ingreso u inexistencia del elemento da error
print(planetas)
planetas.discard('Tierra') # Esta funcion no nos presenta ningun error
print(planetas)

# Limpiar set o conjunto
planetas.clear()
print(planetas)

# Eliminarset o conjunto
#del planetas
#print(planetas) # Al eliminar nos muestra error

