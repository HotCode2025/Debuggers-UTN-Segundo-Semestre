// ------------------------------------------------------------------------------
// Clase 5 Objetos Parte 2
// ------------------------------------------------------------------------------
// 5.1 Métodos get y set Parte 1 y 2

let persona = {
    nombre: 'Carlos',
    apellido: 'Gil',
    email: 'cgil@gmail.com',
    edad: 28,
    idioma: 'es',
    nombreCompleto: function() {
        return this.nombre + ' ' + this.apellido;
    },
    get nombreEdad() {
        return 'El nombre es: ' + this.nombre + ', Edad: ' + this.edad;
    },
    get lang() {
        return this.idioma.toUpperCase();
    },
    set lang(lang) {
        this.idioma = lang.toUpperCase();
    }
}

console.log(persona.nombreEdad);

console.log(persona.lang);

persona.lang = 'en';
console.log(persona.lang);