// ------------------------------------------------------------------------------
// Funciones en JS
// ------------------------------------------------------------------------------
// 1.5 Tipos de datos en una función

console.log(typeof miFuncion);

function miFuncionDos(a, b) {
    console.log(arguments);
    console.log(arguments.length);
}

miFuncionDos(5, 7);

// toString
var miFuncionTexto = miFuncionDos.toString();
console.log(miFuncionTexto);

