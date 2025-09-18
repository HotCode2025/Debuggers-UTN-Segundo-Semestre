let persona4 = {
  nombre: 'Juan',
  apellido: 'Perez',
  nombreCompleto2: function(titulo, telefono) {
    return titulo + ': ' + this.nombre + ' ' + this.apellido + ' ' + telefono;
    // return this.nombre + ' ' + this.apellido;
  }
}

let persona5 = {
  nombre: 'Carlos',
  apellido: 'Lara'
}

console.log(persona4.nombreCompleto2('Lic.', '5492618383834'));


console.log(persona4.nombreCompleto2.call(persona5, 'Ing.', '5492618585856'));


// Método apply
let arreglo = ['Ing.', '5492618686865'];

console.log(persona4.nombreCompleto2.apply(persona5, arreglo));
