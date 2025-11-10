## Tablas para sobreescribir metodos que heredamos de la clase padre Object
# y lo podemos al uso que nosotros queramos para la sobrecarga de operadores.

'''
## Operadores aritmeticos    |    ## magic method
+                            |    __add__(self,other)
-                            |   __sub__(self,other)
*                            |   __mul__(self,other)
/                            |   __truediv__(self,other)
//                           |   __floordiv__(self,other)
%                            |   __mod__(self,other)
**                           |   __pow__(self,other)


## Operador Comparación (lógicos)

<                            |   __lt__(self,other)
>                            |   __gt__(self,other)
<=                           |   __le__(self,other)
>=                           |   __ge__(self,other)
==                           |   __eq__(self,other)
!=                           |   __ne__(self,other)


## Operadores de asignación (compuestos)

-=                            |   __isub__(self,other)
+=                            |   __iadd__(self,other)
*=                            |   __imul__(self,other)
/=                            |   __idiv__(self,other)
//=                           |   __ifloordiv__(self,other)
%=                            |   __imod__(self,other)
**=                           |   __ipow__(self,other)

## Operadores unarios

-                             |   __neg__(self,other)
+                             |   __pos__(self,other)
~                             |   __invert__(self,other)

'''



a = 3
b = 5
print(a + b)

a = 'Hola'
b = 'mundo'
print(a + b)

a = [3, 4, 5]
b = [6, 7, 8, 9]
print(a + b)


