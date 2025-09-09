# Clase 5 Parte 3
#
# Ejercicio 4: Calculadora de impuestos
# Crear una funcion para calcular el total de un pago incluyendo un impuesto aplicado (IVA)
# formula: pago_total = pago_sin_impuesto + pago_sin_impuesto * impuesto / 100
# Proporcione el pago sin impuesto: 1000
# Proporcione el monto del impuesto: 21%
# Pago con impuesto: xxxx
#

# ----------------------------------------------------------------------
def calcular_pago_con_impuesto(pago_sin_impuesto, impuesto):
    pago_total = pago_sin_impuesto + (pago_sin_impuesto * impuesto / 100)
    return pago_total

# Ejemplo
pago = float(input("Ingrese el total sin impuesto: "))
impuesto = float(input("Ingrese el porcentaje del impuesto: "))

pago_con_impuesto = calcular_pago_con_impuesto(pago, impuesto)

print(f"Pago con impuesto: {pago_con_impuesto}")
