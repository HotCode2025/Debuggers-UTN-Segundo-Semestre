// 5.6 El uso de call
let persona7 = {
    nombre: 'Juan',
    apellido: 'Perez',
    nombreCompleto7: function(titulo, telefono){
        return titulo+': '+this.nombre+' '+this.apellido+' '+telefono;
    }
}

let persona8 = {
    nombre: 'Carlos',
    apellido: 'Lara'
}

console.log(persona7.nombreCompleto7('Lic.', '549261435363'));
console.log(persona7.nombreCompleto7.call(persona7, 'Ing.', '549261985789'));