// ------------------------------------------------------------------------------
// Clase 4 - Objetos
// ------------------------------------------------------------------------------
// 
// 1.2 Agregamos métodos a los Objetos

// Objeto 
let persona = {
    nombre: 'Carlos',
    apellido: 'Gil',
    email: 'cgil@gmail.com',
    edad: '30',
    nombreCompleto: function() {
        return this.nombre + ' ' + this.apellido;
    }
}

console.log(persona.nombreCompleto());