// ------------------------------------------------------------------------------
// Clase 9 Herencia
// ------------------------------------------------------------------------------
// 9.2 Creación de la Clase Persona

class Persona {

    static contadorPersonas = 0; // Atributo estatico

    constructor(nombre, apellido, edad) {
        this.idPersona = ++Persona.contadorPersonas;

        this._nombre = nombre;      // encapsulado
        this._apellido = apellido;  // encapsulado
        this._edad = edad;          // encapsulado
    }

    get idPersona() {
        return this._idPersona;
    }
    get nombre() {
        return this._nombre;
    }
    get apellido() {
        return this._apellido;
    }
    get edad() {
        return this._edad;
    }
    set nombre(nombre) {
        this._nombre = nombre;
    }
    set apellido(apellido) {
        this._apellido = apellido;
    }
    set edad(edad) {
        this._edad = edad;
    }
    // Sobrescribiendo el metodo de la clase padre
    toString() {
        return `${this.idPersona} ${this._nombre} ${this._apellido} ${this._edad}`;
    }
}