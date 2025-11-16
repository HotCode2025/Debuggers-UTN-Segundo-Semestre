# 7.3 Lista de elemetnos con funciones
def desplegarNombres(nombres):
    for nombre in nombres:
        print(nombre)

nombres2 = ['Tito', 'Pedro', 'Carlos']
desplegarNombres(nombres2)
desplegarNombres('Carla')
# desplegarNombres(10, 11) # No es un objeto iterable
desplegarNombres((10, 11))  # La convertimos a una tupla, en un solo elemento no olvidar la coma
desplegarNombres([22, 55])  # La convertimos en una lista
