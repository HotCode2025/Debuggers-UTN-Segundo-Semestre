# Ejercicio 8: Menu interactivo - Cajero automatico
# Hacer un programa que simule un cajero automatico con un saldo
# inicial de $ 1000 y tendra el siguiente menu de opciones:
#   1. Ingresar dinero en la cuenta
#   2. Retirar dinero de la cuenta
#   3. Mostrar dinero disponible
#   4. Salir

saldo = 1000

while True:
    print(" MENÚ CAJERO AUTOMÁTICO ")
    print("1. Ingresar dinero en la cuenta")
    print("2. Retirar dinero de la cuenta")
    print("3. Mostrar dinero disponible")
    print("4. Salir")

    opcion = input("Seleccione una opcion (1-4): ")

    if opcion == "1":
        monto = float(input("Ingrese el monto a depositar: $"))
        if monto > 0:
            saldo += monto  # Se suma al saldo
            print(f"Se ingresaron ${monto:.2f}. Nuevo saldo: ${saldo:.2f}")
        else:
            print("El monto debe ser mayor a cero.")

    elif opcion == "2":
        monto = float(input("Ingrese el monto a retirar: $"))
        if monto <= saldo and monto > 0:
            saldo -= monto  # Se resta del saldo
            print(f"Se retiraron ${monto:.2f}. Nuevo saldo: ${saldo:.2f}")
        elif monto <= 0:
            print("El monto debe ser mayor a cero.")
        else:
            print("Fondos insuficientes.")

    elif opcion == "3":
        print(f"Saldo disponible: ${saldo:.2f}")

    elif opcion == "4":
        print("Gracias por usar el cajero. ¡Hasta luego!")
        break
    else:
        print("Opción inválida. Intente nuevamente.")