//let persona3 = new Persona('Carla', 'Ponce'); esto no se debe hacer: Persona is not defined

class Persona { //Clase padre

    static contadorObjetosPersona = 0; //Atributo estatico
    email = 'Valor default email'; //Atributo no estatico

    constructor(nombre, apellido){
        this._nombre = nombre;
        this._apellido = apellido;
        Persona.contadorObjetosPersona++;
        console.log('Se incrementa el contador: '+Persona.contadorObjetosPersona);
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
        return this._nombre +' '+this._apellido;
    }

    //Sobreescribiando el metodo de la clase padre (Object)
    toString(){ //Regresa un String
        //Se aplica el polimorfismo que significa multiples formas en tiempo de ejecucion
        //El metodo que se ejecuta depende si es una referencia de tipo padre o hija
        return this.nombreCompleto();
    }

    static saludar(){
        console.log('Saludos desde este método static');
    }

    static saludar2(persona){
        console.log(persona.nombre+' '+persona.apellido);
    }

}

class Empleado extends Persona {
    constructor(nombre, apellido, departamento) {
        super(nombre, apellido); // obligatorio en herencia
        this._departamento = departamento;
    }

    get departamento(){
    return this._departamento;
    }

    set departamento(departamento){
    this._departamento = departamento;
    }

    //Sobreescritura modificar algun comportamiento de la clase padre
    nombreCompleto(){
        return super.nombreCompleto()+', '+this._departamento;
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

let empleado1 = new Empleado('Maria', 'Gimenez', 'Sistemas');
console.log(empleado1); 
console.log(empleado1.nombreCompleto());

//Object.prototype.toString Esta es la manera de acceder a atributos y metodos de manera dinamica
console.log(empleado1.toString());
console.log(persona1.toString());

//persona1.saludar(); no se utiliza desde el objeto
Persona.saludar();
Persona.saludar2(persona1);

Empleado.saludar();
Empleado.saludar2(empleado1);

//console.log(persona1.contadorObjetosPersona);
console.log(Persona.contadorObjetosPersona);
console.log(Empleado.contadorObjetosPersona);

console.log(persona1.email);
console.log(empleado1.email);
//console.log(Persona.email); No puede acceder desde la clase