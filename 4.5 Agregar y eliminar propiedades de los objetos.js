//Objeto
let persona2 = new Object //Debe crear un nuevo objeto en memoria
persona2.nombre = 'Juan';
persona2.direccion = 'Salada 14';
persona2.telefono = '123123123';
console.log(persona2.telefono);
//Luego de crear el objeto ya podemos agregarle los atributos

console.log(persona2['telefono']); //Accedemos como si fuera un arreglo
//es un ciclo for especial, que se llama for in, que permite recorrer el arreglo

//for in y accedemos al objeto como si fuera un arreglo
for(propiedad in persona2){ //propiedad es una variable
console.log(propiedad);
console.log(persona2[propiedad]);
}