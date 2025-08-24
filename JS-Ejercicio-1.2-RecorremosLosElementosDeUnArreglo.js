// 1.2 Recorremos los elementos de un arreglo


const autos = ['Ferrari', 'Renault', 'BMW'];
console.log(autos);


console.log(autos[0]);
console.log(autos[2]);

for(let i = 0; i < autos.length; i++){
    console.log([i+' ; '+autos[i]]);
}