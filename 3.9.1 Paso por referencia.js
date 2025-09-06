// ------------------------------------------------------------------------------
// Funciones en JS
// ------------------------------------------------------------------------------
// 1.9.1 Paso por referencia

const persona = {
    nombre: 'Juan',
    apellido: 'Lepez'
}

function cambiarValorObjeto(p1) {
    p1.nombre = 'Ignacio';
    p1.apellido = 'Perez';
}

console.log(persona);
cambiarValorObjeto(persona);
console.log(persona);

// ------------------------------------------------------------------------------

