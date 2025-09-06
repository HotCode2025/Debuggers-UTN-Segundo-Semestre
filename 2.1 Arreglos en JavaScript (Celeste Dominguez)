// let autos = new Array('Ferrari','Renault','BMW); esta es la sintaxis vieja
const autos = ['Ferrari','Renault','BMW'];
console.log(autos);

//Recorremos los elementos de un arreglo
console.log(autos[0]);  //Ferrari
console.log(autos[1]);   //BMW

for(let i = 0; i < autos.length; i++){
    console.log(i+' : '+autos[i]);
}

// Modificamos los elementos del arreglo
autos[1] = 'Volvo';
console.log(autos[1]);   // Volvo


//Agregamos nuevo valor al arreglo
autos.push('Audi'); //Agregamos el elemento al final del arreglo
console.log(autos);

//Otras formas de agregar elementos al arreglo
autos[autos.length] = 'Porche';  //le decimos que al final del arreglo ingrese otro elemento
console.log(autos);

// Tercera forma de agregar elementos teniendo CUIDADO
autos[6] = 'Renault';  //Hay 4 elementos, al agregar en el indice 6 queda un espacio libre en el 5
console.log(autos);


//Como preguntar si es un Array
console.log(Array.isArray(autos)); //Devuelve un resultado booleano

//Otra forma (preguntamos si la variable es una instancia de la clase Array)
console.log(autos instanceof Array);
