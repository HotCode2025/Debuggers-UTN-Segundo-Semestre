class Persona { // Clase padre

    static contadorPersonas = 0; // Atributo estático
    //valor default en el atributo //Atributo no estático
    email = 'valor default email';
    
    static get MAX_OBJ() { // Este método simula una constante
        return 5;
    }

    constructor(nombre, apellido){
        this.nombre = nombre;
        this.apellido = apellido;
        if(Persona.contadorPersonas < Persona.MAX_OBJ){
            this.idPersona = ++Persona.contadorPersonas;
        }
        else{
            console.log('Se ha superado el máximo de objetos permitidos');
        }
    }
    //console.log('Se incrementa el contador: ' +Persona.contadorPersonas);
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
        return this.idPersona + ' ' + this._nombre + ' ' + this._apellido;
    }
    toString(){
    //Regresa un String
    //El polimorfismo que significa = múltiples formas en un mismo método
    //que se ejecuta depende si es una referencia de tipo padre o hijo
    return this.nombreCompleto(); 
    }

    static saludar(){
        console.log('Saludos desde este método static'); 
    }

    saludar2(persona) {
        console.log(persona.nombre + ' ' + persona.apellido); 
    }
}

class Empleado extends Persona { //Clase hija
    constructor(nombre, apellido, departamento) {
        super(nombre, apellido);
        this.departamento = departamento;
    }

    get departamento(){
    return this._departamento;
    }

    set departamento(departamento){
        this._departamento = departamento;
    }

    //Sobreescritura
    nombreCompleto(){
        return super.nombreCompleto() + ', ' + this._departamento;
    }

}

let persona1 = new Persona("Martín", "Perez");
console.log(persona1.nombre); // Martín
console.log(persona1.apellido); // Juan Carlos

let persona2 = new Persona("Carlos", "Lara");
console.log(persona2.nombre); // María Laura

let empleado1 = new Empleado("María", "Gimenez", "Sistemas");
console.log(empleado1.nombreCompleto()); // María Gimenez, Sistemas

//Object.prototype.toString  Esta es la manera de acceder a atributos y métodos de un objeto
console.log(empleado1.toString()); 
console.log(persona1.toString()); 

// console.log(saludar(personal)); no se utiliza desde el objeto 
Persona.saludar(); // Saludos desde este método static

// persona1.saludar(); // No se puede acceder a un método static desde un objeto 
Persona.saludar(); 
persona1.saludar2(persona1); 

console.log(Persona.contadorObjetosPersona); 
console.log(Empleado.contadorObjetosPersona); 

console.log(persona1.email); 
console.log(empleado1.email); 

// No se puede acceder desde la instancia
console.log(persona1.toString()); 
console.log(persona2.toString()); 
//console.log(persona3.toString()); 
console.log(empleado1.toString()); 

let persona5 = new Persona('Carla', 'Pertosi');
console.log(persona5.toString()); // 4 Carla Pertosi

console.log(Persona.contadorPersonas); 

console.log(persona1.MAX_OBJ); // No se puede modificar, ni alterar
console.log(Persona.MAX_OBJ); 

let persona4 = new Persona('Renzo', 'Diaz'); 
console.log(persona4.toString());
//let persona5 = new Persona('Ana', 'Gomez'); // Se ha superado el máximo de objetos permitidos
console.log(persona5.toString());


