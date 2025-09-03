# Clase 3.4 Metodo con listas llamado PILAS

# Pilas usando listas
pila = [1, 2, 3]

# Agregar elementos a la pila por el final
pila.append(4)
pila.append(5)
print(pila)

#Sacamos elementosdesde el final
elementoBorrado = pila.pop() # Quita el ultimo elemento y lo guarda en la variable
print(f'Sacamos el elemento: {elementoBorrado}')
print(f'La pila ahora quedo asi: {pila}')