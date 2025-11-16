#Frase sin espacios
frase = input("Introduce una frase: ")

frase_sin_espacios = ""

for caracter in frase:
    if caracter != " ":
        frase_sin_espacios += caracter  

print("Frase sin espacios:", frase_sin_espacios)


print("Número de caracteres de la frase: ", len(frase_sin_espacios))
