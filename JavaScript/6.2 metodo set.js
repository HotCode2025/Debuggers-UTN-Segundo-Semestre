class Persona {
    constructor(nombre, apellido){
        this._nombre = nombre;
        this._apellido = apellido;
    }

    get nombre(){
        return this._nombre;
    }

    set nombre(nombre){
        this._nombre = nombre;
    }

    get apellido(){
        return this._apellido;
    }

    set apellido(apellido){
        this._apellido = apellido;
    }
}

let persona1 = new Persona('Martin', 'Perez');
console.log(persona1.nombre); // accedemos al metodo get
persona1.nombre = 'Juan Carlos'; // se llama al metodo set
console.log(persona1.nombre);
//console.log(persona1);
let persona2 = new Persona('Carlos', 'Lara');
persona2.nombre = 'Maria Laura'; // se llama al metodo set
console.log(persona2.nombre); 
//console.log(persona2);

//Tarea Crear el método get y set para el atributo de apellido, luego modificar el apellido a través del 
//set y mostrar con un console.log lo que es el get donde muestra el resultado obtenido.
let persona3 = new Persona('cachimbre', 'Robertopolis')
persona3.apellido = 'Pastrami';
console.log(persona3.apellido);
//console.log(persona3);
