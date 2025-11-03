from abc import ABC


class FiguraGeometrica(ABC):
    def __init__(self, ancho, alto):
        if self._validar_valores(ancho): ## 13.1 Validaciones en atributos
            self._ancho = ancho
        else:
            self._ancho = 0
            print(f'Valor erroneo para el ancho: {ancho}')
        if self._validar_valores(alto):## 13.1 Validaciones en atributos
            self._alto = alto
        else:
            self._alto = 0
            print(f'Valor erroneo para el alto: {alto}')

        @ancho.setter
        def ancho(self, ancho):
            if self._validar_valores(ancho):  ## 13.1 Validaciones en atributos
                self._ancho = ancho
            else:
                print(f'valor erroneo ancho: {ancho} ')

        @alto.setter
        def alto(self, alto):
            if self._validar_valores(alto):  ## 13.1 Validaciones en atributos
                self._alto = alto
            else:
                print(f'valor erroneo alto: {alto} ')

        def _validar_valores(self, valor):  # metodo encapsulado
            return True if 0 < valor < 10 else False  # # 13.1 Validaciones en atributos