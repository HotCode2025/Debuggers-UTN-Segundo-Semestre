seleccionArgentina = {

    10: {"Nombre": "Lionel Messi","Edad": 38, "Altura": 1.70,"Precio": "18.000.000", "Posicion": "Extremo Derecho"},
    23: {"Nombre": "Emiliano Martinez","Edad": 32 , "Altura": 1.95,"Precio": "20.000.000", "Posicion": "Arquero"},
    12: {"Nombre": "Geronimo Rulli","Edad": 33 , "Altura": 1.89 ,"Precio": "8.000.000","Posicion": "Arquero"},
    1: {"Nombre": "Walter Benitez","Edad": 32 , "Altura": 1.91,"Precio": "7.500.000","Posicion": "Arquero"},
    13: {"Nombre": "Cristian Romero","Edad": 27 , "Altura": 1.85 ,"Precio": "50.000.000","Posicion": "Defensor Central"},
    32: {"Nombre": "Facundo Medina","Edad": 26 , "Altura": 1.84 ,"Precio": "25.000.000","Posicion": "Defensor central"},
    6: {"Nombre": "Leonardo Balerdi","Edad": 26, "Altura": 1.87 ,"Precio": "20.000.000","Posicion": "Defensor Central"},
    19: {"Nombre": "Nicolas Otamendi","Edad": 37 , "Altura": 1.83 ,"Precio": "1.000.000","Posicion": "Defensor Central"},
    39: {"Nombre": "Julio Soler","Edad": 20 , "Altura": 1.75 ,"Precio": "8.000.000","Posicion":"Lateral Izquierdo"},
    3: {"Nombre": "Nicolas Tagliafico","Edad": 32, "Altura": 1.71 ,"Precio": "6.000.000","Posicion": "Lateral Izquierdo"},
    21: {"Nombre": "Marcos Acuña","Edad": 33 , "Altura": 1.72 ,"Precio": "2.000.000","Posicion": "Lateral Izquierdo"},
    26: {"Nombre": "Nahuel","Edad": 27 , "Altura": 1.75 ,"Precio": "20.000.000","Posicion":"Lateral Derecho"},
    2: {"Nombre": "Juan Foyth","Edad": 27 , "Altura": 1.87 ,"Precio": "15.000.000","Posicion":"Lateral Derecho"},
    4: {"Nombre": "Gonzalo Montiel","Edad": 28 , "Altura": 1.75 ,"Precio": "5.000.000","Posicion":"Lateral Derecho"},
    5: {"Nombre": "Leandro Paredes","Edad": 31 , "Altura": 1.80 ,"Precio": "5.000.000","Posicion":"Mediocampista Central"},
    20: {"Nombre": "Alexis Mac Allister","Edad": 26 , "Altura": 1.76 ,"Precio": "100.000.000","Posicion":"Mediocampista Central"},
    14: {"Nombre": "Exequiel Palacios","Edad": 26 , "Altura": 1.78 ,"Precio": "40.000.000","Posicion": "Mediocampista Central"},
    7: {"Nombre": "Rodrigo De Paul","Edad": 31 , "Altura": 1.80 ,"Precio": "25.000.000","Posicion":"Mediocampista Central"},
    31: {"Nombre": "Nicolas Paz","Edad": 20 , "Altura": 1.86 ,"Precio": "35.000.000","Posicion":"Mediocampista Central Ofensivo"},
    11: {"Nombre": "Thiago Almada","Edad": 24, "Altura": 1.71 ,"Precio": "25.000.000","Posicion": "Mediocampista Izquierdo"},
    17: {"Nombre": "Giovanni Lo Celso","Edad": 29 , "Altura": 1.77 ,"Precio": "15.000.000","Posicion":"Interior Ofensivo"},
    35: {"Nombre": "Valentin Carboni","Edad": 20 , "Altura": 1.85 ,"Precio": "12.000.000","Posicion":"Interior Ofensivo"},
    16: {"Nombre": "Giuliano Simeone","Edad": 22 , "Altura": 1.73 ,"Precio": "35.000.000","Posicion":"Extremo Derecho"},
    30: {"Nombre": "Franco Mastantuono","Edad": 18 , "Altura": 1.77 ,"Precio": "30.000.000","Posicion":"Extremo Derecho"},
    15: {"Nombre": "Nicolas Gonzalez","Edad": 27, "Altura": 1.80,"Precio": "24.000.000","Posicion":"Extremo Izquierdo"},
    28: {"Nombre": "Angel Correa","Edad": 30 , "Altura": 1.71 ,"Precio": "10.000.000","Posicion":"Segundo Delantera"},
    9: {"Nombre": "Julian Alvarez","Edad": 25 , "Altura": 1.70 ,"Precio": "100.000.000","Posicion":"Delantero Centro"},
    22: {"Nombre": "Lautaro Martinez","Edad": 28 , "Altura": 1.74 ,"Precio": "95.000.000","Posicion":"Delantero Centro"},
    99: {"Nombre": "Jose Manuel Lopez","Edad": 24 , "Altura": 1.90 ,"Precio": "10.000.000","Posicion":"Delantero Centro"},
}
for valor in seleccionArgentina.values():
    print (valor)
for llave, valor in seleccionArgentina.items():
    print (llave,valor)

print("Tenemos cargados en el Diccionario la cantidad de Jugadores convocados para la fecha eliminatoria de Septiembre 2025: ")
print(len(seleccionArgentina))