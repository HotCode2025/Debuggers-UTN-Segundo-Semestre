// ------------------------------------------------------------------------------
// Clase 6 - Clases - Parte 1
// ------------------------------------------------------------------------------
// 6.1 Sintaxis de Clases en JavaScript: Parte 1 y 2

class Persona {
    constructor(nombre, apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
}

let persona1 = new Persona('Martin', 'Perez');
console.log(persona1);

let persona2 = new Persona('Carlos', 'Lara');
console.log(persona2);
