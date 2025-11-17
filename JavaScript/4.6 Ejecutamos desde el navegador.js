let x = 10; //variable de tipo primitiva
console.log(x.length);
console.log('Tipos primitivos');

//Objeto
let persona = {
    nombre: 'Carlos',
    apellido: 'Gil',
    email: 'cgil@gmail.com',
    edad: 30,
    nombreCompleto: function(){ //Metodo o funcion en JavaScript
        return this.nombre+' '+this.apellido;
    }
}

console.log(persona.nombre);
console.log(persona.apellido);
console.log(persona.email);
console.log(persona.edad);
console.log(persona);
console.log(persona.nombreCompleto());
console.log('Ejecutando con un objeto');
let persona2 = new Object //Debe crear un nuevo objeto en memoria
persona2.nombre = 'Juan';
persona2.direccion = 'Salada 14';
persona2.telefono = '123123123';
console.log(persona2.telefono);
console.log('Creamos un nuevo objeto');
//Luego de crear el objeto ya podemos agregarle los atributos

console.log(persona2['telefono']); //Accedemos como si fuera un arreglo
//es un ciclo for especial, que se llama for in, que permite recorrer el arreglo

//for in y accedemos al objeto como si fuera un arreglo
for(propiedad in persona2){ //propiedad es una variable
console.log(propiedad);
console.log(persona2[propiedad]);
console.log('Usamos el ciclo for in');
}

persona.apellido = 'Betancud'; //Cambiamos dinamicamente un valor del objeto
console.log(persona);

//Para borrar
console.log('Cambiamos y eliminamos un error');
persona.apellida = 'Betancud';
delete persona.apellida;
console.log(persona);
