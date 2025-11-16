class MiClase:
    variabla_clase = '\nEsta es una variable de clase'

    def __init__(self, variable_instancia):
        self.variabla_instancia = variable_instancia

print(MiClase.variabla_clase)

miClase1 = MiClase('Esta es una variable de instancia')
print(miClase1.variabla_instancia)

miClase2 = MiClase('Esta es otra prueba de variable de instancia')
print(miClase2.variabla_instancia)
print(miClase2.variabla_clase)
