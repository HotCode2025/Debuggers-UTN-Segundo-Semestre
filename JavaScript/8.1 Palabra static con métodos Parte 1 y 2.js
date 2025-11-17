// ------------------------------------------------------------------------------
// Clase 8 Static
// ------------------------------------------------------------------------------
// 8.1 Palabra static con métodos Parte 1 y 2

class Persona {
    constructor(nombre, apellido) {
        this._nombre = nombre;
        this._apellido = apellido;
    }
    get nombre() {
        return this._nombre;
    }
    get apellido() {
        return this._apellido;
    }
    set nombre(nombre) {
        this._nombre = nombre;
    }
    set apellido(apellido) {
        this._apellido = apellido;
    }
    nombreCompleto() {
        return this._nombre + ' ' + this._apellido;
    }
    // Sobrescribiendo el metodo de la clase padre
    toString() {
        return this.nombreCompleto();
    }

    static saludar() {
        console.log('Saludos desde el metodo static')
    }
    static saludar2(persona) {
        console.log(persona.nombre + ' ' + persona.apellido + ' saludos desde el metodo static')
    }
}

class Empleado extends Persona {
    constructor(nombre, apellido, departamento) {
        super(nombre, apellido);
        this._departamento = departamento;
    }
    get departamento() {
        return this._departamento;
    }
    set departamento(departamento) {
        this._departamento = departamento;
    }

    // Sobreescritura
    nombreCompleto() {
        return super.nombreCompleto() + ', ' + this._departamento;
    }
}

// -----------------------------------------------------
let persona1 = new Persona('Juan Carlos', 'Perez');

let empleado = new Empleado('Maria', 'Gimenez', 'Sistemas');
console.log(empleado);
console.log(empleado.nombre);

console.log(empleado.nombreCompleto());

// -----------------------------------------------------
console.log(empleado.toString());
console.log(persona1.toString());

// -----------------------------------------------------
Persona.saludar();

Persona.saludar2(persona1);

Empleado.saludar();
Empleado.saludar2(empleado);
