// Distintas formas de imprimir un objeto

// Número 1: la más sencilla: concatenar cada valor de cada propiedad
console.log('Distinta formas de imprimir un objeto: forma 1');
console.log(persona.nombre + ', ' + persona.apellido);  

// Número 2: A través del ciclo for in
console.log('Distinta formas de imprimir un objeto: forma 2');
for (nombrePropiedad in persona) {
  console.log(persona[nombrePropiedad]);  
}

// Número 3: La función Object.values()
console.log('Distinta formas de imprimir un objeto: forma 3');
let personaArray = Object.values(persona);
console.log(personaArray);  

// Número 4: Utilizaremos el método JSON.stringify
console.log('Distinta formas de imprimir un objeto: forma 4');

let personaString = JSON.stringify(persona);// Con esta funcion las propiedades del objeto se convierten en cadena
console.log(personaString);  // {"nombre":"Carlos","apellido":"Gil","email":"cgil@gmail.com", ...}
