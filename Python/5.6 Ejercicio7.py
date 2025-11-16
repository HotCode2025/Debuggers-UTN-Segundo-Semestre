import random

def adivina_numero():
    # Generamos el número aleatorio entre 1 y 100
    numero_secreto = random.randint(1, 100)
    
    intentos = 0
    adivinado = False
    
    print("Bienvenido al juego Adivina el número")
    print("He pensado un número entre 1 y 100... ¿podrás adivinarlo?")

    while not adivinado:
        # Pedimos el número al usuario
        try:
            intento = int(input("Ingresa un número: "))
            intentos += 1
        except ValueError:
            print("Por favor ingresa un número válido.")
            continue

        # Comparamos el intento con el número secreto
        if intento < numero_secreto:
            print("El número secreto es mayor.")
        elif intento > numero_secreto:
            print("El número secreto es menor.")
        else:
            print(f"¡Correcto! El número era {numero_secreto}.")
            print(f"Lo lograste en {intentos} intentos.")
            adivinado = True

# Llamamos a la función para jugar
adivina_numero()