# List comprehension, lista de comprension
names = ['Paolo', 'Rodrigo', 'Lupe', 'Pepe']
alongP = [p for p in names if p[0] == 'P'] # Recorre la lista names y agrega a la nueva lista alongP solo los nombres que empiezan con P
print(alongP)

bottleC = [{'name': 'Quilmes', 'country': 'Argentina'},
            {'name': 'Corona', 'country': 'Mexico'},
            {'name': 'Stella Artois', 'country': 'Belgium'},]
Arg = [b for b in bottleC if b['country'] == 'Argentina'] # Recorre la lista bottleC y agrega a la nueva lista Arg solo las cervezas que son de Argentina
print(Arg)
print(bottleC)

