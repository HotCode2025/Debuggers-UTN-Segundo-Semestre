# Clase 5 Parte 2
#
# Ejercicio 11 Agenda Telefónica
# Hacer un programa que simule una agenda de contactos. Crear un
# diccionario donde la clave sea el nombre del usuario y el valor
# sea el telefono, el programa tendra el siguiente menu de opciones
#   1. Nuevo contacto
#   2. Borrar contacto
#   3. Ver contactos existentes
#   4. Salir

# Diccionario para almacenar los contactos
agenda = {}

# -------------------------------------------------------------------
def nuevo_contacto():
    nombre = input("Ingrese el nombre del contacto: ")
    telefono = input("Ingrese el teléfono del contacto: ")
    agenda[nombre] = telefono
    print(f"Contacto '{nombre}' agregado.")

# -------------------------------------------------------------------
def borrar_contacto():
    nombre = input("Ingrese el nombre del contacto a borrar: ")
    if nombre in agenda:
        del agenda[nombre]
        print(f"Contacto '{nombre}' borrado.")

# -------------------------------------------------------------------
def ver_contactos():
    if agenda:
        print("\n--- LISTA DE CONTACTOS ---")
        for nombre, telefono in agenda.items():
            print(f"Nombre: {nombre} | Teléfono: {telefono}")

# -------------------------------------------------------------------
# Menu
while True:
    print("\n--- MENÚ AGENDA ---")
    print("1. Nuevo contacto")
    print("2. Borrar contacto")
    print("3. Ver contactos")
    print("4. Salir")

    try:
        opcion = int(input("Ingrese una opción: "))
        
        if opcion == 1:
            nuevo_contacto()
        elif opcion == 2:
            borrar_contacto()
        elif opcion == 3:
            ver_contactos()
        elif opcion == 4:
            break
        else:
            print("Error. Opciones validas del 1 al 4.")
    except ValueError:
        print("Error. Por favor, ingresa un número.")

