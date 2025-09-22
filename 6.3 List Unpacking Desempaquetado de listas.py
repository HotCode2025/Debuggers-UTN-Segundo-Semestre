#desempaquetado de listas o list unpacking
def show(name, lastName):
    print(name + " " + lastName)
person = ["Rebeca","Navarro"]
show(person[0],person[1]) #pasamos uno por uno los datos de la lista a la funcion
show(*person) #esto es lo mismo que lo anterior pero le pasamos todo junto
person2 = ("Enzo","Navarro") #desempaquetamos a traves de una tupla
show(*person2)
person3 = {"lastName":"Martinez", "name": "Agostina"}
show(**person3)