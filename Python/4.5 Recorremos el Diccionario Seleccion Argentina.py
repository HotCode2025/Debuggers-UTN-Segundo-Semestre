seleccionArgentina = {
    10: {'Nombre': 'Lionel Messi', 'Edad': 35, 'Altura': 1.70, 'Precio': '50 Millones', 'Posicion': 'Extremo Derecho'},
    11: {'Nombre': 'Ángel Di María', 'Edad': 34, 'Altura': 1.80, 'Precio': '12 Millones', 'Posicion': 'Extremo Derecho'},
    24: {'Nombre': 'Paulo Dybala', 'Edad': 28, 'Altura': 1.77, 'Precio': '35 Millones', 'Posicion': 'Media Punta'},
    19: {'Nombre': 'Nicolás Otamendi', 'Edad': 34, 'Altura': 1.83, 'Precio': '3.5 Millones', 'Posicion': 'Defensa Central'},
    1:  {'Nombre': 'Franco Armani', 'Edad': 35, 'Altura': 1.89, 'Precio': '3.5 Millones', 'Posicion': 'Portero'},
    22: {'Nombre': 'Lautaro Martínez', 'Edad': 28, 'Altura': 1.75, 'Precio': '75 Millones', 'Posicion': 'Delantero Centro'},
    7:  {'Nombre': 'Rodrigo De Paul', 'Edad': 30, 'Altura': 1.85, 'Precio': '40 Millones', 'Posicion': 'Centrocampista'},
    6:  {'Nombre': 'Germán Pezzella', 'Edad': 34, 'Altura': 1.87, 'Precio': '5 Millones', 'Posicion': 'Defensa Central'},
    23: {'Nombre': 'Emiliano Martínez', 'Edad': 32, 'Altura': 1.95, 'Precio': '28 Millones', 'Posicion': 'Portero'}
}



# Como recorrer un diccionario con el ciclo for
for i in seleccionArgentina:
    print(f'{i} -> {seleccionArgentina[i]}')
