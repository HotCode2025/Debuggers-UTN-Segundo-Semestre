class Persona{
    constructor(nombre,apellido){
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
    nombreCompleto(){
        return this._nombre+" "+this._apellido;
    }
    //sobreescribiendo el metodo de la clase padre (object)
    toString(){ //regresa un string
        //el metodo que se ejecuta depende si es una referencia de tipo padre o hija
        //se aplica el polimorfismo que significa multiples formas en tiempo de ejecucion
        return this.nombreCompleto();
    }
}

class Empleado extends Persona{ //clase HIja de la clase principal
    constructor(nombre, apellido,departamento){
        super(nombre, apellido);
        this._departamento = departamento;
    }
    get departamento(){
        return this._departamento;

    }
    set departamento(departamento){
        this._departamento = departamento;
    }
    //sobreescritura
    nombreCompleto(){
        return super.nombreCompleto()+", "+this._departamento;
    }
}

let persona1 = new Persona("Enzo", "Navarro")
console.log(persona1.nombre);
persona1.nombre = "Ricardo";
console.log(persona1.nombre);
let persona2 = new Persona("Sandra", "S.D`Avila");
console.log(persona2.nombre);
persona2.nombre = "Elizardo";
console.log(persona2.nombre);

let empleado1 = new Empleado("Gustavo","Moscatelli","Ventas");
console.log(empleado1);
console.log(empleado1.nombreCompleto());

//Object.prototype.toString esta es la manera de acceder a atributos y metodos de manera dinamica
console.log(empleado1.toString());
console.log(persona1.toString());

