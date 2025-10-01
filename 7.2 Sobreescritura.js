class Persona {
    constructor(nombre, apellido) {
        this._nombre = nombre;
        this._apellido = apellido;
    }

    get nombre() {
        return this._nombre;
    }

    set nombre(nombre){
        this._nombre= nombre;
    }
     nombreCompleto(){
        return this._nombre+" "+this._apellido;
     }
}
class empleado extends Persona{
    constructor(nombre,apellido,departamento){
        super(nombre,apellido)
        this._departamento=departamento;
    }
    get departamento(){
        return this._departamento;
    }
    set departamento(departamento){
        this._departamento=departamento;
    }

    //Sobre Escritura
    nombreCompleto(){
        return super.nombreCompleto() +" , "+this._departamento;
    }


}

let persona1 = new Persona('Martin', 'Perez');
console.log(persona1.nombre); 

persona1.nombre="Juan Carlos";
console.log(persona1.nombre);

let persona2 = new Persona('Carlos', 'Lara');
console.log(persona2.nombre);  

persona2.nombre="Maria Laura";
console.log(persona2.nombre);

let empleado1= new empleado("Laura", "GIMENEZ", "Sistemas");
console.log(empleado1)
console.log(empleado1.departamento)
console.log(empleado1.nombreCompleto())

    