function Persona3(nombre, apellido, email){ //constructor
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
}
let padre = new Persona3('Leo', 'Lopez', 'lopezl@gmail.com');
console.log(padre);

let madre = new Persona3('Laura', 'Contrera', 'contreral@gmail.com');
console.log(madre);