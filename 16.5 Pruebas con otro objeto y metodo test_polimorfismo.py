from Empleado import Empleado
from Gerente import Gerente


def imprimir_detalles(objeto):
    # print(objeto) #de manera indirecta llama al str de la clase empleado o gerente
    print(type(objeto))
    print(objeto.mostrar_detalles())

empleado = Empleado("Enzo",2000000)
imprimir_detalles(empleado)

gerente = Gerente("Agostina",3000000,"RRHH")
imprimir_detalles(gerente)


