//let persona3 = new personalbar("Enzo","Navarro");
//Persona3 es un objeto, creado previo a la clase, por lo cual no es leido y no funciona, por eso estará comentado
//no se puede crear el objeto antes de la clase que le da la instancia
class Persona{
    constructor(nombre,apellido){
        this.nombre = nombre;
        this.apellido = apellido;

    }
    get nombre(){
        return this._nombre;

    }
    
    set nombre(nombre){
        this._nombre = nombre;
    }
}
let persona1 = new Persona("Rebeca","Navarro");
console.log(persona1.nombre);
persona1.nombre = "Ricardo";
console.log(persona1.nombre);
//console.log(persona1);
let persona2 = new Persona("Agostina","Martinez");
console.log(persona2.nombre);
persona2.nombre = "Hugo";
console.log(persona2.nombre);
//console.log(persona2);
