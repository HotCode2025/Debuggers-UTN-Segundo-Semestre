// Ejercicio 4: dada una tupla de numeros imprimir solo los menores a 5

const arreglo = [12, 1, 8, 3, 2, 5, 8];

numeros = [];
for (let elemento of arreglo) {
    if (elemento < 5) {
        numeros.push(elemento);
    }
}

console.log(numeros);
